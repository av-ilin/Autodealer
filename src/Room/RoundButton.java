package Room;

import javax.swing.*;
import java.awt.*;

public class RoundButton extends JButton {
    private final int arcW, arcH;
    RoundButton(String text){
        super(text);

        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);

        arcH = arcW = 50;

        setContentAreaFilled(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.GRAY);//Цвет фона при нажатой кнопке
            setForeground(getForeground());//Цвет надписи при нажатой кнопке
        } else {
            g.setColor(getBackground());//Цвет фона
            setForeground(getForeground());//Цвет надписи
        }
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, arcW, arcH);
        super.paintComponent(g);
    }
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, arcW,arcH);
    }
}
