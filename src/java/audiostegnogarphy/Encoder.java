/*
 * Decompiled with CFR 0_102.
 */
package audiostegnogarphy;

import audiostegnogarphy.ASCII;
import audiostegnogarphy.AudioSampleReader;
import audiostegnogarphy.AudioSampleWriter;
import audiostegnogarphy.Complex;
import audiostegnogarphy.FFT;
import audiostegnogarphy.ASCII;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Encoder {

    File audioFile;

    public Encoder(File audioFile) {
        this.audioFile = audioFile;
    }

    public void encodeMessage(String message, String outPath) {
        System.out.println("OUTPOath  =  " + outPath);
        System.out.println("Message = "+message);
        try {
            ASCII phrase = new ASCII(message);
            System.out.println(this.audioFile);
            int[] messageAsBits = phrase.getBinaryBitArray();
            System.out.println(this.audioFile);
            int currentBit = 0;
            System.out.println(this.audioFile);
            AudioSampleReader sampleReader = new AudioSampleReader(this.audioFile);
            System.out.println("Here I am");
            int bytesRead = 0;
            int nbChannels = sampleReader.getFormat().getChannels();
            int totalBytes = (int) sampleReader.getSampleCount() * nbChannels;
            double[] out = new double[totalBytes];
            int bytesToRead = 8192;
            double[] audioData = new double[totalBytes];
            sampleReader.getInterleavedSamples(0, totalBytes, audioData);
            if (totalBytes / bytesToRead < messageAsBits.length) {
                throw new RuntimeException("The audio file is too short for the message to fit!");
            }
            while (bytesRead < totalBytes && currentBit < messageAsBits.length) {
                if (totalBytes - bytesRead < bytesToRead) {
                    bytesToRead = totalBytes - bytesRead;
                }
                double[] samples = new double[bytesToRead];
                for (int i = 0; i < samples.length; ++i) {
                    samples[i] = audioData[bytesRead + i];
                }
                bytesRead += bytesToRead;
                double[] channelOne = new double[samples.length / 2];
                sampleReader.getChannelSamples(0, samples, channelOne);
                FFT fft = new FFT();
                double[][] freqMag = FFT.getMag(channelOne, (int) sampleReader.getFormat().getFrameRate());
                channelOne = FFT.correctDataLength(channelOne);
                Complex[] complexData = new Complex[channelOne.length];
                for (int i2 = 0; i2 < channelOne.length; ++i2) {
                    complexData[i2] = new Complex(channelOne[i2], 0.0);
                }
                Complex[] complexMags = FFT.fft(complexData);
                double[] freqs = FFT.getFreqs(complexData.length, (int) sampleReader.getFormat().getFrameRate());
                double fundamentalAmp = 0.0;
                for (int i3 = 0; i3 < freqMag.length; ++i3) {
                    if (Math.abs(freqMag[i3][1]) <= fundamentalAmp) {
                        continue;
                    }
                    fundamentalAmp = freqMag[i3][1];
                }
                boolean isRest = false;
                if (fundamentalAmp < 0.01) {
                    isRest = true;
                }
                if (!(messageAsBits[currentBit] != 1 || isRest)) {
                    for (int i4 = 0; i4 < freqs.length; ++i4) {
                        if (Math.abs(Math.abs(freqs[i4]) - 20000.0) >= 5.0) {
                            continue;
                        }
                        complexMags[i4] = new Complex(0.01 * (double) channelOne.length, 0.0);
                    }
                    Complex[] ifft = FFT.ifft(complexMags);
                    double[] ifftReal = new double[ifft.length];
                    for (int i5 = 0; i5 < ifftReal.length; ++i5) {
                        ifftReal[i5] = ifft[i5].re();
                    }
                    Encoder.appendOutput(Encoder.interleaveSamples(ifftReal), bytesRead - bytesToRead, out);
                    ++currentBit;
                    continue;
                }
                if (!(messageAsBits[currentBit] != 0 || isRest)) {
                    Encoder.appendOutput(samples, bytesRead - bytesToRead, out);
                    ++currentBit;
                    continue;
                }
                if (!isRest) {
                    continue;
                }
                Encoder.appendOutput(samples, bytesRead - bytesToRead, out);
            }
            if (bytesRead < totalBytes) {
                double[] leftoverData = new double[totalBytes - bytesRead];
                for (int i = 0; i < leftoverData.length; ++i) {
                    leftoverData[i] = audioData[bytesRead + i];
                }
                Encoder.appendOutput(leftoverData, bytesRead, out);
            }
            File outFile = new File(outPath);
            AudioSampleWriter audioWriter = new AudioSampleWriter(outFile, sampleReader.getFormat(), AudioFileFormat.Type.WAVE);
            audioWriter.write(out);
            audioWriter.close();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("help");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("help me");
            e.printStackTrace();
        }
        catch(Exception ex){
            System.out.println("Oof!"+ex+"  "+ex.getMessage()+"###"+ex.getClass());
        }
    }

    private static double[] interleaveSamples(double[] mono) {
        double[] interleavedSamples = new double[mono.length * 2];
        int interleavedSamplesCounter = 0;
        for (int i = 0; i < mono.length; ++i) {
            interleavedSamples[interleavedSamplesCounter] = mono[i];
            interleavedSamples[++interleavedSamplesCounter] = mono[i];
            ++interleavedSamplesCounter;
        }
        return interleavedSamples;
    }

    private static void appendOutput(double[] in, int startIndex, double[] out) {
        for (int i = 0; i < in.length; ++i) {
            out[startIndex] = in[i];
            ++startIndex;
        }
    }
}
