import java.io.*;

public class Fileread {
    public static void main(String[] args) throws IOException {
        File file = new File("src/sample.txt");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);

        byte[] br = new byte[240];
        int x=0;
        while ((x = bis.read(br))!=-1){
            System.out.println(new String(br,0,x));
        }

    }
}
