package com.ahead.repository;

import com.ahead.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * <操作的文档类型，文档id类型>
 * @author Yang
 * @version 1.0
 * @time 2019/4/6
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
    /**
     * 通过书名模糊查询
     * @param name
     * @return
     */
    List<Book> findByNameLike(String name);
}



