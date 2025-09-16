package com.ai.turing.domain.common.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-16 17:12
 *
 */

@Getter
@Setter
@ToString
public class TResult<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -7681999729930452433L;

    private T data;

    private boolean success;

    /**
     * 结果code
     */
    private String code;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 错误信息（可展示）
     */
    private String toastMsg;

    private TResult() {

    }

    public static <T> TResult<T> success(T data) {

        TResult<T> vResult = new TResult<>();

        vResult.setData(data);
        vResult.setSuccess(true);

        return vResult;
    }

    public static <T> TResult<T> fail(String code, String errorMsg, String toastMsg) {

        TResult<T> vResult = new TResult<>();

        vResult.setCode(code);
        vResult.setErrorMsg(errorMsg);
        vResult.setToastMsg(toastMsg);
        vResult.setSuccess(false);

        return vResult;
    }

    public static <T> TResult<T> fail(VError error) {

        TResult<T> vResult = new TResult<>();

        vResult.setSuccess(false);
        vResult.setCode(error.getCode());
        vResult.setErrorMsg(error.getErrorMsg());
        vResult.setToastMsg(error.getToastMsg());

        return vResult;
    }

    public static <T> TResult<T> fail(VError error, String toastMsg) {

        TResult<T> vResult = new VResult<>();

        vResult.setSuccess(false);
        vResult.setCode(error.getCode());
        vResult.setErrorMsg(error.getErrorMsg());
        vResult.setToastMsg(toastMsg);

        return vResult;
    }

    public static <T> TResult<T> fail(VException e) {
        return fail(e.getVError(), e.getToastMsg());
    }
}
