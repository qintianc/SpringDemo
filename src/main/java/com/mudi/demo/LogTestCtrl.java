package com.mudi.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mudi.model.TUser;
import com.mudi.service.TUserService;


/**
 * log4j功能demo
 * @author csd
 *
 */
@Controller
@RequestMapping("/log")
public class LogTestCtrl {

	private static final Logger log = LoggerFactory.getLogger(LogTestCtrl.class);

	@Autowired
	private TUserService tUserService;
	
	@RequestMapping("/logTest")
	public String logTest() {
		TUser user = tUserService.getUserBySalesNo("00681418112");
		System.out.println(user.getId());
		log.info("info test");
		log.debug("debug test");
		log.warn("warn test");
		return "thymeleaf";
	}
}
