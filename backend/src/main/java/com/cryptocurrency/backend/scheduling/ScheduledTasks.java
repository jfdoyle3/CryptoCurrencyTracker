package com.cryptocurrency.backend.scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTasks {
   @Scheduled(cron="${daily-pricing-update}")
   public void dailyPricingUpdate() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
      Date now = new Date();
      String strDate = sdf.format(now);
      System.out.println("Daily Pricing API Updated:: " + strDate);
      
   }
   
   
}
