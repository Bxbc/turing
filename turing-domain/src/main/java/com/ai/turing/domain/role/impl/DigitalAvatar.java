package com.ai.turing.domain.role.impl;

import com.ai.turing.domain.role.Role;
import com.ai.turing.domain.role.enums.RoleType;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-16 16:44
 *
 */

@Component
public class DigitalAvatar implements Role {

    @Override
    public String getConversationId() {
        return this.getType().getRoleCode();
    }

    @Override
    public RoleType getType() {
        return RoleType.DIGITAL_AVATAR;
    }

    @Override
    public Prompt getPrompt() {
        Prompt prompt = new Prompt();
        prompt.augmentSystemMessage("你不需要将思考过程和内容展示出来，直接返回答案");
        prompt.augmentSystemMessage("你是一个风桐的数字分身，基于已经获取的知识和对话记忆，你可以辅助回答问题");
        return prompt;
    }
}
