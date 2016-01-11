package jsonsong.spider.common;

public class TextUtil {
    /*
    It's very stupid.
     */
    public static boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
