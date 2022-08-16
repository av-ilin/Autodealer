package Game;

import Core.Frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class AutoCollection extends JPanel {
    private final int width;
    private final int height;
    public final int count;
    public final int frame_size_w;
    public int current_id = 0;
    public ArrayList<Auto> autos;
    private final BufferedImage block;
    private AutoAnimationThread autoAnimationThread;
    public AutoCollection(Frame frame){
        try {
            block = ImageIO.read(new File("image/block.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        autos = new ArrayList<>();
        count = frame.count_auto;
        for(int i = 0; i < count; i++)
            autos.add(i, new Auto(i));

        autoAnimationThread = new AutoAnimationThread(this);
        frame_size_w = frame.getWidth();

        int locationY = frame.arrangement.car.getLocation().y + frame.arrangement.car.getHeight();
        height = frame.arrangement.but02.getLocation().y - locationY;
        width = (int) (frame.getWidth() * (height * 1.0 / frame.getHeight()));
        int locationX = frame.getWidth() / 2 - width / 2;

        setBounds(locationX, locationY, width, height);
        setBackground(new Color(0,0,0,10));
        frame.add(this);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(autos.get(current_id).enable)
            g.drawImage(autos.get(current_id).image, 0, 0, width, height, null);
        else
            g.drawImage(block, 0, 0, width, height, null);
    }
    public void prevAuto(){
        if(current_id > 0) {
            current_id--;
            setLocation(-getWidth(),getY());
            autoAnimationThread.work = true;
            autoAnimationThread.side = true;
        }
    }
    public void nextAuto(){
        if(current_id < count - 1){
            current_id++;
            setLocation(frame_size_w,getY());
            autoAnimationThread.work = true;
            autoAnimationThread.side = false;
        }
    }
}
