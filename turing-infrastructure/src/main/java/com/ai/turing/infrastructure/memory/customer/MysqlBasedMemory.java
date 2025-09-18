package com.ai.turing.infrastructure.memory.customer;

import com.ai.turing.infrastructure.dao.turing.memory.mapper.TuringMemoryMapper;
import com.ai.turing.infrastructure.dao.turing.memory.model.TuringMemoryDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.MessageType;

import java.time.LocalDate;
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

    private final TuringMemoryMapper turingMemoryMapper;

    @Override
    public List<String> findConversationIds() {
        return turingMemoryMapper.findConversationIds();
    }

    @Override
    public List<Message> findByConversationId(@NonNull String conversationId) {
        QueryWrapper<TuringMemoryDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TuringMemoryDO::getConversationId, conversationId)
                .orderByDesc(TuringMemoryDO::getGmtCreate);
        List<TuringMemoryDO> turingMemoryDOS = turingMemoryMapper.selectList(queryWrapper);
        return turingMemoryDOS.stream().map(TuringMemoryDO::toMessage).toList();
    }

    @Override
    public void saveAll(@NonNull String conversationId, @NonNull List<Message> messages) {
        List<TuringMemoryDO> turingMemoryDOS = messages.stream().filter(message -> MessageType.USER.equals(message.getMessageType())).map(
                message -> {
                    TuringMemoryDO turingMemoryDO = new TuringMemoryDO();
                    turingMemoryDO.setConversationId(conversationId);
                    turingMemoryDO.setContent(message.getText());
                    turingMemoryDO.setType(message.getMessageType());
                    turingMemoryDO.setGmtCreate(LocalDate.now());

                    return turingMemoryDO;
                }).toList();
        turingMemoryMapper.insert(turingMemoryDOS);
    }


    @Override
    public void deleteByConversationId(@NonNull String conversationId) {
        QueryWrapper<TuringMemoryDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(TuringMemoryDO::getConversationId, conversationId);
        turingMemoryMapper.delete(queryWrapper);
    }
}
