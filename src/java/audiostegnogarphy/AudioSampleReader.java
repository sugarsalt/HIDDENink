/*
 * Decompiled with CFR 0_102.
 */
package audiostegnogarphy;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioSampleReader {
    private AudioInputStream audioInputStream;
    private AudioFormat format;

    public AudioSampleReader(File file) throws UnsupportedAudioFileException, IOException {
        this.audioInputStream = AudioSystem.getAudioInputStream(file);
        this.format = this.audioInputStream.getFormat();
    }

    public AudioFormat getFormat() {
        return this.format;
    }

    public long getSampleCount() {
        long total = this.audioInputStream.getFrameLength() * (long)this.format.getFrameSize() * 8 / (long)this.format.getSampleSizeInBits();
        return total / (long)this.format.getChannels();
    }

    public void getInterleavedSamples(long begin, long end, double[] samples) throws IOException, IllegalArgumentException {
        long nbSamples = end - begin;
        long nbBytes = nbSamples * (long)(this.format.getSampleSizeInBits() / 8) * (long)this.format.getChannels();
        if (nbBytes > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("too many samples");
        }
        byte[] inBuffer = new byte[(int)nbBytes];
        this.audioInputStream.read(inBuffer, 0, inBuffer.length);
        this.decodeBytes(inBuffer, samples);
    }

    public void getChannelSamples(int channel, double[] interleavedSamples, double[] channelSamples) {
        int nbChannels = this.format.getChannels();
        for (int i = 0; i < channelSamples.length; ++i) {
            channelSamples[i] = interleavedSamples[nbChannels * i + channel];
        }
    }

    public void getStereoSamples(double[] leftSamples, double[] rightSamples) throws IOException {
        long sampleCount = this.getSampleCount();
        double[] interleavedSamples = new double[(int)sampleCount * 2];
        this.getInterleavedSamples(0, sampleCount, interleavedSamples);
        for (int i = 0; i < leftSamples.length; ++i) {
            leftSamples[i] = interleavedSamples[2 * i];
            rightSamples[i] = interleavedSamples[2 * i + 1];
        }
    }

    private void decodeBytes(byte[] audioBytes, double[] audioSamples) {
        int sampleSizeInBytes = this.format.getSampleSizeInBits() / 8;
        int[] sampleBytes = new int[sampleSizeInBytes];
        int k = 0;
        for (int i = 0; i < audioSamples.length; ++i) {
            double val;
            int j;
            if (this.format.isBigEndian()) {
                for (j = 0; j < sampleSizeInBytes; ++j) {
                    sampleBytes[j] = audioBytes[k++];
                }
            } else {
                for (j = sampleSizeInBytes - 1; j >= 0; --j) {
                    sampleBytes[j] = audioBytes[k++];
                    if (sampleBytes[j] == 0) continue;
                    j+=0;
                }
            }
            int ival = 0;
            for (int j2 = 0; j2 < sampleSizeInBytes; ++j2) {
                ival+=sampleBytes[j2];
                if (j2 >= sampleSizeInBytes - 1) continue;
                ival<<=8;
            }
            double ratio = Math.pow(2.0, this.format.getSampleSizeInBits() - 1);
            audioSamples[i] = val = (double)ival / ratio;
        }
    }
}

