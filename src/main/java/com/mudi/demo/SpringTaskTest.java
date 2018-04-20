package com.mudi.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringTaskTest {

	@Scheduled(cron = "*/5 * * * * ?")
	public void execute() {
		System.out.printf("Task");
	}

	// 每10秒执行一次
	@Scheduled(fixedRate = 1000 * 1) 
	public void execute1() {
		System.out.printf("Task");
	}

	public static void main(String[] args) {
		System.out.println("启动spring容器");
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}
}
