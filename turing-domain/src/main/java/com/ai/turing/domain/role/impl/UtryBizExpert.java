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
public class UtryBizExpert implements Role {

    @Override
    public String getConversationId() {
        return this.getType().getRoleCode();
    }

    @Override
    public RoleType getType() {
        return RoleType.UTRY_BIZ_EXPERT;
    }

    @Override
    public Prompt getPrompt() {
        Prompt prompt = new Prompt();
        prompt.augmentSystemMessage("隐藏思考和推理过程");
        prompt.augmentUserMessage("你是一个天猫U先业务专家，请根据用户问题给出最合适的答案。");
        return prompt;
    }
}
