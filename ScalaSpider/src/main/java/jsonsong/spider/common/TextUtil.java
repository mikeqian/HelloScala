package jsonsong.spider.common;

public class TextUtil {
    /*
    It's very stupid.
     */
    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
