/*
 * Decompiled with CFR 0_102.
 */
package audiostegnogarphy;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Decoder {
    File audioFile;

    public Decoder(File audioFile) {
        this.audioFile = audioFile;
    }

    public String decodeMessage() {
        String hiddenMessage = "";
        try {
            AudioSampleReader sampleReader = new AudioSampleReader(this.audioFile);
            int bytesRead = 0;
            int nbChannels = sampleReader.getFormat().getChannels();
            int totalBytes = (int)sampleReader.getSampleCount() * nbChannels;
            int bytesToRead = 8192;
            String[] messageAsBytes = new String[totalBytes / bytesToRead];
            int currentCharIndex = 0;
            int bitsSaved = 0;
            System.out.println("totalBytes: " + totalBytes);
            double[] audioData = new double[totalBytes];
            sampleReader.getInterleavedSamples(0, totalBytes, audioData);
            while (bytesRead < totalBytes) {
                if (totalBytes - bytesRead < bytesToRead) {
                    bytesToRead = totalBytes - bytesRead;
                }
                double[] samples = new double[bytesToRead];
                for (int i = 0; i < samples.length; ++i) {
                    samples[i] = audioData[bytesRead + i];
                }
                bytesRead+=bytesToRead;
                double[] channelOne = new double[samples.length / 2];
                sampleReader.getChannelSamples(0, samples, channelOne);
                FFT fft = new FFT();
                channelOne = FFT.correctDataLength(channelOne);
                double[][] freqMag = FFT.getMag(channelOne, (int)sampleReader.getFormat().getFrameRate());
                double fundamentalAmp = 0.0;
                for (int i2 = 0; i2 < freqMag.length; ++i2) {
                    if (Math.abs(freqMag[i2][1]) <= fundamentalAmp) continue;
                    fundamentalAmp = freqMag[i2][1];
                }
                boolean isRest = false;
                if (fundamentalAmp < 0.01) {
                    isRest = true;
                }
                double ampToTest = 0.0;
                if (!isRest) {
                    for (int i3 = 0; i3 < freqMag.length; ++i3) {
                        if (Math.abs(Math.abs(freqMag[i3][0]) - 20000.0) >= 5.0) continue;
                        ampToTest = freqMag[i3][1];
                    }
                }
                if (isRest) continue;
                messageAsBytes[currentCharIndex] = ampToTest > 0.009 ? (messageAsBytes[currentCharIndex] == null ? "1" : "1" + messageAsBytes[currentCharIndex]) : (messageAsBytes[currentCharIndex] == null ? "0" : "0" + messageAsBytes[currentCharIndex]);
                if (++bitsSaved % 8 != 0) continue;
                if (messageAsBytes[currentCharIndex].equals("00000000")) {
                    System.out.println("The message is over.");
                    break;
                }
                ++currentCharIndex;
            }
            hiddenMessage = Decoder.constructMessage(messageAsBytes);
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("Error 1= "+e.getMessage());
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Error 2= "+e.getMessage());
            e.printStackTrace();
        }
        return hiddenMessage;
    }

    private static String constructMessage(String[] messageInBinary) {
        String message = "";
        for (int i = 0; i < messageInBinary.length; ++i) {
            int byteAsInt = Decoder.byteToInt(messageInBinary[i]);
            if (byteAsInt == -1) continue;
            message = message + String.valueOf((char)byteAsInt);
        }
        return message;
    }

    private static int byteToInt(String byteAsString) {
        if (byteAsString == null) {
            return -1;
        }
        int byteAsInt = Integer.parseInt(byteAsString);
        int intValue = 0;
        for (int i = 1; i < 9; ++i) {
            if (Decoder.numberOfPlaces((int)((double)byteAsInt % Math.pow(10.0, i))) != i || (double)byteAsInt % Math.pow(10.0, i) == 0.0) continue;
            intValue = (int)((double)intValue + Math.pow(2.0, i - 1));
        }
        return intValue;
    }

    private static int numberOfPlaces(int num) {
        int toReturn = num > 9999999 ? 8 : (num > 999999 ? 7 : (num > 99999 ? 6 : (num > 9999 ? 5 : (num > 999 ? 4 : (num > 99 ? 3 : (num > 9 ? 2 : 1))))));
        return toReturn;
    }

   /*public static void main(String[] args) {
        String filePath ="C:\\Users\\hi\\Documents\\NetBeansProjects\\hiddenInk\\web\\uploads\\xperi-Encoded.wav";
        Decoder decoder = new Decoder(new File(filePath));
        System.out.println("The hidden message was: " + decoder.decodeMessage());
    }*/
}

