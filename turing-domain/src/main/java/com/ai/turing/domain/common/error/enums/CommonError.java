package com.ai.turing.domain.common.error.enums;

import com.ai.turing.domain.common.error.TError;
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
 * @date 2025-09-16 17:17
 *
 */

@AllArgsConstructor
@Getter
public enum CommonError implements TError {

    UNKNOWN_ERROR("UNKNOWN_ERROR", "未知错误", "请稍后再试"),

    PARAM_ERROR("PARAM_ERROR", "参数错误", "请检查参数"),
    ;

    private final String code;

    private final String errorMsg;

    private final String toastMsg;
}
