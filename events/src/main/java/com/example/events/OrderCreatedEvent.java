package com.example.events;

import org.springframework.context.ApplicationEvent;

public class OrderCreatedEvent extends ApplicationEvent {

    private final Long id;

    public OrderCreatedEvent(Object source, Long id) {
        super(source);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
