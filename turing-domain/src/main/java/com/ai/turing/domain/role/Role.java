package com.ai.turing.domain.role;

import com.ai.turing.domain.role.enums.RoleType;
import org.springframework.ai.chat.prompt.Prompt;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-16 16:23
 *
 */

public interface Role {

    /**
     * 会话ID
     */
    String getConversationId();

    /**
     * 角色类型
     * @return 角色类型
     */
    RoleType getType();

    /**
     * 角色的提示语
     * @return 提示语
     */
    Prompt getPrompt();
}
