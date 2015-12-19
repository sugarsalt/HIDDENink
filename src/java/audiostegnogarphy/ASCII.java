/*
 * Decompiled with CFR 0_102.
 */
package audiostegnogarphy;

public class ASCII {
    String phrase;

    public ASCII(String input) {
        this.phrase = input;
    }

    public int[] getBinaryBitArray() {
        String[] binaryStrings = this.getBinaryStrings();
        int[] binaryInts = new int[binaryStrings.length * 8];
        int currentString = 0;
        int i = 0;
        while (i < binaryInts.length) {
            char[] binary = binaryStrings[currentString].toCharArray();
            ++currentString;
            for (int j = 0; j < binary.length; ++j) {
                binaryInts[i] = binary[j] - 48;
                ++i;
            }
        }
        return binaryInts;
    }

    public String[] getBinaryStrings() {
        int i;
        char[] chars = this.getChars();
        String[] binaryStrings = new String[chars.length];
        for (i = 0; i < chars.length; ++i) {
            char ascii = chars[i];
            binaryStrings[i] = Integer.toBinaryString(ascii);
        }
        for (i = 0; i < binaryStrings.length; ++i) {
            if (binaryStrings[i].length() >= 8) continue;
            for (int j = 0; j <= 8 - binaryStrings[i].length(); ++j) {
                binaryStrings[i] = "0" + binaryStrings[i];
            }
        }
        for (i = 0; i < binaryStrings.length; ++i) {
            char[] binary = binaryStrings[i].toCharArray();
            String reversedBinary = "";
            for (int j = binary.length - 1; j >= 0; --j) {
                reversedBinary = reversedBinary + binary[j];
            }
            binaryStrings[i] = reversedBinary;
        }
        return binaryStrings;
    }

    public char[] getChars() {
        return this.phrase.toCharArray();
    }
}

