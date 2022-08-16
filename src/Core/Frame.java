package Core;

import Game.AutoCollection;
import Game.Bonus;
import Room.Arrangement;
import Room.Background;
import UI.Mouse_Listener;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private final int width = 800, height = 600;
    public final int count_auto = 9;
    public Arrangement arrangement;
    Background background;
    public Dealer dealer;
    private RepaintThread repaintThread;
    public Bonus bonus;
    public AutoCollection autoCollection;
    Frame(){
        super("Click::Car");

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int scr_width = (int)(screen.getWidth());
        int scr_height = (int)(screen.getHeight());

        setBounds(scr_width/2 - width/2, scr_height/2 - height/2,width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        arrangement = new Arrangement(this);
        bonus = new Bonus(this);
        autoCollection = new AutoCollection(this);
        dealer = new Dealer(this);
        repaintThread = new RepaintThread(this);
        background = new Background(this);

        addMouseListener(new Mouse_Listener(this));
        setVisible(true);
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}
