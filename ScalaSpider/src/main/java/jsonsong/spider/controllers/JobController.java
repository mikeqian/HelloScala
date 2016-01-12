package jsonsong.spider.controllers;

import jsonsong.spider.common.CommonUtils;
import jsonsong.spider.job.CarJob;
import org.quartz.JobExecutionException;
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
        try {
            carJob.execute(null);
            return "done at: " + CommonUtils.getTimeSimpleText(new Date());
        } catch (JobExecutionException e) {
            return e.getMessage();
        }
    }
}