package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Core.Frame;

public class Button_Listener implements ActionListener {
    Frame frame;
    public Button_Listener(Frame frame){
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent e) {
        String key = e.getActionCommand();
        switch (key){
            case "Prev": frame.dealer.prev_auto(); break;
            case "Next": frame.dealer.next_auto(); break;
            case "Buy": frame.dealer.buyCar(); break;
            case "Cheat": frame.dealer.cheat(); break;
            case "Save": frame.dealer.save(); break;
            case "Load": frame.dealer.load(); break;
            case "New Game": frame.dealer.new_game(); break;
        }
    }
}
