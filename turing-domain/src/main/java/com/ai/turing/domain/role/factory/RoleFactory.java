package com.ai.turing.domain.role.factory;

import com.ai.turing.domain.role.Role;
import com.ai.turing.domain.role.enums.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-16 16:52
 *
 */

@Component
public class RoleFactory {

    private static final Map<RoleType, Role> ROLE_MAP = new HashMap<>();

    @Autowired
    private void init(List<Role> roleList) {
        for (Role role : roleList) {
            ROLE_MAP.put(role.getType(), role);
        }
    }

    public static Optional<Role> getRole(RoleType roleType) {
        return Optional.ofNullable(ROLE_MAP.get(roleType));
    }
}
