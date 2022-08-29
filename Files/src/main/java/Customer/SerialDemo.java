package Customer;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.*;

public class SerialDemo {
    public static void main(String[] args) throws IOException {

        File file = new File("src/player.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream ow = new ObjectOutputStream(fos);
        Customer obj = new Customer();
        obj.id = 101;
        obj.type = "PLayertype";
        obj.name = "PLayername";
        obj.city = "Playercity";
        obj.pin = 123123;

        ow.writeObject(obj);
        System.out.println("Done");

        Order obj1 = new Order();
        obj1.order_id = 169;
        obj1.items = "Apple";
        obj1.order_amount = 200;
    }
}