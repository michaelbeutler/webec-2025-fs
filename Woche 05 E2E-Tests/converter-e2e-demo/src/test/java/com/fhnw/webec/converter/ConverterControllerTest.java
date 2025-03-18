package com.fhnw.webec.converter;

import com.fhnw.webec.converter.data.ImperialLength;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterControllerTest {

    @Test
    public void convert() {
        var input = new ImperialLength(1d, 1.1d);
        var model = new ConcurrentModel();

        var view = new ConverterController().convert(input, model);

        assertEquals("converter", view);
        assertEquals(33, model.getAttribute("cm"));
        assertEquals(3, model.getAttribute("mm"));

        var inputOnModel = (ImperialLength) model.getAttribute("input");
        assertEquals(1d, inputOnModel.getFeet());
        assertEquals(1.1d, inputOnModel.getInches());
    }
}
