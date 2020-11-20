package project;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Mn {
    public static void main(String[] args) {
        String encode = null;
        try {
            encode = URLEncoder.encode("то?link=D:\\output.txt", "UTF-8");//"C:\\Users\\студент11\\Desktop\\Maksim Kozlov Q5.txt", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(encode);
    }
}
