package Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Auto{
    public BufferedImage image;
    public boolean enable;
    public int price;
    public String name;
    public Auto(int id){
        try {
            String path = "image/auto" + (id + 1) + ".png";
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        enable = false;
        switch (id + 1){
            case 1: name = "Bicycle"; price = 162; break;
            case 2: name = "Lada 2107"; price = 1138; break;
            case 3: name = "Lada Priora"; price = 6804; break;
            case 4: name = "Lada Xray"; price = 16240; break;
            case 5: name = "volkswagen Polo Exclusive"; price = 23174; break;
            case 6: name = "Kia Rio Premium 1.6 AT6"; price = 29571; break;
            case 7: name = "Kia Sorento Prestige 3.5 AT8"; price = 75905; break;
            case 8: name = "Rolls-Royce Phantom"; price = 467999; break;
            case 9: name = "Chevrolet Impala 1967"; price = 999999; break;
            default:
                name = "Unknown"; price = 1; break;
        }
    }
}
