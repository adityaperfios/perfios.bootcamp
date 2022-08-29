import java.io.*;
public class ReadData {
    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("src/write.txt");
        BufferedReader br = new BufferedReader(fr);

        System.out.println(br.readLine());
    }
}
