package com.cml.mvc.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cml.mvc.beans.Result;

@Controller
public class HelloWorld {

	Log log = LogFactory.getLog(HelloWorld.class);

	private String names;
	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@ResponseBody
	@RequestMapping(name = "/helloRedis")
	public String helloRedis() {
		log.debug("==========>helloRedis:");
		redisTemplate.convertAndSend("chat", "Hello from Redis!");
		redisTemplate.restore("hello", "hello world".getBytes(), 1, TimeUnit.DAYS);
		return "index";
	}

//	@ResponseBody
//	@RequestMapping(name = "/hello")
//	public String hello() {
//		return "index";
//	}

	@RequestMapping("/str")
	@ResponseBody
	public String str(String str) throws Exception {
		log.debug("==========>names:" + names);
		names = "test:" + str;
		if (null == str) {
			throw new Exception("xxxxx");
		}
		return "test:" + str;
	}

	@RequestMapping("/times")
	@ResponseBody
	public Result getTime(@RequestParam Integer id, @RequestParam DateTime time) {
		log.debug("==========>getTime,time:" + time);
		log.debug("==========>getTime,id:" + id);
		Result result = new Result();
		result.setA(1);
		return result;
	}

	@ResponseBody
	@RequestMapping("/test")
	public String test(@RequestParam(defaultValue = "hhh") String name) {

		System.out.println("hello world:" + Thread.currentThread().getId() + "," + names);
		names = "哈哈：changen";
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("name", "result name" + name);

		return "xxx";

	}

	@RequestMapping("/hello1")
	@ResponseBody
	public ResponseEntity<String> hello1(@RequestParam String name) throws Exception {
		System.out.println("handler:=====>" + name);
		throw new Exception("sssssssssssssss");
		// return new ResponseEntity<String>("哈哈", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public @ResponseBody String handle(IllegalStateException e) {
		return "IllegalStateException handled!";
	}

}
