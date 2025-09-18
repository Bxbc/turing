package com.ai.turing.infrastructure.dao.knowledge.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-17 20:10
 *
 */

@Configuration
public class BasePostgresqlConfig {

    @Value("${turing.datasource.postgresql.username}")
    private String USER_NAME;

    @Value("${turing.datasource.postgresql.url}")
    private String URL;

    @Value("${turing.datasource.postgresql.driver-class-name}")
    private String DRIVER_CLASS_NAME;

    @Bean(name = "knowledgeDatasource")
    public DataSource knowledgeDatasource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(USER_NAME);
        dataSource.setUrl(URL);
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setInitialSize(20);
        dataSource.setMaxActive(200);
        dataSource.setTestWhileIdle( true);

        return dataSource;
    }

    @Bean(name = "knowledgeJdbcTemplate")
    public JdbcTemplate knowledgeJdbcTemplate(@Qualifier("knowledgeDatasource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
