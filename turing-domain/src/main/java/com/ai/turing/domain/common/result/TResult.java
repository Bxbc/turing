package com.ai.turing.domain.common.result;

import com.ai.turing.domain.common.error.TError;
import com.ai.turing.domain.common.error.TException;
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

        TResult<T> tResult = new TResult<>();

        tResult.setData(data);
        tResult.setSuccess(true);

        return tResult;
    }

    public static <T> TResult<T> fail(String code, String errorMsg, String toastMsg) {

        TResult<T> tResult = new TResult<>();

        tResult.setCode(code);
        tResult.setErrorMsg(errorMsg);
        tResult.setToastMsg(toastMsg);
        tResult.setSuccess(false);

        return tResult;
    }

    public static <T> TResult<T> fail(TError error) {

        TResult<T> tResult = new TResult<>();

        tResult.setSuccess(false);
        tResult.setCode(error.getCode());
        tResult.setErrorMsg(error.getErrorMsg());
        tResult.setToastMsg(error.getToastMsg());

        return tResult;
    }

    public static <T> TResult<T> fail(TError error, String toastMsg) {

        TResult<T> tResult = new TResult<>();

        tResult.setSuccess(false);
        tResult.setCode(error.getCode());
        tResult.setErrorMsg(error.getErrorMsg());
        tResult.setToastMsg(toastMsg);

        return tResult;
    }

    public static <T> TResult<T> fail(TException e) {
        return fail(e.getError(), e.getToastMsg());
    }
}
