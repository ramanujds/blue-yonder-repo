package com.myzuiggy.partner.api;

import com.myzuiggy.partner.service.DeliveryPartnerLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/update-location")
public class DeliveryPartnerLocationController {

    @Autowired
    private DeliveryPartnerLocationService locationService;

    @PostMapping
    public String updateLocation() throws InterruptedException {
        int range = 50;
        for(int i=1; i<=range; i++){
            String location = Math.random()+" , "+Math.random();
            int partitionId = i%3;
            locationService.sendLocation(location,partitionId,"Key : "+i);
            Thread.sleep(1000);
        }
        return "Location Updated";
    }

}
