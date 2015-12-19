package videoStegagography;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import sun.audio.AudioStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hi
 */
public class VideoEncoderAndDecoder {

    String Ekey, Dkey, address, name;
    File Ofilename, Sfilename, tempfilename;
    InputStream ins;
    AudioStream as;
    Thread t;
    String temp = null;

    public VideoEncoderAndDecoder() {
    }

    synchronized public void Audioencrypt(String message, File file, int key, File fin, String TxtPath) throws Exception {
        byte b[] = new byte[1];
        BigInteger Abi, Mbi;
        temp = message;
        int k, k1;
        InputStream ins = new FileInputStream(file);
        OutputStream outs = new FileOutputStream(fin);
        File f = new File(TxtPath+"//abc.txt");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(temp.getBytes());
        fos.flush();
        fos.close();

        for (int c = 0; c < key; c++) {
            int ch = ins.read();
            outs.write(ch);
        }
        int len = message.length();
        byte mess[] = new byte[1];
        char chmess[] = new char[len + 1];
        k = k1 = 0;
        for (int i = 0; i <= len; i++) {
            message.getChars(0, len, chmess, 0);
            if (i == 0) {
                BigDecimal bd = new BigDecimal(len);
                BigInteger Blen = bd.toBigInteger();
                String Slen = Blen.toString(2);
                char Clen[] = new char[Blen.bitLength()];
                Slen.getChars(0, Blen.bitLength(), Clen, 0);
                for (int j = 0; j <= 7; j++) {
                    if (j == 0) {
                        for (k = 0; k < 8 - Blen.bitLength(); k++) {
                            int n = ins.read(b);
                            Abi = new BigInteger(b);
                            String Aby = Abi.toString(2);
                            int Alen = Abi.bitLength();
                            if (b[0] < 0) {
                                Alen++;
                            }
                            char Ach[] = new char[Alen + 1];
                            Aby.getChars(0, Alen, Ach, 0);

                            if (b[0] == 0) {
                            } else {
                                if (Ach[Alen - 1] == '1') {
                                    if (Alen == Abi.bitLength()) {
                                        BigInteger bi = new BigInteger(
                                                "11111110", 2);
                                        BigInteger big = Abi.and(bi);
                                        b = big.toByteArray();
                                    } else {
                                        BigInteger bi = new BigInteger("-1", 2);
                                        BigInteger big = Abi.subtract(bi);
                                        b = big.toByteArray();
                                    }
                                }
                                outs.write(b);
                            }
                        } // for loop k
                        j = j + k - 1;
                    } // if of j
                    else {
                        int n = ins.read(b);
                        Abi = new BigInteger(b);
                        String Aby = Abi.toString(2);
                        int Alen = Abi.bitLength();
                        if (b[0] < 0) {
                            Alen++;
                        }
                        char Ach[] = new char[Alen + 1];
                        Aby.getChars(0, Alen, Ach, 0);
                        if (b[0] == 0) {
                            Alen = 1;
                        }
                        if (Clen[j - k] == '0' && Ach[Alen - 1] == '1') {
                            if (Alen == Abi.bitLength()) {
                                BigInteger bi = new BigInteger("11111110", 2);
                                BigInteger big = Abi.and(bi);
                                b = big.toByteArray();
                            } else {
                                BigInteger bi = new BigInteger("-1", 2);
                                BigInteger big = Abi.subtract(bi);
                                b = big.toByteArray();
                            }
                        } else if (Clen[j - k] == '1' && Ach[Alen - 1] == '0') {
                            if (Alen == Abi.bitLength()) {
                                BigInteger bi = new BigInteger("1", 2);
                                BigInteger big = Abi.add(bi);
                                b = big.toByteArray();
                            } else {
                                BigInteger bi = new BigInteger("-1", 2);
                                BigInteger big = Abi.add(bi);
                                b = big.toByteArray();
                            }

                        }
                        outs.write(b);
                    } // end else

                } // for loop j

            } // end of if
            else {
                String slen = String.valueOf(chmess[i - 1]);
                byte blen[] = slen.getBytes();
                BigInteger Blen = new BigInteger(blen);
                String Slen = Blen.toString(2);
                char Clen[] = new char[Blen.bitLength()];
                Slen.getChars(0, Blen.bitLength(), Clen, 0);
                for (int j = 0; j <= 7; j++) {
                    if (j == 0) {
                        for (k1 = 0; k1 < 8 - Blen.bitLength(); k1++) {
                            int n = ins.read(b);
                            Abi = new BigInteger(b);
                            String Aby = Abi.toString(2);
                            int Alen = Abi.bitLength();
                            if (b[0] < 0) {
                                Alen++;
                            }
                            char Ach[] = new char[Alen + 1];
                            Aby.getChars(0, Alen, Ach, 0);
                            if (b[0] == 0) {
                            } else {
                                if (Ach[Alen - 1] == '1') {
                                    if (Alen == Abi.bitLength()) {
                                        BigInteger bi = new BigInteger(
                                                "11111110", 2);
                                        BigInteger big = Abi.and(bi);
                                        b = big.toByteArray();
                                    } else {
                                        BigInteger bi = new BigInteger("-1", 2);
                                        BigInteger big = Abi.subtract(bi);
                                        b = big.toByteArray();
                                    }
                                }
                            }
                            outs.write(b);

                        } // for loop k

                        j = j + k1 - 1;

                    } // if of j
                    else {
                        int n = ins.read(b);
                        Abi = new BigInteger(b);
                        String Aby = Abi.toString(2);
                        int Alen = Abi.bitLength();
                        if (b[0] < 0) {
                            Alen++;
                        }
                        char Ach[] = new char[Alen + 1];
                        Aby.getChars(0, Alen, Ach, 0);
                        if (b[0] == 0) {
                            Alen = 1;
                        }

                        if (Clen[j - k1] == '0' && Ach[Alen - 1] == '1') {
                            if (Alen == Abi.bitLength()) {
                                BigInteger bi = new BigInteger("11111110", 2);
                                BigInteger big = Abi.and(bi);
                                b = big.toByteArray();
                            } else {
                                BigInteger bi = new BigInteger("-1", 2);
                                BigInteger big = Abi.subtract(bi);
                                b = big.toByteArray();
                            }
                        } else if (Clen[j - k1] == '1' && Ach[Alen - 1] == '0') {
                            if (Alen == Abi.bitLength()) {
                                BigInteger bi = new BigInteger("1", 2);
                                BigInteger big = Abi.add(bi);
                                b = big.toByteArray();
                            } else {
                                BigInteger bi = new BigInteger("-1", 2);
                                BigInteger big = Abi.add(bi);
                                b = big.toByteArray();
                            }
                        }
                        outs.write(b);
                    } // end else

                } // for loop j
            } // end of else

        } // for loop i

        // while(true)
        // {
        int i = ins.read();
        // if(i==-1)
        outs.write(i);
        // }
        ins.close();

        System.out.println("temp" + temp);
        outs.flush();
        outs.close();
    }

