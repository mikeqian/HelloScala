package jsonsong.spider.dao;

import jsonsong.spider.entity.Car;

import java.util.Date;
import java.util.List;

public interface CarDao extends BaseDao {
    List<Car> getCarByTime(Date startTime, Date endTime);
}
