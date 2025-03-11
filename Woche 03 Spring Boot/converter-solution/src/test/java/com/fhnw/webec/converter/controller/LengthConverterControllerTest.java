package com.fhnw.webec.converter.controller;

import com.fhnw.webec.converter.data.ImperialLength;
import com.fhnw.webec.converter.data.MetricLength;
import com.fhnw.webec.converter.service.LengthConverterService;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthConverterControllerTest {

    @Test
    public void convert() {
        var input = new ImperialLength(1d, 1.1d);
        var model = new ConcurrentModel();

        var view = new LengthConverterController(new LengthConverterService()).convert(input, model);

        assertEquals("converter", view);

        var metricLength = (MetricLength) model.getAttribute("metricLength");
        assertEquals(33, metricLength.cm());
        assertEquals(3, metricLength.mm());

        var imperialLength = (ImperialLength) model.getAttribute("imperialLength");
        assertEquals(1d, imperialLength.feet());
        assertEquals(1.1d, imperialLength.inches());
    }
}
