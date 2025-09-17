package com.ai.turing.infrastructure.memory;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.messages.Message;

import java.util.List;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-17 13:52
 *
 */

@AllArgsConstructor
public class MysqlBasedMemory implements ChatMemoryRepository {


    @Override
    public List<String> findConversationIds() {
        return List.of();
    }

    @Override
    public List<Message> findByConversationId(@NonNull String conversationId) {
        return List.of();
    }

    @Override
    public void saveAll(@NonNull String conversationId, @NonNull List<Message> messages) {

    }

    @Override
    public void deleteByConversationId(@NonNull String conversationId) {

    }
}
