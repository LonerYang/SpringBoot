package com.ahead;

import com.ahead.bean.Article;
import com.ahead.bean.Book;
import com.ahead.repository.BookRepository;
import com.google.gson.JsonObject;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot11ElasticsearchApplicationTests {

    @Autowired
    private JestClient jestClient;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void testRepositoryIndex() {
        Book book = new Book();
        book.setId(1);
        book.setName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.index(book);
    }

    @Test
    public void testRepositorySearch() {
        List<Book> book = bookRepository.findByNameLike("游");
        System.out.println(book);
    }

    @Test
    public void testElasticsearchTemplateIndex() {
        Book book = new Book();
        book.setId(2);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(book).build();
        elasticsearchTemplate.index(indexQuery);
    }

    @Test
    public void testElasticsearchTemplateSearch() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(new MatchQueryBuilder("name", "国"))
                .build();
        List<Book> books = elasticsearchTemplate.queryForList(searchQuery, Book.class);
        System.out.println(books);
    }


    @Test
    public void testIndex () throws IOException {
        Article article = new Article();
        article.setId(1);
        article.setAuthor("Yang");
        article.setTitle("好消息");
        article.setContent("Hello World");
        Index index = new Index.Builder(article).index("ahead").type("article").build();
        jestClient.execute(index);
    }

    @Test
    public void testSearch() throws IOException {
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("ahead").addType("article").build();
        SearchResult result = jestClient.execute(search);
        //转换为对象
        Article article = result.getSourceAsObject(Article.class, true);
        //获取响应的所有信息
        JsonObject jsonObject = result.getJsonObject();
        System.out.println(article);
        System.out.println(jsonObject);
    }

    @Test
    public void contextLoads() {
    }

}
