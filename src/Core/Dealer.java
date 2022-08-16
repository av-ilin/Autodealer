package Core;

import java.io.*;

import Game.BackMusicThread;
import Game.NPMusicThread;
import static java.lang.Integer.parseInt;

public class Dealer {
    private int cash = 0, coefficient = 1;
    Frame frame;
    NPMusicThread npMusicThread;
    BackMusicThread backMusicThread;
    public Dealer(Frame frame){
        this.frame = frame;
        npMusicThread = new NPMusicThread();
        npMusicThread.start();
        backMusicThread = new BackMusicThread();
        backMusicThread.start();
    }
    public void click(){
        cash += coefficient;
        frame.arrangement.money.setText("Cash: " + cash + "$");
    }
    public void bonus_click(){
        cash += (int) (100 * coefficient * Math.random());
        frame.arrangement.money.setText("Cash: " + cash + "$");
        frame.bonus.activate = false;
        frame.bonus.change_location();
        frame.bonus.setVisible(false);
    }
    public void buyCar(){
        int id = frame.autoCollection.current_id;
        int price = frame.autoCollection.autos.get(id).price;
        boolean enabled = frame.autoCollection.autos.get(id).enable;
        String name = frame.autoCollection.autos.get(id).name;
        if(cash >= price && !enabled){
            cash -= price;
            coefficient *= 3;
            frame.autoCollection.autos.get(id).enable = true;
            frame.arrangement.car.setText(name);
            frame.arrangement.but02.setText("Purchased");
            frame.arrangement.but02.setEnabled(false);
        }
        frame.arrangement.money.setText("Cash: " + cash + "$");
    }
    public void prev_auto(){
        npMusicThread.work = true;
        frame.autoCollection.prevAuto();
        int id = frame.autoCollection.current_id;
        String name = frame.autoCollection.autos.get(id).name;
        int price = frame.autoCollection.autos.get(id).price;
        boolean enabled = frame.autoCollection.autos.get(id).enable;
        if(enabled) {
            frame.arrangement.car.setText(name);
            frame.arrangement.but02.setText("Purchased");
            frame.arrangement.but02.setEnabled(false);
        }
        else {
            frame.arrangement.car.setText("Unknown: " + price + "$");
            frame.arrangement.but02.setText("Buy");
            frame.arrangement.but02.setEnabled(true);
        }
        change_button_status();
    }
    public void next_auto(){
        npMusicThread.work = true;
        frame.autoCollection.nextAuto();
        int id = frame.autoCollection.current_id;
        String name = frame.autoCollection.autos.get(id).name;
        int price = frame.autoCollection.autos.get(id).price;
        boolean enabled = frame.autoCollection.autos.get(id).enable;
        if(enabled) {
            frame.arrangement.car.setText(name);
            frame.arrangement.but02.setText("Purchased");
            frame.arrangement.but02.setEnabled(false);
        }
        else {
            frame.arrangement.car.setText("Unknown: " + price + "$");
            frame.arrangement.but02.setText("Buy");
            frame.arrangement.but02.setEnabled(true);
        }
        change_button_status();
    }
    private void change_button_status(){
        int id = frame.autoCollection.current_id;
        int count = frame.autoCollection.count;

        if(id == count - 1){
            frame.arrangement.but03.setEnabled(false);
            frame.arrangement.but03.setVisible(false);
        }
        else {
            frame.arrangement.but03.setEnabled(true);
            frame.arrangement.but03.setVisible(true);
        }

        if(id == 0){
            frame.arrangement.but01.setEnabled(false);
            frame.arrangement.but01.setVisible(false);
        }
        else {
            frame.arrangement.but01.setEnabled(true);
            frame.arrangement.but01.setVisible(true);
        }
    }
    public void cheat(){
        cash *= 10;
        frame.arrangement.money.setText("Cash: " + cash + "$");
    }
    public void save(){
        File saves = new File("save");
        try (FileWriter fw = new FileWriter(saves)){
            String save = "" + cash;
            for(int i = 0; i < frame.autoCollection.count; i++)
                if(frame.autoCollection.autos.get(i).enable)
                    save += " 1";
                else
                    save += " 0";
            fw.write(save);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void load(){
        File saves = new File("save");
        try (FileReader fr = new FileReader(saves)){
            BufferedReader br = new BufferedReader(fr);
            String[] save = br.readLine().split(" ");
            cash = parseInt(save[0]);
            for(int i = 0; i < frame.autoCollection.count; i++)
                if(save[i + 1].equals("1"))
                    frame.autoCollection.autos.get(i).enable = true;
                else
                    frame.autoCollection.autos.get(i).enable = false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        frame.arrangement.money.setText("Cash: " + cash + "$");
    }
    public void new_game(){
        cash = 0;
        for(int i = 0; i < frame.autoCollection.count; i++)
                frame.autoCollection.autos.get(i).enable = false;
        frame.arrangement.money.setText("Cash: " + cash + "$");
    }
}
