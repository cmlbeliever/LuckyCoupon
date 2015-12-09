package com.cml.mvc.framework.converter.datetime;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.MonthDay;
import org.joda.time.Period;
import org.joda.time.ReadableDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePeriod;
import org.joda.time.YearMonth;
import org.joda.time.format.DateTimeFormat;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.joda.PackageVersion;
import com.fasterxml.jackson.datatype.joda.cfg.JacksonJodaDateFormat;
import com.fasterxml.jackson.datatype.joda.deser.DateMidnightDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.DateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.DateTimeZoneDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.DurationDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.IntervalDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.MonthDayDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.PeriodDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.YearMonthDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.key.DateTimeKeyDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.key.LocalDateKeyDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.key.LocalDateTimeKeyDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.key.LocalTimeKeyDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.DateMidnightSerializer;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeZoneSerializer;
import com.fasterxml.jackson.datatype.joda.ser.DurationSerializer;
import com.fasterxml.jackson.datatype.joda.ser.InstantSerializer;
import com.fasterxml.jackson.datatype.joda.ser.IntervalSerializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalTimeSerializer;
import com.fasterxml.jackson.datatype.joda.ser.PeriodSerializer;

@SuppressWarnings("deprecation")
public class BaseJodaModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public static final String DATE_TIME_PATTERN = "yyyyMMddHHmmss";
	private static final JacksonJodaDateFormat DATE_TIME_FORMATTER = new JacksonJodaDateFormat(
			DateTimeFormat.forPattern(DATE_TIME_PATTERN).withZoneUTC());

	@SuppressWarnings({ "unchecked" })
	public BaseJodaModule() {

		super(PackageVersion.VERSION);
		// first deserializers
		addDeserializer(DateMidnight.class, new DateMidnightDeserializer());
		addDeserializer(DateTime.class,
				DateTimeDeserializer.forType(DateTime.class));
		addDeserializer(DateTimeZone.class, new DateTimeZoneDeserializer());

		addDeserializer(Duration.class, new DurationDeserializer());
		addDeserializer(Instant.class, new InstantDeserializer());
		addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
		addDeserializer(LocalDate.class, new LocalDateDeserializer());
		addDeserializer(LocalTime.class, new LocalTimeDeserializer());
		JsonDeserializer<?> deser = new PeriodDeserializer(true);
		addDeserializer(Period.class, (JsonDeserializer<Period>) deser);
		addDeserializer(ReadablePeriod.class, new PeriodDeserializer(false));
		addDeserializer(ReadableDateTime.class,
				DateTimeDeserializer.forType(ReadableDateTime.class));
		addDeserializer(ReadableInstant.class,
				DateTimeDeserializer.forType(ReadableInstant.class));
		addDeserializer(Interval.class, new IntervalDeserializer());
		addDeserializer(MonthDay.class, new MonthDayDeserializer());
		addDeserializer(YearMonth.class, new YearMonthDeserializer());

		// then serializers:
		final JsonSerializer<Object> stringSer = ToStringSerializer.instance;
		addSerializer(DateMidnight.class, new DateMidnightSerializer());
		addSerializer(DateTime.class, new DateTimeSerializer(
				DATE_TIME_FORMATTER));
		addSerializer(DateTimeZone.class, new DateTimeZoneSerializer());
		addSerializer(Duration.class, new DurationSerializer());
		addSerializer(Instant.class, new InstantSerializer());
		addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
		addSerializer(LocalDate.class, new LocalDateSerializer());
		addSerializer(LocalTime.class, new LocalTimeSerializer());
		addSerializer(Period.class, new PeriodSerializer());
		addSerializer(Interval.class, new IntervalSerializer());
		addSerializer(MonthDay.class, stringSer);
		addSerializer(YearMonth.class, stringSer);

		// then key deserializers
		addKeyDeserializer(DateTime.class, new DateTimeKeyDeserializer());
		addKeyDeserializer(LocalTime.class, new LocalTimeKeyDeserializer());
		addKeyDeserializer(LocalDate.class, new LocalDateKeyDeserializer());
		addKeyDeserializer(LocalDateTime.class,
				new LocalDateTimeKeyDeserializer());
	}

	// yes, will try to avoid duplicate registations (if MapperFeature enabled)
	@Override
	public String getModuleName() {
		return getClass().getSimpleName();
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return this == o;
	}

}
