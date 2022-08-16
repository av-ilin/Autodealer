package Game;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class NPMusicThread extends Thread{
    public boolean work = false;
    public NPMusicThread(){}
    @Override
    public void run() {
        while (true){
            if(work) {
                try {
                    FileInputStream fis = new FileInputStream("music/change_auto.mp3");
                    Player player = new Player(fis);
                    player.play();
                } catch(Exception e) {}
                work = false;
            }
            try {
                sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
