package com.fhnw.webec.converter.controller;

import com.fhnw.webec.converter.service.TimeProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.format.DateTimeFormatter;

@Controller
public class TimeController {

    private final TimeProvider timeProvider;
    private final DateTimeFormatter dateTimeFormatter;

    public TimeController(TimeProvider timeProvider, @Qualifier("f2") DateTimeFormatter dateTimeFormatter) {
        this.timeProvider = timeProvider;
        this.dateTimeFormatter = dateTimeFormatter;
    }

    @GetMapping("time")
    public String time(Model model) {
        var time = timeProvider.getTime();
        var count = timeProvider.getCount();

        var formatted = dateTimeFormatter.format(time);

        model.addAttribute("time", formatted);
        model.addAttribute("count", count);

        return "time-view";
    }
}