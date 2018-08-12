import static java.nio.charset.StandardCharsets.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.swing.JOptionPane;

public class test {
	// convert from UTF-8 -> internal Java String format
    public static String convertFromUTF8(String s) {
        String out = null;
        try {
            out = new String(s.getBytes("ISO-8859-1"), "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }
 
    // convert from internal Java String format -> UTF-8
    public static String convertToUTF8(String s) {
        String out = null;
        try {
            out = new String(s.getBytes("UTF-8"), "ISO-8859-1");
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }
 
    public static void main(String[] args) {
    	String textwithaccent="Thís ís a text with accent";
    	String textwithletter="thế ngọc";

    	String text1 = new String(textwithaccent.getBytes(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8"));
    	String text2 = new String(textwithletter.getBytes(Charset.forName("ISO-8859-1")),Charset.forName("UTF-8"));
    	
    	JOptionPane.showMessageDialog(null, textwithaccent+" - "+textwithletter, text1+" - "+text2, 0);
    }
}
