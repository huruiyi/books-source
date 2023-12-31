package org.crazyit.app;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.get.GetResult;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

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
public class ReactiveClientTest
{
	// 依赖注入Spring Boot自动配置的ReactiveElasticsearchClient
	@Autowired
	private ReactiveElasticsearchClient reactiveClient;

	@Test
	public void testCreateIndex() throws IOException
	{
		// 定义创建Index的设置，和前面fkjava.json文件的内容相同
		// 设置该Index的默认分词器是ik_max_word
		var json = "{\n" +
				"  \"settings\": {\n" +
				"    \"analysis\": {\n" +
				"      \"analyzer\": {\n" +
				"        \"default\": {\"tokenizer\": \"ik_max_word\"}\n" +
				"      }\n" +
				"    }\n" +
				"  }\n" +
				"}\n";
		var indexRequest = new CreateIndexRequest("books")
				.source(json, XContentType.JSON);
		Mono<Boolean> resp = reactiveClient.indices().createIndex(indexRequest);
		resp.blockOptional().ifPresent(b -> Assertions.assertTrue(b, "创建失败！"));
	}

	@Test
	public void testDeleteIndex() throws IOException
	{
		var indexRequest = new DeleteIndexRequest("books");
		Mono<Boolean> resp = reactiveClient.indices()
				.deleteIndex(indexRequest);
		resp.blockOptional().ifPresent(b -> Assertions.assertTrue(b, "删除失败！"));
	}

	@ParameterizedTest
	@CsvSource({"1, 疯狂Java讲义, 最全面深入的Java图书, 129.0",
			"2, SpringBoot终极讲义, 无与伦比的SpringBoot热点图书, 119.0",
			"3, 疯狂Python, 系统易懂的Python图书，覆盖数据分析、爬虫等全部热门内容, 118.0"})
	public void testSaveDocument(Integer id, String name,
			String description, Double price) throws IOException
	{
		IndexRequest request = new IndexRequest("books")
				.id(id + "")
				.source("name", name,
						"description", description,
						"price", price);
		Mono<IndexResponse> resp = reactiveClient.index(request);
		resp.blockOptional().ifPresent(System.out::println);
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	public void testGetDocument(Integer id) throws IOException
	{
		var request = new GetRequest("books")
				.id(id + "");
		Mono<GetResult> resp = reactiveClient.get(request);
		resp.blockOptional().ifPresent(e -> System.out.println(e.getSource()));
	}

	@ParameterizedTest
	@CsvSource({"name, 疯狂", "description, 热*"})
	public void testSearch(String field, String term) throws IOException
	{
		var builder = new SearchSourceBuilder();
		if (term != null && term.contains("*"))
		{
			builder.query(QueryBuilders.wildcardQuery(field, term));
		} else
		{
			builder.query(QueryBuilders.matchQuery(field, term));
		}
		var request = new SearchRequest("books")
				.source(builder);
		Flux<SearchHit> resp = reactiveClient.search(request);
		resp.toIterable().forEach(System.out::println);
	}

	@ParameterizedTest
	@ValueSource(ints = {1})
	public void testDeleteDocument(Integer id) throws IOException
	{
		var request = new DeleteRequest("books")
				.id(id + "");
		Mono<DeleteResponse> resp = reactiveClient.delete(request);
		resp.blockOptional().ifPresent(e -> System.out.println(e.status()));
	}
}