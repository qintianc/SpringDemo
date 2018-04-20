package com.mudi.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mudi.model.TUser;
import com.mudi.service.TUserService;

/**用于配置spring中测试的环境*/
@RunWith(SpringJUnit4ClassRunner.class)
/**用于指定配置文件所在的位置,多个配置文件时{"/applic1","/applic2"} 可以导入多个配置文件*/
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
/**如果不加入这个配置，事务控制就会完全失效！*/
@Transactional
public class TUserServiceTest {
	
	@Autowired
	private TUserService tUserService;
	
	@Test
	public void test() {
		TUser user = tUserService.getUserBySalesNo("00681418112");
		System.out.println(user.getId());
	}
	/*@Test
	public void test1(){
		tUserService.updateBySalesNo("00681418112");
	}*/
}
