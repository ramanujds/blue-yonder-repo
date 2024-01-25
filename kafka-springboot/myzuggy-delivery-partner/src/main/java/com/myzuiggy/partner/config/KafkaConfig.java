package com.myzuiggy.partner.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Value("${KAFKA_TOPIC_NAME}")
    private String topicName;

    @Bean
    public NewTopic newTopic(){
        return TopicBuilder
                .name(topicName)
                .partitions(3)
                .build();
    }

}
