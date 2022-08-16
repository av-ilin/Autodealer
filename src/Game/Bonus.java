package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bonus extends JPanel {
    BufferedImage image;
    int width, height;
    int x, y, angle = 0, borderX, borderY;
    public boolean activate = false;
    BonusThread bonusThread;
    public Bonus(Frame frame){
        try {
            image = ImageIO.read(new File("image/cash.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        width = image.getWidth() / 10;
        height = image.getHeight() / 10;
        borderX = frame.getWidth() - width;
        borderY = frame.getHeight() - 200 - height;
        x = (int)(borderX * Math.random());
        y = (int)(borderY * Math.random());
        setBounds(x, y, width, height);
        setBackground(new Color(0,0,0,10));
        frame.add(this);
        bonusThread = new BonusThread(this);
        setVisible(false);
    }
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        super.paintComponent(g2);
        AffineTransform at = new AffineTransform(g2.getTransform());
        at.rotate(Math.toRadians(angle), width/2, height/2);
        g2.setTransform(at);
        g2.drawImage(image,0, 0,width, height, null);
    }
    public void change_angle(int angle){
        this.angle += angle;
    }
    public void change_location(){
        x = (int)(borderX * Math.random());
        y = (int)(borderY * Math.random());
        setLocation(x, y);
    }
}
