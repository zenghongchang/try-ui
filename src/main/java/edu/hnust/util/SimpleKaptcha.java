package edu.hnust.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class SimpleKaptcha {
    public static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";    
    public static Random random = new Random();    
    public static String KAPTCHA_CODE_IN_SESSION = "kaptcha_code_in_session";    
    private static Color getRandColor(int fc, int bc) {
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
    
    public static String create(Integer width, Integer height, Integer num, Integer xs, Integer ys, Integer xFac, Integer yFac, OutputStream out) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        
        for (int i = 0; i < 100; i++) {
            g.setColor(getRandColor(100, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        String retStr = "";
        for (int i = 0; i < num; i++) {
            int a = random.nextInt(letters.length() - 1);
            String rand = letters.substring(a, a + 1);
            retStr += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, xs * (i + 1) + xFac, ys + 3 * random.nextInt(yFac));
        }
        g.dispose();
        try {
            ImageIO.write(image, "JPEG", out);
        } catch (IOException e) {
            e.printStackTrace();
        }        
        return retStr;
    }
}