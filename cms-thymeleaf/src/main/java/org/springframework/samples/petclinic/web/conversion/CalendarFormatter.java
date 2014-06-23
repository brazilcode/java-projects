package org.springframework.samples.petclinic.web.conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CalendarFormatter implements Formatter<Calendar> {

	private static final SimpleDateFormat SDF = new SimpleDateFormat(
			"dd/MM/yyyy");

	public CalendarFormatter() {
		super();
	}

	public Calendar parse(String text, Locale locale) throws ParseException {
		synchronized (SDF) {
			final Date date = SDF.parse(text);
			final Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(date.getTime());
			return cal;
		}
	}

	public String print(Calendar object, Locale locale) {
		synchronized (SDF) {
			return SDF.format(object.getTime());
		}
	}
}
