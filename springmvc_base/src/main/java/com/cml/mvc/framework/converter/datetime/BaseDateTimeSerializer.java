package com.cml.mvc.framework.converter.datetime;

import java.io.IOException;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.joda.cfg.FormatConfig;
import com.fasterxml.jackson.datatype.joda.cfg.JacksonJodaDateFormat;
import com.fasterxml.jackson.datatype.joda.ser.JodaDateSerializerBase;

public class BaseDateTimeSerializer extends JodaDateSerializerBase<DateTime> {
	

	private static final long serialVersionUID = 1L;
	
	  public BaseDateTimeSerializer() { this(FormatConfig.DEFAULT_DATETIME_FORMAT); }
	    public BaseDateTimeSerializer(JacksonJodaDateFormat format) {
	        // false -> no arrays (numbers)
	        super(DateTime.class, format, false,
	                SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    }



	@Override
	public JodaDateSerializerBase<DateTime> withFormat(
			JacksonJodaDateFormat format) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void serialize(DateTime value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonGenerationException {
		// TODO Auto-generated method stub
		
	}

}
