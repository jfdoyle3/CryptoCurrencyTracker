package com.cryptocurrency.backend.scheduledtasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.cryptocurrency.backend.controllers.TestController;

@Component
public class ScheduledTasks {
   @Scheduled(cron="${interval-in-cron}")
   public void fixedRateSch() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
      Date now = new Date();
      String strDate = sdf.format(now);
      System.out.println("Java cron job expression:: " + strDate);
      TestController.getAPIData();
   }
   
   
}
