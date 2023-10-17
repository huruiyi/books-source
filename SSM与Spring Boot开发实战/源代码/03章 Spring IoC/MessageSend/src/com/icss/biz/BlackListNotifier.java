package com.icss.biz;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;

import com.icss.event.BlackListEvent;

public class BlackListNotifier implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent msg) {
		if(msg instanceof BlackListEvent) {
			BlackListEvent bmsg = (BlackListEvent)msg;
			System.out.println("������Ϣ��" + bmsg.getSource().toString() + "------"+ bmsg.getTitle() + "," + bmsg.getAddress()  );	
		}else if(msg instanceof ContextRefreshedEvent) {
			System.out.println("ioc����ˢ��....");
		}else if(msg instanceof ContextClosedEvent) {
			System.out.println("ioc�����ر�....");
		}else {
			
		}
		

	}

}