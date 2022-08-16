package Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

public class BonusThread extends Thread{
    Bonus bonus;
    Raster raster, raster_;
    boolean rasterFlag = true;
    int angle = 0;
    BonusThread(Bonus bonus){
        BufferedImage img, img_;
        try {
            img = ImageIO.read(new File("image/cash.png"));
            img_ = ImageIO.read(new File("image/cash_.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        raster = img.getData();
        raster_ = img_.getData();
        this.bonus = bonus;
        start();
    }
    @Override
    public void run() {
        while (true){
            if(rasterFlag)
                bonus.image.setData(raster);
            else
                bonus.image.setData(raster_);
            rasterFlag = !rasterFlag;

            angle++;
            bonus.change_angle(angle);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
