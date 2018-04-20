package com.mudi.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 多视图解析器测试
 * @author csd
 *
 */
@Controller
public class ViewTestCtrl {

	@RequestMapping("thymeleaf")
	public String index() {
		return "thymeleaf";
	}
	@RequestMapping("freemark")
	public String freemark() {
		return "freemark";
	}
}
