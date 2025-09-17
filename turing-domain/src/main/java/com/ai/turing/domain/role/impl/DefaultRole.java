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
 * @date 2025-09-16 16:51
 *
 */

@Component
public class DefaultRole implements Role {

    @Override
    public String getConversationId() {
        return getType().getRoleCode();
    }

    @Override
    public RoleType getType() {
        return RoleType.DEFAULT;
    }

    @Override
    public Prompt getPrompt() {
        return new Prompt();
    }
}
