package Room;

import Core.Frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background extends JPanel {
    BufferedImage image;
    public Background(Frame frame){
        try {
            image = ImageIO.read(new File("image/background.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setBounds(0,0, frame.getWidth(), frame.getHeight());
        frame.add(this);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image,0,0,getWidth(), getHeight(),null);
    }
}
