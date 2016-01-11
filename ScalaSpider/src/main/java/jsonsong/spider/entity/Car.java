package jsonsong.spider.entity;

import org.springframework.data.annotation.Id;

public class Car {
    @Id
    private String id;

    private String shopName;
    private int price;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Car[id=%s, shopName='%s', price='%s']",
                id, shopName, price);
    }
}
