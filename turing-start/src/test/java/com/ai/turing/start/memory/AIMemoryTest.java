package com.ai.turing.start.memory;

import com.ai.turing.infrastructure.dao.turing.memory.mapper.TuringMemoryMapper;
import com.ai.turing.infrastructure.dao.turing.memory.model.TuringMemoryDO;
import com.ai.turing.start.TuringStartApplication;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-17 14:50
 *
 */


@SpringBootTest(classes = {TuringStartApplication.class})
public class AIMemoryTest {

    @Resource
    private TuringMemoryMapper turingMemoryMapper;

    @Test
    public void memory_mysql_db_connect_test() {

        TuringMemoryDO turingMemoryDO = turingMemoryMapper.selectById("1");
        Assert.isTrue(true, "mysql db connect test");
    }
}
