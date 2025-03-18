package com.fhnw.webec.converter;

import com.fhnw.webec.converter.data.ImperialLength;
import com.fhnw.webec.converter.data.ValidationError;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ConverterController {

    @GetMapping("convert")
    public String convert(@Valid ImperialLength input, Model model) {

        if (input.hasValue()) {
            var metricLength = input.toMetricLength();

            model.addAttribute("cm", metricLength.cm());
            model.addAttribute("mm", metricLength.mm());
            model.addAttribute("input", input);
        }

        return "converter";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationException(MethodArgumentNotValidException ex, Model model) {
        List<ValidationError> errors = new LinkedList<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new ValidationError(error.getField(), error.getDefaultMessage()));
        }

        model.addAttribute("validationErrors", errors);
        model.addAttribute("input", ex.getBindingResult().getTarget()); // Preserve input

        return "converter";
    }
}
