package com.cml.mvc.framework.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.format.Formatter;

/**
 * dateTime日期格式化
 * 
 * @author 陈孟琳
 *
 *         2015年4月22日
 */
public class JodaTimeFormatter implements Formatter<DateTime> {

	private static final Log LOG = LogFactory.getLog(JodaTimeFormatter.class);

	private String format;

	@Override
	public String print(DateTime object, Locale locale) {
		LOG.debug("===>print:" + object);
		if (null != object) {
			return object.toString(format);
		}
		return null;
	}

	@Override
	public DateTime parse(String text, Locale locale) throws ParseException {
		LOG.debug("===>parse:format=" + format + ",value=" + text);
		if (null != text) {
			try {
				return DateTimeFormat.forPattern(format).parseDateTime(text);
			} catch (Exception e) {
				throw new ParseException("formatter.datetime.error", 1);
			}
		}
		return null;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}
