import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialDemo {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("src/player.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Player obj = (Player) ois.readObject();
        System.out.println("ID : "+obj.id+" Name : "+obj.name+" Type : "+obj.type+" City : "+obj.city);
    }
}
