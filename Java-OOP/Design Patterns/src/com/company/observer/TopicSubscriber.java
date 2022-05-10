package com.company.observer;

public class TopicSubscriber implements Observer {

    private String name;
    private Observable topic;

    public TopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {

        if(topic == null){
            System.out.println("No topic set");
        }

        String lastTopic = topic.getUpdate();
        System.out.println(this.name + "received: " + lastTopic);
    }

    @Override
    public void setTopic(Observable topic) {
        this.topic = topic;
    }
}
