package com.ai.turing.infrastructure.dao.base.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-17 15:22
 *
 */

@Configuration
@MapperScan("com.ai.turing.infrastructure.dao.base.memory.mapper")
public class BaseMysqlDatasourceConfig {

    @Value("${turing.datasource.username}")
    private String USER_NAME;

    @Value("${turing.datasource.password}")
    private String PASSWORD;

    @Value("${turing.datasource.url}")
    private String URL;

    @Value("${turing.datasource.driver-class-name}")
    private String DRIVER_CLASS_NAME;

    @Bean(name = "turingDatasource")
    public DataSource turingDatasource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(USER_NAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setUrl(URL);
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setInitialSize(20);
        dataSource.setMaxActive(200);
        dataSource.setTestWhileIdle( true);

        return dataSource;
    }

    @Bean(name = "turingTransactionManager")
    public DataSourceTransactionManager turingTransactionManager() {
        return new DataSourceTransactionManager(turingDatasource());
    }
}
