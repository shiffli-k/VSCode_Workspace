package com.sprlearn.learningspring.learn.concepts.beanscope.prototype;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
public class TrackerIDService {

    private final TrackerID incorrectHandledTrackerID;
    private final ObjectProvider<TrackerID> correctHandledTrackerID;

    public TrackerIDService(TrackerID idService, ObjectProvider<TrackerID> objProvIdService){
        this.incorrectHandledTrackerID = idService;
        this.correctHandledTrackerID = objProvIdService;
    }

    public TrackerID getIncorrectHandledTrackerID() {
        return incorrectHandledTrackerID;
    }

    public ObjectProvider<TrackerID> getCorrectHandledTrackerID() {
        return correctHandledTrackerID;
    }
    
}
