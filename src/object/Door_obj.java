package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Door_obj extends SuperObject {

    public Door_obj(){
        name = "door";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        collision = true;
    }
}