import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

//Char stream write
public class WriteData {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("src/write.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        String msg = "This is simple char stream write operations\n";
        bw.write(msg);
        bw.flush();
        System.out.println("Done");
    }
}
