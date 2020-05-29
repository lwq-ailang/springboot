package com.maven.scheduled.dynamicScheduled;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//@Repository
@Mapper
public interface CronMapper {

    @Select("select cron from cron limit 1")
    public String getCron();

}