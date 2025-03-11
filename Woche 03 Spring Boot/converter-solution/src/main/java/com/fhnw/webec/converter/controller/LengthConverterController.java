package com.fhnw.webec.converter.controller;

import com.fhnw.webec.converter.data.ImperialLength;
import com.fhnw.webec.converter.service.LengthConverterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LengthConverterController {

    private LengthConverterService converter;

    public LengthConverterController(LengthConverterService converter) {
        this.converter = converter;
    }

    @GetMapping("length")
    public String convert(ImperialLength imperialLength, Model model) {

        if (imperialLength.feet() != null && imperialLength.inches() != null) {
            var metricLength = this.converter.convert(imperialLength);

            model.addAttribute("metricLength", metricLength);
            model.addAttribute("imperialLength", imperialLength);
        }

        return "length-converter";
    }
}
