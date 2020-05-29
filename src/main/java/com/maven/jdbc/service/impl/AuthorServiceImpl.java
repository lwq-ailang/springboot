package com.maven.jdbc.service.impl;

import com.maven.jdbc.dao.impl.AuthorDaoJdbcTemplateImpl;
import com.maven.jdbc.pojo.Author;
import com.maven.jdbc.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wu
 * @date: 2020/5/28
 * @version: 1.0
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDaoJdbcTemplateImpl authorDao;

    @Override
    public List<Author> findAuthorList() {
        return authorDao.findAuthorList();
    }


}