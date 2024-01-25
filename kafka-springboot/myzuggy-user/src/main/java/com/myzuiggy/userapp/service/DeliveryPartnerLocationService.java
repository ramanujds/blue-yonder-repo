package com.myzuiggy.userapp.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DeliveryPartnerLocationService {

    Logger logger = Logger.getLogger(DeliveryPartnerLocationService.class.getName());


    @KafkaListener(topics = "myzuiggy-location", groupId = "myzuiggy-user")
    public void consume(ConsumerRecord<String,String> record){
        String location = record.value();
        int partition = record.partition();
        long offset = record.offset();
        logger.info("From Partition : "+partition);
        logger.info("Offset : "+offset);
        logger.info("Location received: " + location);

    }


}
