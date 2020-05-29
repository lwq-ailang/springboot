package com.maven.jdbc.mapper;

import com.maven.jdbc.pojo.Author;
import org.apache.ibatis.annotations.Mapper;

/**
 * 方式三：与MyBatis集成
 * 引入starter：
 * <dependency>
 * <groupId>org.mybatis.spring.boot</groupId>
 * <artifactId>mybatis-spring-boot-starter</artifactId>
 * <version>1.1.1</version>
 * </dependency>
 */
@Mapper
public abstract class AuthorMapper extends BaseMapper<Author> {

    public abstract Long insertAuthor(Author author);

    public abstract void updateAuthor(Author author);

    public abstract Author queryById(Long id);
}