import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("src/player.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream ow = new ObjectOutputStream(fos);
        Player obj = new Player();
        obj.id = 101;
        obj.type = "PLayertype";
        obj.name = "PLayername";
        obj.city = "Playercity";
        obj.pin = 123123;

        ow.writeObject(obj);
        System.out.println("Done");
    }
}
