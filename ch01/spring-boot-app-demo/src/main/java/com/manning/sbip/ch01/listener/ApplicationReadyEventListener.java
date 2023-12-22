package com.manning.sbip.ch01.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.util.Date;

public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("HEY from listener!!! Application Ready Event logged at " + new Date(event.getTimestamp()));
    }
}
