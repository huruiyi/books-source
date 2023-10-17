package com.icss.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.biz.EmailService;

public class Test {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
		EmailService biz = (EmailService)app.getBean("emailService");
		biz.sendEmail("tom@qq.com", "�������㿪�ᣬһ��", "����֪ͨ");
		biz.sendEmail("tom2@qq.com", "�������㿪�ᣬһ��", "����֪ͨ");
		biz.sendEmail("tom3@qq.com", "�������㿪�ᣬһ��", "����֪ͨ");
		biz.sendEmail("tom4@qq.com", "�������㿪�ᣬһ��", "����֪ͨ");
		biz.sendEmail("jack@qq.com", "�������㿪�ᣬһ��", "����֪ͨ");
		biz.sendEmail("jack2@qq.com", "�������㿪�ᣬһ��", "����֪ͨ");
		app.close();
		
	}

}
