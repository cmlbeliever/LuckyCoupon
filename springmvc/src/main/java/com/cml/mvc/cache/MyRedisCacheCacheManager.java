package com.cml.mvc.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;

public class MyRedisCacheCacheManager extends CachingConfigurerSupport {
	private CacheManager cacheManager;

	@Override
	public CacheManager cacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

}
