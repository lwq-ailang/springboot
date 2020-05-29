package com.maven.jdbc.dao;

import com.maven.jdbc.pojo.Author;

import java.util.List;

public interface AuthorDao {

    int add(Author author);

    int update(Author author);

    int delete(Long id);

    Author findAuthor(Long id);

    List<Author> findAuthorList();
}