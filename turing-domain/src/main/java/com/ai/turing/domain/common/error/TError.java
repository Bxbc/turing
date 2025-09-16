package com.ai.turing.domain.common.error;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-16 17:14
 *
 */

public interface TError {

    String getCode();

    String getErrorMsg();

    String getToastMsg();
}
