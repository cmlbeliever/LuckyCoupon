package com.cml.mvc.framework.base;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class DefaultWebBindingInitializer extends
		ConfigurableWebBindingInitializer {

	private static final Log LOG = LogFactory
			.getLog(DefaultWebBindingInitializer.class);

	private Map<String, Object> editors = new HashMap<String, Object>();

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {

		super.initBinder(binder, request);

		// 注入属性转换器
		registerPropertyEditors(binder);

		LOG.debug("DefaultWebBindingInitializer initBinder success!");

	}

	/**
	 * 注入属性转换器
	 * 
	 * @param binder
	 */
	private void registerPropertyEditors(WebDataBinder binder) {

		Iterator<String> editorIt = editors.keySet().iterator();

		while (editorIt.hasNext()) {

			String key = editorIt.next();
			Object value = editors.get(key);

			LOG.debug("inject property editors ==>key:" + key + ","
					+ value.getClass());

			if (null == value || !(value instanceof PropertyEditor)) {
				throw new IllegalArgumentException(
						"editor must be instance of PropertiesEditor！");
			}
			try {
				binder.registerCustomEditor(Class.forName(key),
						(PropertyEditor) value);
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException("could not found class :"
						+ key);
			}
		}
	}

	public Map<String, Object> getEditors() {
		return editors;
	}

	public void setEditors(Map<String, Object> editors) {
		this.editors = editors;
	}

}
