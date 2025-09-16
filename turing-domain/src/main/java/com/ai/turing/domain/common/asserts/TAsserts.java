package com.ai.turing.domain.common.asserts;

import com.ai.turing.domain.common.error.TException;
import com.ai.turing.domain.common.error.enums.CommonError;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Objects;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-16 17:18
 *
 */

public final class TAsserts {

    public static void notNull(Object object, String message) {

        if(Objects.isNull(object)) {
            throw new TException(CommonError.PARAM_ERROR, message);
        }
    }

    public static void isNull(Object object, String message) {

        if(Objects.nonNull(object)) {
            throw new TException(CommonError.PARAM_ERROR, message);
        }
    }

    public static void isTrue(boolean expression, String message) {
        if(!expression) {
            throw new TException(CommonError.PARAM_ERROR, message);
        }
    }

    public static void isFalse(boolean expression, String message) {
        if(expression) {
            throw new TException(CommonError.PARAM_ERROR, message);
        }
    }

    public static void isBlank(String string, String message) {
        if(StringUtils.isNotBlank(string)) {
            throw new TException(CommonError.PARAM_ERROR, message);
        }
    }

    public static void notBlank(String string, String message) {
        if(StringUtils.isBlank(string)) {
            throw new TException(CommonError.PARAM_ERROR, message);
        }
    }

    public static void isEmpty(Collection<?> collection, String message) {
        if(CollectionUtils.isNotEmpty(collection)) {
            throw new TException(CommonError.PARAM_ERROR, message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if(CollectionUtils.isEmpty(collection)) {
            throw new TException(CommonError.PARAM_ERROR, message);
        }
    }
}
