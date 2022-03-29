package ru.LearnUp.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class MyEventPublisher implements ApplicationContextAware {
private ApplicationContext context;
    public void publisherEvent(String event) {
        context.publishEvent(new MyEvent(event));
}
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
