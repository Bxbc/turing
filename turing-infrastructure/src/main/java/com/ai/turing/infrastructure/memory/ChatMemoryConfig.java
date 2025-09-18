package com.ai.turing.infrastructure.memory;

import com.ai.turing.infrastructure.dao.turing.memory.mapper.TuringMemoryMapper;
import com.ai.turing.infrastructure.memory.customer.MysqlBasedMemory;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-17 15:57
 *
 */

@Configuration
public class ChatMemoryConfig {

    @Resource
    private TuringMemoryMapper turingMemoryMapper;

    @Bean(name = "messageWindowChatMemory")
    public MessageWindowChatMemory messageWindowChatMemory() {
        return MessageWindowChatMemory.builder()
                .chatMemoryRepository(new MysqlBasedMemory(turingMemoryMapper))
                .maxMessages(100)
                .build();
    }
}
