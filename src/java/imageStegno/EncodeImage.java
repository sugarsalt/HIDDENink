/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageStegno;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author hi
 */
public class EncodeImage {

    BufferedImage sourceImage = null, embeddedImage = null;
    File ImageFile;

    public EncodeImage(File ImageFile) {
        this.ImageFile = ImageFile;
    }

    public void embedMessage(String message) throws IOException {
        sourceImage = ImageIO.read(ImageFile);
        String mess = message;
        embeddedImage = sourceImage.getSubimage(0, 0, sourceImage.getWidth(), sourceImage.getHeight());
        embedMessage(embeddedImage, mess);
        //JLabel l = new JLabel(new ImageIcon(embeddedImage));
        //embeddedPane.getViewport().add(l);
        //this.validate();
    }

    private void embedMessage(BufferedImage img, String mess) {
        int messageLength = mess.length();

        int imageWidth = img.getWidth(), imageHeight = img.getHeight(),
                imageSize = imageWidth * imageHeight;
        if (messageLength * 8 + 32 > imageSize) {
            System.out.println("Message too long!");
            return;
        }
        embedInteger(img, messageLength, 0, 0);
        byte b[] = mess.getBytes();
        for (int i = 0; i < b.length; i++) {
            embedByte(img, b[i], i * 8 + 32, 0);
        }
    }

    private void embedInteger(BufferedImage img, int n, int start, int storageBit) {
        int maxX = img.getWidth(), maxY = img.getHeight(),
                startX = start / maxY, startY = start - startX * maxY, count = 0;
        for (int i = startX; i < maxX && count < 32; i++) {
            for (int j = startY; j < maxY && count < 32; j++) {
                int rgb = img.getRGB(i, j), bit = getBitValue(n, count);
                rgb = setBitValue(rgb, storageBit, bit);
                img.setRGB(i, j, rgb);
                count++;
            }
        }
    }

    private void embedByte(BufferedImage img, byte b, int start, int storageBit) {
        int maxX = img.getWidth(), maxY = img.getHeight(),
                startX = start / maxY, startY = start - startX * maxY, count = 0;
        for (int i = startX; i < maxX && count < 8; i++) {
            for (int j = startY; j < maxY && count < 8; j++) {
                int rgb = img.getRGB(i, j), bit = getBitValue(b, count);
                rgb = setBitValue(rgb, storageBit, bit);
                img.setRGB(i, j, rgb);
                count++;
            }
        }
    }

    public void saveImage(String outpath) {

        try {
            if (embeddedImage == null) {
                System.out.println("No message has been embedded!\n Nothing to save");
                return;
            }
            FileOutputStream fout=new FileOutputStream(outpath);
            ImageIO.write(embeddedImage, "PNG", fout);
            fout.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int getBitValue(int n, int location) {
        int v = n & (int) Math.round(Math.pow(2, location));
        return v == 0 ? 0 : 1;
    }

    private int setBitValue(int n, int location, int bit) {
        int toggle = (int) Math.pow(2, location), bv = getBitValue(n, location);
        if (bv == bit) {
            return n;
        }
        if (bv == 0 && bit == 1) {
            n |= toggle;
        } else if (bv == 1 && bit == 0) {
            n ^= toggle;
        }
        return n;
    }
}
