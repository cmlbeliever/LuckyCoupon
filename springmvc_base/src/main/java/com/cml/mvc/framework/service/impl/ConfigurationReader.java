package com.cml.mvc.framework.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;

import com.cml.mvc.framework.service.Configuration;

public class ConfigurationReader implements Configuration, InitializingBean {

	private static final Log LOG = LogFactory.getLog(ConfigurationReader.class);

	private List<String> configLocation;

	private Properties properties = new Properties();

	public List<String> getConfigLocation() {
		return configLocation;
	}

	public void setConfigLocation(List<String> configLocation) {
		this.configLocation = configLocation;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		LOG.debug("ConfigurationReader init - start");

		if (this.getConfigLocation() == null) {
			throw new IllegalArgumentException(
					"ConfigurationImpl configuration location is not set.");
		}

		for (int i = 0; configLocation != null && i < configLocation.size(); i++) {
			String configFilePath = configLocation.get(i);
			File file = new File(this.getClass().getClassLoader()
					.getResource(configFilePath).getFile());
			InputStream is = this.getClass().getClassLoader()
					.getResourceAsStream(configFilePath);
			if (is == null) {
				// failed to find the resource, try using system class loader
				is = ClassLoader.getSystemResourceAsStream(configFilePath);
			}
			if (is == null && !file.exists()) {
				throw new FileNotFoundException(
						"ConfigurationReader configuration location ["
								+ file.getAbsolutePath() + "] not found.");
			}

			LOG.debug("Start loading configuration from ["
					+ file.getAbsolutePath() + "]");
			try {
				// properties.
				properties.load(is);
			} catch (Exception e) {
				LOG.error("Failed to load configuration file : "
						+ this.configLocation);
				LOG.error(this, e);
				throw e;
			} finally {
				if (is != null) {
					is.close();
				}
			}
		}

		LOG.debug("ConfigurationReader configuration loaded successfully");
		LOG.info(this.properties.toString());
		LOG.debug("ConfigurationReader init - end");

	}

	public double getDoubleProperty(String key) {
		String value = properties.getProperty(key);
		return Double.parseDouble(value);
	}

	public float getFloatProperty(String key) {
		String value = properties.getProperty(key);
		return Float.parseFloat(value);
	}

	public List<String> getGroupProperty(String groupKey) {
		throw new RuntimeException(
				"This method is not implemented. Please contact with the architecture");
	}

	public int getIntProperty(String key) {
		String value = properties.getProperty(key);
		return Integer.parseInt(value);
	}

	public long getLongProperty(String key) {
		String value = properties.getProperty(key);
		return Long.parseLong(value);
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public String getProperty(String key, String value) {
		String v = properties.getProperty(key);
		if (v == null) {
			v = value;
		}
		return v;
	}

	public double getDoubleProperty(String key, double value) {
		try {
			return this.getDoubleProperty(key);
		} catch (Exception e) {
			LOG.warn(this, e);
		}
		return value;
	}

	public float getFloatProperty(String key, float value) {
		try {
			return this.getFloatProperty(key);
		} catch (Exception e) {
			LOG.warn(this, e);
		}
		return value;
	}

	public int getIntProperty(String key, int value) {
		try {
			return this.getIntProperty(key);
		} catch (Exception e) {
			LOG.warn(this, e);
		}
		return value;
	}

	public long getLongProperty(String key, long value) {
		try {
			return this.getLongProperty(key);
		} catch (Exception e) {
			LOG.warn(this, e);
		}
		return value;
	}

	public boolean getBooleanProperty(String key) {
		String value = properties.getProperty(key);
		return BooleanUtils.toBoolean(value);
	}

	public boolean getBooleanProperty(String key, boolean defaultValue) {
		String v = properties.getProperty(key);

		if (v == null) {
			return defaultValue;
		}
		return getBooleanProperty(key);
	}

}
