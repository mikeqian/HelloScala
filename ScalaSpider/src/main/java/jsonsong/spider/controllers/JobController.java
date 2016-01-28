package jsonsong.spider.controllers;

import jsonsong.spider.common.CommonUtils;
import jsonsong.spider.job.CarJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class JobController {
    @Autowired
    private CarJob carJob;

    @RequestMapping(value = "/job/do")
    @ResponseBody
    public String doJob() {
        carJob.execute();
        return "done at: " + CommonUtils.getTimeSimpleText(new Date());
    }
}