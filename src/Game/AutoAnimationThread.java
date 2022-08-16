package Game;

public class AutoAnimationThread extends Thread{
    private AutoCollection autoCollection;
    public boolean side, work = false;
    private final int step = 3;
    AutoAnimationThread(AutoCollection autoCollection){
        this.autoCollection = autoCollection;
        start();
    }
    private void next(){
        int x = autoCollection.getX();
        int y = autoCollection.getY();
        if(x <= autoCollection.frame_size_w/2 - autoCollection.getWidth()/2) {
            work = false;
            autoCollection.setLocation(autoCollection.frame_size_w/2 - autoCollection.getWidth()/2,y);
        }
        else {
            x -= step;
            autoCollection.setLocation(x, y);
        }
    }
    private void prev(){
        int x = autoCollection.getX();
        int y = autoCollection.getY();
        if(x >= autoCollection.frame_size_w/2 - autoCollection.getWidth()/2) {
            work = false;
            autoCollection.setLocation(autoCollection.frame_size_w/2 - autoCollection.getWidth()/2,y);
        }
        else {
            x += step;
            autoCollection.setLocation(x, y);
        }
    }
    @Override
    public void run() {
        while(true){
            if(work){
                if(side)
                    prev();
                else
                    next();
            }
            try {
                sleep(18);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
