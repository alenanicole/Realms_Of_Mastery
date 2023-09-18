package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Chest_obj extends SuperObject {
    public Chest_obj(){
        name = "chest";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
