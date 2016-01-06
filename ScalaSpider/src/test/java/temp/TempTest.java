package temp;

import org.junit.Test;
import us.codecraft.webmagic.selector.Html;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author code4crafter@gmail.com <br>
 */
public class TempTest {
    @Test
    public void test1() {
        String str = "http://262vv.com/html/se/126390.html";
        //str = "http://my.oschina.net/flashsword/blog/524715";
        String reg = "^http://262vv\\.com/html/se/\\d{5,6}.html";
        System.out.println(str.matches(reg));
    }
}
