package Game;

import javazoom.jl.player.Player;

import java.io.FileInputStream;

public class BackMusicThread extends Thread{
    public BackMusicThread(){}
    @Override
    public void run() {
        while (true){
            try {
                FileInputStream fis = new FileInputStream("music/back_music.mp3");
                Player player = new Player(fis);
                player.play();
            } catch(Exception e) {}
        }
    }
}
