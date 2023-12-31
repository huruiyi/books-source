package org.crazyit.app;

import org.crazyit.app.domain.MyBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;

/**
 * Description:<br>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2022, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 *
 * @author Yeeku.H.Lee kongyeeku@163.com 公众号: fkbooks<br>
 * @version 1.0
 */
@Configuration(proxyBeanMethods = false)
// 仅当com.mysql.cj.jdbc.Driver类存在时该配置类生效
@ConditionalOnClass(name = "com.mysql.cj.jdbc.Driver")
public class FkConfig
{
	@Bean
	public MyBean myBean()
	{
		return new MyBean();
	}
}
