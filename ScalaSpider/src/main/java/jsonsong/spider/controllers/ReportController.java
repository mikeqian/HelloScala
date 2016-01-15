package jsonsong.spider.controllers;

import jsonsong.spider.dao.CarDao;
import jsonsong.spider.dto.CarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@RestController
public class ReportController {

    @Autowired
    private CarDao carDao;

    @RequestMapping(value = "/report/car")
    public CarResponse getCarReport() {
        CarResponse response = new CarResponse();

        Calendar todayStart = GregorianCalendar.getInstance();

        todayStart.add(Calendar.DATE, -1);
        Date endTime = todayStart.getTime();

        todayStart.add(Calendar.DATE, -1);
        Date startTime = todayStart.getTime();

        response.setCars(carDao.getCarByTime(startTime, endTime));

        return response;
    }
}
