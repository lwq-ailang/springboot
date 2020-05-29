package com.maven.jdbc.service;

import com.maven.jdbc.pojo.Author;

import java.util.List;

/**
 * @author: wu
 * @date: 2020/5/28
 * @version: 1.0
 */
public interface AuthorService {

    List<Author> findAuthorList();

}