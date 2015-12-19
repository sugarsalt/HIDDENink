/*
 * Decompiled with CFR 0_102.
 */
package audiostegnogarphy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class AudioSampleWriter
implements Runnable {
    File file;
    AudioFormat format;
    AudioFileFormat.Type targetType;
    PipedOutputStream pos;
    PipedInputStream pis;
    AudioInputStream ais;
    byte[] bytes;

    public AudioSampleWriter(File file, AudioFormat format, AudioFileFormat.Type targetType) throws IOException {
        this.format = format;
        this.targetType = targetType;
        this.file = file;
        this.pos = new PipedOutputStream();
        this.pis = new PipedInputStream(this.pos);
        this.ais = new AudioInputStream(this.pis, format, -1);
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            AudioSystem.write(this.ais, this.targetType, this.file);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write(double[] interleavedSamples) throws IOException {
        this.writeInterleavedSamples(interleavedSamples, interleavedSamples.length);
    }

    public void writeInterleavedSamples(double[] interleavedSamples, int sampleCount) throws IOException {
        int numBytes = sampleCount * (this.format.getSampleSizeInBits() / 8);
        System.out.println("numBytesOut=" + numBytes);
        if (this.bytes == null || numBytes > this.bytes.length) {
            this.bytes = new byte[numBytes];
        }
        this.encodeSamples(interleavedSamples, this.bytes, sampleCount);
        this.pos.write(this.bytes, 0, numBytes);
    }

    public void close() throws IOException {
        if (this.pos != null) {
            this.ais.close();
            this.pis.close();
            this.pos.close();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void encodeSamples(double[] audioData, byte[] audioBytes, int length) {
        if (this.format.getSampleSizeInBits() == 16) {
            if (this.format.isBigEndian()) {
                for (int i = 0; i < length; ++i) {
                    int in = (int)(audioData[i] * 32767.0);
                    audioBytes[2 * i] = (byte)(in >> 8);
                    audioBytes[2 * i + 1] = (byte)(in & 255);
                }
                return;
            }
            for (int i = 0; i < length; ++i) {
                int in = (int)(audioData[i] * 32767.0);
                audioBytes[2 * i] = (byte)(in & 255);
                audioBytes[2 * i + 1] = (byte)(in >> 8);
            }
            return;
        }
        if (this.format.getSampleSizeInBits() != 8) return;
        if (this.format.getEncoding().toString().startsWith("PCM_SIGN")) {
            for (int i = 0; i < length; ++i) {
                audioBytes[i] = (byte)(audioData[i] * 127.0);
            }
            return;
        }
        for (int i = 0; i < length; ++i) {
            audioBytes[i] = (byte)(audioData[i] * 127.0 + 127.0);
        }
    }
}

