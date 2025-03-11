package com.fhnw.webec.converter.service;

import com.fhnw.webec.converter.data.ImperialLength;
import com.fhnw.webec.converter.data.MetricLength;
import org.springframework.stereotype.Service;

@Service // same as @Component
public class LengthConverterService {

	private static final int INCHES_PER_FOOT = 12;
	private static final double CM_PER_INCH = 2.54;

	public MetricLength convert(ImperialLength imperialLength) {
		var cmTotal = (imperialLength.inches() + (imperialLength.feet() * INCHES_PER_FOOT)) * CM_PER_INCH;

		int cm = (int) cmTotal;
		int mm = (int) Math.round((cmTotal - cm) * 10);

		return new MetricLength(cm, mm);
	}
}
