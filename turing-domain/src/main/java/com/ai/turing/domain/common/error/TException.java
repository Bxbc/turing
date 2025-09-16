package com.ai.turing.domain.common.error;

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
 * @date 2025-09-16 17:15
 *
 */

@Getter
@ToString
public class TException extends RuntimeException {

    private final TError error;

    private final String toastMsg;

    public TException(TError error) {
        super(error.getErrorMsg());
        this.error = error;
        this.toastMsg = error.getToastMsg();
    }

    public TException(TError error, String toastMsg) {
        super(error.getErrorMsg());
        this.error = error;
        this.toastMsg = toastMsg;
    }
}
