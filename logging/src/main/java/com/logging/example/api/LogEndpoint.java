package com.logging.example.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogEndpoint {

    @GetMapping
    public String getDetails() {   //Sensitive data olmamalidir
        log.info("get details methodu basladi");
        return internalLogDetail();
    }

    private String internalLogDetail() {
        try {
            log.debug("internalLogDetail methodu basladi");
            Thread.sleep(1000);
            return "API Mesaj";
        } catch (InterruptedException e) {
            log.error("Hata : {}", e);
        }
        return "";
    }

}
