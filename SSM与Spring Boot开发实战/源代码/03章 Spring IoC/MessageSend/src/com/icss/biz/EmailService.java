package com.icss.biz;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.icss.event.BlackListEvent;

public class EmailService implements ApplicationEventPublisherAware{
	
	private ApplicationEventPublisher publisher;
	private List<String> blackList;	
	

	public void setBlackList(List<String> blackList) {
		this.blackList = blackList;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		this.publisher = arg0;		
	}
	
	public void sendEmail(String address, String content,String title) {
		if (blackList.contains(address)) {
			publisher.publishEvent(new BlackListEvent(this, address, title));
			return;
		}
	    //���������ʼ�
		System.out.println("�����ʼ���" + address + "," + title + "," + content);
	}

}
