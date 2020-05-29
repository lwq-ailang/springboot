package com.maven.jdbc.controller;

import com.maven.jdbc.pojo.Author;
import com.maven.jdbc.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: wu
 * @date: 2020/5/28
 * @version: 1.0
 */
@RestController
@RequestMapping("/author/")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;

    @RequestMapping("findAuthorList")
    public List<Author> findAuthorList() {
        return authorService.findAuthorList();
    }

}