package com.sprlearn.learningspring.learn.concepts.beanscope.prototype;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class TrackerID {
    private final UUID trackerId;
    private final LocalDateTime creationTime;

    public TrackerID(){
        this.trackerId = UUID.randomUUID();
        this.creationTime = LocalDateTime.now();
    }

    

    @Override
    public String toString() {
        return "The TrackerID: " + trackerId + ", is created on " + creationTime;
    }



    public UUID getTrackerId() {
        return trackerId;
    }



    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    
}
