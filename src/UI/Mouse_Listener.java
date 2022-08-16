package UI;

import Core.Frame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse_Listener implements MouseListener {
    int counter = 0;
    Frame frame;
    public Mouse_Listener(Frame frame){
        this.frame = frame;
    }
    public void mouseClicked(MouseEvent e) {
        if(!frame.bonus.activate)
            counter++;

        if(counter == 50){
            counter = 0;
            frame.bonus.activate = true;
            frame.bonus.setVisible(true);
        }

        if (frame.bonus.activate){
            Point bonusLocation = frame.bonus.getLocation();
            Point mouseLocation = frame.getMousePosition();
            int bonus_x = (int) bonusLocation.getX();
            int bonus_y = (int) bonusLocation.getY();
            int mouse_x = (int) mouseLocation.getX();
            int mouse_y = (int) mouseLocation.getY();

            if (bonus_x <= mouse_x && mouse_x <= bonus_x + frame.bonus.getWidth())
                if (bonus_y <= mouse_y && mouse_y <= bonus_y + frame.bonus.getHeight())
                    frame.dealer.bonus_click();
        }

        frame.dealer.click();
    }
    public void mousePressed(MouseEvent e) {

    }
    public void mouseReleased(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseExited(MouseEvent e) {

    }
}
