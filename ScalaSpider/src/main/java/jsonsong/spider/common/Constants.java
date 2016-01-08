package jsonsong.spider.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Constants {
    public static final Log log = LogFactory.getLog(Constants.class);

    public static final String DEFAULT_GROUP = "DEFAULT_GROUP";
    public static final String DATA_ID = "com.zhaogang.sale.db01";

    public static final String AUTO_HOME_SEED = "http://dealer.autohome.com.cn/frame/spec/18892/310000/310100/0/10/%s/10?isPage=1&seriesId=526&isAlading=False";

    /*
    每天1点
     */
    public static final String AUTO_HOME_CORN = "0 0 1 * * ? *";

    public static void init() {

    }

    static {
        init();
    }
}
