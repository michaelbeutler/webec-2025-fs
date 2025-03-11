package com.fhnw.webec.converter.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class TimeFormatter {

    @Bean(name = "f1")
    public DateTimeFormatter formatter() {
        return DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    @Bean(name = "f2")
    public DateTimeFormatter formatter2() {
        return DateTimeFormatter.ofPattern("HH:mm");
    }

}
