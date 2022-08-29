import java.io.*;

public class Filewrite {
    public static void main(String[] args) throws IOException {
        File file = new File("src/sample.txt");
        FileOutputStream fout = new FileOutputStream(file);
        BufferedOutputStream bw = new BufferedOutputStream(fout);

        String msg = "This is a simple byte stream write operation";
        bw.write(msg.getBytes());
        bw.flush();
        System.out.println("Done");
    }
}
