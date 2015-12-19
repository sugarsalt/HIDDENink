/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageStegno;

/**
 *
 * @author hi
 */
public class ImageEncryptionAndDecryption {

    public ImageEncryptionAndDecryption() {
    }

    public String encrypt(String messages) {
        System.out.println(messages);
        int len = messages.length();
        System.out.println(len);
        char mess[] = messages.toCharArray();
        System.out.println(mess);
        char newMess[] = new char[len];
        if (len % 2 == 0) {
            for (int i = 0; i < len; i = i + 2) {
                newMess[i] = mess[i + 1];
                newMess[i + 1] = mess[i];
            }
        } else {
            for (int i = 0; i < len - 1; i = i + 2) {
                newMess[i] = mess[i + 1];
                newMess[i + 1] = mess[i];
            }
            newMess[len - 1] = mess[len - 1];
        }

        String encodeMess = "";
        for (int i = 0; i < len; i++) {
            encodeMess=encodeMess+newMess[i];
        }
        System.out.println(encodeMess);
        return encodeMess;

    }
}
