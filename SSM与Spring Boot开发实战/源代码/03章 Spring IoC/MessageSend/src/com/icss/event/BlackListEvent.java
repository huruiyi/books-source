package com.icss.event;

import org.springframework.context.ApplicationEvent;

public class BlackListEvent extends ApplicationEvent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String address;
	private final String title;	

	public String getAddress() {
		return address;
	}

	public String getTitle() {
		return title;
	}

	public BlackListEvent(Object source,String title,String address) {
		super(source);
		this.address = address;
		this.title = title;		
	}

}
