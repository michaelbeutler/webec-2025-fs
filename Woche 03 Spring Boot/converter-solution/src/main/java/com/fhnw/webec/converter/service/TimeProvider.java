package com.fhnw.webec.converter.service;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class TimeProvider {

    private int count; // just to show that it's really a singleton

    public LocalTime getTime() {
        count++;
        return LocalTime.now();
    }

    public int getCount() {
        return count;
    }
}
