package com.example.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private final ApplicationEventPublisher applicationEventPublisher;

    public TestController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping("/create-order")
    public String test(){

        ApplicationEvent event = new OrderCreatedEvent(this, 1L);

        applicationEventPublisher.publishEvent(event);

        return "/create-order";
    }

}
