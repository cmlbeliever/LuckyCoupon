package com.cml.mvc.framework.service;

public interface Configuration {

	public String getProperty(String key);

	public String getProperty(String key, String defaultValue);

	public double getDoubleProperty(String key);

	public double getDoubleProperty(String key, double value);

	public float getFloatProperty(String key);

	public float getFloatProperty(String key, float value);

	public int getIntProperty(String key);

	public int getIntProperty(String key, int value);

	public long getLongProperty(String key, long value);

	public long getLongProperty(String key);
	
	public boolean getBooleanProperty(String key);

    public boolean getBooleanProperty(String key, boolean value);

}
