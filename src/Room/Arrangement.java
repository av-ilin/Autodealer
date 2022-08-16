package Room;

import Core.Frame;
import UI.Button_Listener;

import javax.swing.*;
import java.awt.*;

public class Arrangement {
    public RoundButton but01, but02, but03, but04, but05, but06, but07;
    public JTextField money, car;
    private final int button_width = 100, button_height = 50;
    public final int text_width = 300, text_height = 25;
    Button_Listener button_listener;
    public Arrangement(Frame frame){
        money = new JTextField();
        money.setBounds(frame.getWidth()/2 - text_width/2, 0, text_width, text_height);
        money.setText("Cash: 0$");
        money.setHorizontalAlignment(JTextField.CENTER);
        money.setEnabled(false);
        money.setDisabledTextColor(Color.GREEN);
        money.setBackground(new Color(0, 0,0, 10));
        money.setFont(new Font("Times new Roman", Font.BOLD, 20));
        frame.add(money);

        car = new JTextField();
        car.setBounds(frame.getWidth()/2 - text_width/2, text_height + 10, text_width, text_height);
        car.setText("Unknown: 162$");
        car.setHorizontalAlignment(JTextField.CENTER);
        car.setEnabled(false);
        car.setDisabledTextColor(Color.WHITE);
        car.setBackground(new Color(0, 0,0, 10));
        car.setFont(new Font("Times new Roman", Font.BOLD, 20));
        frame.add(car);

        int butLocationY = frame.getHeight() - 50 - button_height;
        int butLocationX = frame.getWidth()/6 - button_width/2;
        button_listener = new Button_Listener(frame);

        but01 = new RoundButton("Prev");
        but01.setBounds(butLocationX, butLocationY, button_width, button_height);
        but01.addActionListener(button_listener);
        but01.setEnabled(false);
        but01.setVisible(false);
        but01.setForeground(Color.WHITE);
        but01.setBackground(Color.BLACK);
        frame.add(but01);

        butLocationX = frame.getWidth()/2 - button_width/2;
        but02 = new RoundButton("Buy");
        but02.setBounds(butLocationX, butLocationY, button_width, button_height);
        but02.addActionListener(button_listener);
        but02.setForeground(Color.WHITE);
        but02.setBackground(Color.BLACK);
        frame.add(but02);

        butLocationX = frame.getWidth() - frame.getWidth()/6 - button_width/2;
        but03 = new RoundButton("Next");
        but03.setBounds(butLocationX, butLocationY, button_width, button_height);
        but03.addActionListener(button_listener);
        but03.setForeground(Color.WHITE);
        but03.setBackground(Color.BLACK);
        frame.add(but03);

        butLocationX = frame.getWidth() - button_width - 20;
        but04 = new RoundButton("Save");
        but04.setBounds(butLocationX, 10, button_width, button_height);
        but04.setForeground(Color.WHITE);
        but04.setBackground(Color.BLACK);
        but04.addActionListener(button_listener);
        frame.add(but04);

        but05 = new RoundButton("Load");
        but05.setBounds(butLocationX, 20 + button_height, button_width, button_height);
        but05.setForeground(Color.WHITE);
        but05.setBackground(Color.BLACK);
        but05.addActionListener(button_listener);
        frame.add(but05);

        but06 = new RoundButton("New Game");
        but06.setBounds(butLocationX, 30 + button_height * 2, button_width, button_height);
        but06.setForeground(Color.WHITE);
        but06.setBackground(Color.BLACK);
        but06.addActionListener(button_listener);
        frame.add(but06);

        but07 = new RoundButton("Cheat");
        but07.setBounds(butLocationX, 40 + button_height * 3, button_width, button_height);
        but07.setForeground(Color.WHITE);
        but07.setBackground(Color.BLACK);
        but07.addActionListener(button_listener);
        //but07.setVisible(false);
        frame.add(but07);
    }
}
