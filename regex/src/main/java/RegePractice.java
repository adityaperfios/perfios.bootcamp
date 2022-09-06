import java.util.regex.Pattern;

    public class RegePractice {
        public static void main(String[] args) {
            System.out.println(Pattern.matches(".p","ap"));//true
            Pattern pr = Pattern.compile("[^abc]");
            String input = "xmx";
            boolean b = Pattern.matches("[^abc]",input);
            System.out.println(b);//false
        }
    }

