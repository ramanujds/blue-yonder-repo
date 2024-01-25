package com.myzuiggy.partner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPartnerLocationService {

    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    @Value("${KAFKA_TOPIC_NAME}")
    private String topicName;

    public void sendLocation(String location, int partition, String key){
        kafkaTemplate.send(topicName,partition,key,location);
    }

}
