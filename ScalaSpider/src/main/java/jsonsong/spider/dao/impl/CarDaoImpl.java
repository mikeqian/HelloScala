package jsonsong.spider.dao.impl;

import jsonsong.spider.dao.CarDao;
import jsonsong.spider.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private MongoOperations mongoOps;

    public List<Car> getCarByTime(Date startTime, Date endTime) {

        List<Car> cars = mongoOps.find(query(where("date").gt(startTime).lt(endTime)), Car.class);

        return cars;
    }

    @Override
    public void save(Object car) {
        mongoOps.save(car);
    }
}
