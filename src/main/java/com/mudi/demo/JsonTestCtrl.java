package com.mudi.demo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mudi.model.User;

@Controller
@RequestMapping("/json")
public class JsonTestCtrl {

	private static final Logger log = LoggerFactory.getLogger(JsonTestCtrl.class);
	
	@RequestMapping("/jsonTest")
	public String jsonTest() {
		log.info("info test");
		log.debug("debug test");
		log.warn("warn test");
		return "jsonTest";
	}

	@RequestMapping("/jsonModel")
	@ResponseBody
	public Map<String,Object> json(User user) {
		System.out.println(user.getAge());
		System.out.println(user.getName());
		Map<String,Object> map =new HashMap<String, Object>();
		map.put("name", user.getName());
		map.put("age", user.getAge());
		return map;
	}
}
