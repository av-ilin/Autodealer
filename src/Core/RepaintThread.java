package Core;

public class RepaintThread extends Thread{
    Frame frame;
    RepaintThread(Frame frame){
        this.frame = frame;
        start();
    }
    public void run() {
        while (true){
            frame.repaint();
            try {
                sleep(17);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
