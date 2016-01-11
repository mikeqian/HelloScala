package jsonsong.spider.dao;

import jsonsong.spider.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, String> {
}
