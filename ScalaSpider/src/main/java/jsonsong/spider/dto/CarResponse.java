package jsonsong.spider.dto;

import jsonsong.spider.entity.Car;

public class CarResponse {
    public Iterable<Car> getCars() {
        return cars;
    }

    public void setCars(Iterable<Car> cars) {
        this.cars = cars;
    }

    private Iterable<Car> cars;
}
