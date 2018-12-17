package com.mudi.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//使用注解就不需要在web.xml中添加配置
@WebListener
public class MyServletContextListener implements ServletContextListener {

	// 上下文销毁
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	// 上下文初始化
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("上下文初始化");
	}
}