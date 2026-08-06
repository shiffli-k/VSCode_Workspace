package com.learn.microservice.serviceb.message.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.rabbit.stream.config.StreamRabbitListenerContainerFactory;

import com.rabbitmq.stream.Environment;
import com.rabbitmq.stream.OffsetSpecification;

@Configuration
public class RabbitStreamConfiguration {
    @Bean
    public StreamRabbitListenerContainerFactory streamRabbitListenerContainerFactory(Environment env) {
        StreamRabbitListenerContainerFactory factory = new StreamRabbitListenerContainerFactory(env);

        // Define native stream parameters
        factory.setConsumerCustomizer((id, builder) -> {
            builder.offset(OffsetSpecification.first()); // Always read from the beginning
        });

        return factory;
    }

}
