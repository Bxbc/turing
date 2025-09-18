package com.ai.turing.adaptor.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-18 14:54
 *
 */

@Getter
@Setter
@ToString
public class ChatRequest {

    private String roleCode;

    private String questionContent;
}
