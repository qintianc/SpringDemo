package com.mudi.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**用于配置spring中测试的环境*/
@RunWith(SpringJUnit4ClassRunner.class)
/**用于指定配置文件所在的位置,多个配置文件时{"/applic1","/applic2"} 可以导入多个配置文件*/
@ContextConfiguration(locations = "classpath*:/applicationContext.xml")
public class JunitTestCtrl {

	@Test
	public void test() {
		System.out.println("aaaaaaaaaaa");
	}
}
