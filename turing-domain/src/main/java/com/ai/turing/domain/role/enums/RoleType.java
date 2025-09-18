package com.ai.turing.domain.role.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

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

@AllArgsConstructor
@Getter
public enum RoleType {

    DIGITAL_AVATAR("digital_avatar", "数字分身"),

    DEFAULT("default", "默认角色"),
    ;

    private final String roleCode;

    private final String roleDescription;

    public static RoleType getOrDefault(String roleCode) {
        for(RoleType roleType : RoleType.values()) {
            if(roleType.getRoleCode().equals(roleCode)) {
                return roleType;
            }
        }
        return DEFAULT;
    }
}
