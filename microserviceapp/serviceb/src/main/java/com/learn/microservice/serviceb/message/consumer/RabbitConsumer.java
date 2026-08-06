package com.learn.microservice.serviceb.message.consumer;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Argument;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.rabbit.stream.config.StreamRabbitListenerContainerFactory;
import org.springframework.stereotype.Service;

import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.OffsetSpecification;

@Service
public class RabbitConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(RabbitConsumer.class);
    
    public static final String RABBIT_MQ_QUQUE_NAME = "MyQ1";
    
    @RabbitListener(queues = RABBIT_MQ_QUQUE_NAME)
    public void queueListener(String messageFromQueue) throws InterruptedException{
        LOG.info("A Message Received: " + messageFromQueue);
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        return;
    }
    @RabbitListener(queues = RABBIT_MQ_QUQUE_NAME)
    public void queueListenerB(String messageFromQueue) throws InterruptedException{
        LOG.info("B Message Received: " + messageFromQueue);
        Thread.sleep(Duration.ofSeconds(6).toMillis());
        return;
    }

    /*-------------------------(Kafka Like)Stream------------------------- */
    
    @RabbitListener(queues = "stream-a", containerFactory = "streamRabbitListenerContainerFactory")
    public void getMessageStream(String theMessage){
        // IO.println(theMessage);
        LOG.info("Received Message >>> " + theMessage);
        return;
    }

}
