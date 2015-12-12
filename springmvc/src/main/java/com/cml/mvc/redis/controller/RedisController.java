package com.cml.mvc.redis.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.mvc.redis.service.LuckyCouponService;

@Controller()
@RequestMapping("/redis")
public class RedisController {

	private static final Logger LOG = Logger.getLogger(RedisController.class);

	@Autowired
	private RedisTemplate<String, String> template;

	@Resource(name = "redisTemplate")
	ValueOperations<String, String> values;

	// inject the template as ListOperations
	// can also inject as Value, Set, ZSet, and HashOperations
	@Resource(name = "redisTemplate")
	private ListOperations<String, String> listOps;

	@Resource(name = "luckyCouponService")
	private LuckyCouponService luckyCouponService;

	@ResponseBody
	@RequestMapping("/test")
	public String testRedisTransaction() {
		try {
			template.delete(LuckyCouponService.KEY_USER_COUPON);
			return luckyCouponService.setLuckyCoupon(1l) + "";

		} catch (Exception e) {
			LOG.error(this, e);
			// return "exception";
		}
		LOG.info("------>"
				+ template.opsForSet().members(
						LuckyCouponService.KEY_USER_COUPON));
		return "---";
	}

	@ResponseBody
	@RequestMapping("/set")
	public String setValues(@RequestParam("key") String key) {
		LOG.debug("====>setValue:" + key);

		template.boundValueOps(key).set(
				"values is :" + System.currentTimeMillis());

		RedisSerializer<String> serializer = (RedisSerializer<String>) template
				.getKeySerializer();
		LOG.info("serialize key:" + serializer.serialize(key));

		LOG.info("====keys===>" + template.keys("*"));

		values.set(key + "1", "key " + key);

		return key;
	}

	@ResponseBody
	@RequestMapping("/get")
	public String getValues(@RequestParam("key") String key) {

		String value = template.boundValueOps(key).get();

		LOG.debug("====>getValues,key:" + key + ":" + value);

		return value;
	}

}
