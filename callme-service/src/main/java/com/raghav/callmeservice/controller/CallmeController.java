package com.raghav.callmeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/callme")
public class CallmeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CallmeController.class);
    private static final String INSTANCE_ID = UUID.randomUUID().toString();
    private Random random = new Random();

    @Autowired
    BuildProperties buildProperties;
    @Value("${VERSION}")
    private String version;

    @GetMapping("/ping")
    public String ping() {
        LOGGER.info("Ping: name={}, version={}", buildProperties.getName(), version);
        return "I'm callme-service " + version;
    }
}
