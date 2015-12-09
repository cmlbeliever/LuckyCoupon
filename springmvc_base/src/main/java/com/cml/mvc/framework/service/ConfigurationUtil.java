package com.cml.mvc.framework.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class ConfigurationUtil implements InitializingBean {

	private static Configuration delegate;

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(delegate, "delegate can not be set to null.");
	}

	public void setDelegate(Configuration delegate) {
		ConfigurationUtil.delegate = delegate;
	}

	public static String getProperty(String key) {
		return delegate.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		return delegate.getProperty(key, defaultValue);
	}

	public static double getDoubleProperty(String key) {
		return delegate.getDoubleProperty(key);
	}

	public static double getDoubleProperty(String key, double value) {
		return delegate.getDoubleProperty(key, value);
	}

	public static float getFloatProperty(String key) {
		return delegate.getFloatProperty(key);
	}

	public static float getFloatProperty(String key, float value) {
		return delegate.getFloatProperty(key, value);
	}

	public static int getIntProperty(String key) {
		return delegate.getIntProperty(key);
	}

	public static int getIntProperty(String key, int value) {
		return delegate.getIntProperty(key, value);
	}

	public static long getLongProperty(String key, long value) {
		return delegate.getLongProperty(key, value);
	}

	public static long getLongProperty(String key) {
		return delegate.getLongProperty(key);
	}
	
	public static boolean getBooleanProperty(String key) {
        return delegate.getBooleanProperty(key);
    }

    public static boolean getBooleanProperty(String key, boolean value) {
        return delegate.getBooleanProperty(key, value);
    }

}