    public String Audiodecrypt(File filename, int key, String FPath) throws Exception {
        InputStream ins = new FileInputStream(filename);
        byte b[] = new byte[1];
        BigInteger bb1;
        char mess[] = new char[8];
        int c = 0;
        for (int i = 0; i < key; i++) {
            int n = ins.read();
        }
        for (int i = 0; i < 8; i++) {
            ins.read(b);
            bb1 = new BigInteger(b);
            String str = bb1.toString(2);
            int len = bb1.bitLength();
            if (b[0] < 0) {
                len++;
            }
            char ch[] = new char[len + 1];
            str.getChars(0, len, ch, 0);
            if (b[0] == 0) {
                mess[i] = '0';
            } else {
                mess[i] = ch[len - 1];
            }
        }
        String dd = new String(mess);
        BigInteger bb = new BigInteger(dd, 2);
        String s = bb.toString(2);
        int l = bb.intValue();

        char me[] = new char[l];
        int count = 0;

        for (int m = 0; m < l; m++) {
            for (int i = 0; i < 8; i++) {
                ins.read(b);
                bb1 = new BigInteger(b);
                String str = bb1.toString(2);
                int len = bb1.bitLength();
                if (b[0] < 0) {
                    len++;
                }
                char ch[] = new char[len + 1];
                str.getChars(0, len, ch, 0);
                if (b[0] == 0) {
                    mess[i] = '0';
                } else {
                    mess[i] = ch[len - 1];
                }
            }
            String dd1 = new String(mess);
            BigInteger bb2 = new BigInteger(dd1, 2);
            String s1 = bb2.toString(2);
            int l1 = bb2.intValue();
            me[count] = (char) l1;
            count++;
        }
        String message = "";

        File f = new File(FPath + "/abc.txt");

        if (!f.exists() && f.length() < 0) {
            message = "The message could not be decrypted.";
        } else {
            FileInputStream fis = new FileInputStream(f);
            byte byt = 0;

            while (byt != -1) {
                byt = (byte) fis.read();
                message = message + (char) byt;
            }
            System.out.println("Message " + message);
            fis.close();
        }

        System.out.println("ME " + me);

        //message = new String(me);
        message = message.substring(0, message.length() - 1);

        ins.close();
        return message;

    }
}
