package com.fhnw.webec.converter.service;

import com.fhnw.webec.converter.data.ImperialLength;
import com.fhnw.webec.converter.data.MetricLength;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthConverterServiceTest {

    private static LengthConverterService service = new LengthConverterService();

    /* this variant of the test has quite a lot of repetition in it */
    @Test
    public void toMetric() {
        assertEquals(new MetricLength(0, 0), service.convert(new ImperialLength(0d, 0d)));
        assertEquals(new MetricLength(2, 5), service.convert(new ImperialLength(0d, 1d)));
        assertEquals(new MetricLength(30, 5), service.convert(new ImperialLength(1d, 0d)));
        assertEquals(new MetricLength(157, 5), service.convert(new ImperialLength(5d, 2d)));
    }

    /* this variant eliminates the repetition by using multiple data sets to rund the same test multiple times */
    @ParameterizedTest
    @CsvSource({ "0, 0, 0, 0", "0, 1, 2, 5", "1, 0, 30, 5", "5, 2, 157, 5" })
    public void toMetricParametrized(double feet, double inches, int cm, int mm) {
        assertEquals(new MetricLength(cm, mm), service.convert(new ImperialLength(feet, inches)));
    }
}
