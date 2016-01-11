package jsonsong.spider.pageProcessor;

import com.google.common.collect.Lists;
import jsonsong.spider.common.TextUtil;
import jsonsong.spider.entity.Car;
import jsonsong.spider.common.Constants;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class AutoHomePageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(0);
    private AtomicLong seed = new AtomicLong(1);

    @Override
    public void process(Page page) {
        List<String> prices = page.getHtml().xpath("//span[@class='font22']/text()").all();
        List<String> shops = page.getHtml().xpath("dl[@class='dl-list dl-one']//span[@class='fn-left']/a/text()").all();
        if (prices.size() == 0 || prices.size() != shops.size()) {
            page.setSkip(true);
            return;
        }

        long pageIndex = seed.incrementAndGet();

        List<String> urls = Lists.newArrayList(String.format(Constants.AUTO_HOME_SEED, pageIndex));
        page.addTargetRequests(urls);

        List<Car> cars = new ArrayList<Car>();

        int i = 0;
        for (String price : prices) {
            Car car = new Car();
            car.setShopName(shops.get(i));

            if (TextUtil.tryParseDouble(price)) {
                car.setPrice((int) (Float.parseFloat(price) * 10000));
            }

            cars.add(car);
            i++;
        }


        page.putField("car", cars);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
