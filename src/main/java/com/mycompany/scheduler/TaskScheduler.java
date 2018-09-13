package com.mycompany.scheduler;

import com.mycompany.repository.GameMatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TaskScheduler {

    @Autowired
    private GameMatchRepository gameMatchMapper;

    private static final Logger log = LoggerFactory.getLogger(TaskScheduler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "3/15 * * * * *")
    public void reportTime() {
        log.info("The time is {}", dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 60000)
    public void countMatches() {
        log.info("Total games on server : " + gameMatchMapper.findAll().size());
    }
}
