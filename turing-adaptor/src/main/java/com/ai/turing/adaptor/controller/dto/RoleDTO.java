package com.ai.turing.adaptor.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-18 11:00
 *
 */

@Getter
@Builder
@ToString
public class RoleDTO {

    private String name;

    private String code;
}
