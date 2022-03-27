package ru.LearnUp.event;

import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
public class MyEvent extends ApplicationEvent {
    private final String data;

    public MyEvent(String data) {
        super(data);
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
