package com.xxx.brixton.serverb.scheduled;

import com.xxx.brixton.serverb.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器
 */
@Component
public class SchedulOne {

    @Autowired
    private BService bService;

    @Scheduled(cron = "0/30 * * * * ?")
    public void sd1() {
        bService.sendDataToServerC();
    }
}
