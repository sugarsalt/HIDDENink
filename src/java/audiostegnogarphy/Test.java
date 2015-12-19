/*
 * Decompiled with CFR 0_102.
 */
package audiostegnogarphy;

import audiostegnogarphy.Decoder;
import audiostegnogarphy.Encoder;
import java.io.File;
import java.io.PrintStream;

public class Test {
    public static void main(String[] args) {
        String message = "hello";
        String filePath = "f:\\xperia.au";
        String outPath = filePath.substring(0, filePath.length() - 4) + "-Encoded.wav";
        Encoder encoder = new Encoder(new File(filePath));
        encoder.encodeMessage(message, outPath);
        System.out.println("Successfully encoded the message into " + outPath);
        System.out.println("Beginning decode");
        Decoder decoder = new Decoder(new File(outPath));
        System.out.println("The hidden message was: " + decoder.decodeMessage());
    }
}

