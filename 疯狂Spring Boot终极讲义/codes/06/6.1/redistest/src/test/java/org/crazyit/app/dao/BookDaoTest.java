package org.crazyit.app.dao;

import org.crazyit.app.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.Map;

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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BookDaoTest
{
	@Autowired
	private BookDao bookDao;

	@Test
	public void testSaveWithId()
	{
		var book = new Book("疯狂Python",
				"系统易懂的Python图书，覆盖数据分析、爬虫等热门内容", 118.0);
		// 显式设置ID，通常不建议设置
		book.setId(2);
		book.setTimeout(5L); // 设置超时时长
		bookDao.save(book);
	}
	@Test
	public void testUpdate()
	{
		// 更新id为2的Book对象
		bookDao.findById(2)
				.ifPresent(book -> {
					book.setName("疯狂Python讲义");
					bookDao.save(book);
				});
	}
	@Test
	public void testDelete()
	{
		// 删除id为2的Book对象
		bookDao.deleteById(2);
	}
	@ParameterizedTest
	@CsvSource({"疯狂Java讲义, 最全面深入的Java图书, 129.0",
			"SpringBoot终极讲义, 无与伦比的SpringBoot图书, 119.0"})
	public void testSave(String name, String description, Double price)
	{
		var book = new Book(name, description, price);
		bookDao.save(book);
	}
	@ParameterizedTest
	@ValueSource(strings = {"疯狂Java讲义"})
	public void testFindByName(String name)
	{
		bookDao.findByName(name).forEach(System.out::println);
	}
	@ParameterizedTest
	@ValueSource(strings = {"最全面深入的Java图书"})
	public void testFindByDescription(String description)
	{
		bookDao.findByDescription(description).forEach(System.out::println);
	}

	@ParameterizedTest
	@CsvSource({"疯狂Java讲义, 最全面深入的Java图书"})
	public void testExampleQuery1(String name, String description)
	{
		// 创建样本对象（probe）
		var s = new Book(name, description, 1.0);
		// 不使用ExampleMatcher，创建默认的Example
		bookDao.findAll(Example.of(s)).forEach(System.out::println);
	}

	@ParameterizedTest
	@ValueSource(strings = {"SpringBoot终极讲义"})
	public void testExampleQuery2(String name)
	{
		// 创建matchingAll的ExampleMatcher
		ExampleMatcher matcher = ExampleMatcher.matching()
				// 忽略null属性, 该方法可以省略
				//.withIgnoreNullValues()
				.withIgnorePaths("description"); // 忽略description属性
		// 创建样本对象（probe）
		var s = new Book(name, "test", 1.0);
		bookDao.findAll(Example.of(s, matcher)).forEach(System.out::println);
	}

	@ParameterizedTest
	@CsvSource({"user, name, crazyit", "user, address, 广州"})
	public void testHmSet(String key, String field, String value)
	{
		bookDao.hmset(key, Map.of(field, value));
	}

	@ParameterizedTest
	@ValueSource(doubles = {110.0, 120.0})
	public void testCustomQuery(double startPrice)
	{
		bookDao.customQuery(startPrice).forEach(System.out::println);
	}
}