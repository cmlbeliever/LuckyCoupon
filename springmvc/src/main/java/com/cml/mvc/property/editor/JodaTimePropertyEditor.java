package com.cml.mvc.property.editor;

import java.beans.PropertyEditorSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

/**
 * jodaTime日期格式转换
 * 
 * @author 陈孟琳
 *
 *         2015年4月22日
 */
public class JodaTimePropertyEditor extends PropertyEditorSupport {

	private static final Log LOG = LogFactory
			.getLog(JodaTimePropertyEditor.class);

	private String formatter = "yyyyMMdd HHmmss";
	private DateTimeFormatter format;

	public JodaTimePropertyEditor(String formatter) {
		if (null != formatter) {
			this.formatter = formatter;
		}
		format = DateTimeFormat.forPattern(formatter);
	}

	@Override
	public String getAsText() {

		LOG.debug("===>getAsText:" + getValue());

		Object obj = getValue();
		if (null != obj) {
			return ((DateTime) obj).toString(formatter);
		}

		return "";
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		LOG.debug("datetime setAsText:" + text);

		if (StringUtils.isEmpty(text)) {
			setValue(null);
		} else {

			try {
				setValue(format.parseDateTime(text));
			} catch (Exception e) {
				throw new IllegalArgumentException("Could not parse date: "
						+ e.getMessage(), e);
			}

		}

	}
}
