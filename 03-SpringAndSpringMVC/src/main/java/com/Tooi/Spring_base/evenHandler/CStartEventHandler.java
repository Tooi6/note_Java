package com.Tooi.Spring_base.evenHandler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class CStartEventHandler implements ApplicationListener<ContextStartedEvent> {
    public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
        System.out.println("ContextStartedEvent Received");
    }
}
