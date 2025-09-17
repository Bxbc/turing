package com.ai.turing.adaptor.monitor;

import com.ai.turing.domain.common.error.TException;
import com.ai.turing.domain.common.error.enums.CommonError;
import com.ai.turing.domain.common.result.TResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-16 17:24
 *
 */

@Component
@Aspect
@Slf4j
public class ControllerMonitor {

    @Pointcut("execution(public * com.ai.turing.adaptor.controller.*.*(..))")
    public void controllerMonitorPoint() {
    }

    @Around("controllerMonitorPoint()")
    public Object around(ProceedingJoinPoint joinPoint){

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(Objects.nonNull(attributes)) {

            // 请求日志打印
            HttpServletRequest request = attributes.getRequest();
            log.info("class: {}, method: {}, ip: {}, params: {}", method.getDeclaringClass().getSimpleName(), method.getName(), request.getRemoteAddr(), joinPoint.getArgs());
        }

        try {
            Object proceed = joinPoint.proceed();
            stopWatch.stop();
            log.info("class: {}, method: {}, cost: {}", method.getDeclaringClass().getSimpleName(), method.getName(), stopWatch.getTime());
            return proceed;
        } catch (TException te) {
            log.error("class:{}, method: {}, params: {}", method.getDeclaringClass().getSimpleName(), method.getName(), joinPoint.getArgs(), te);
            return TResult.fail(te);
        } catch (Throwable throwable) {
            log.error("class:{}, method: {}, params: {}", method.getDeclaringClass().getSimpleName(), method.getName(), joinPoint.getArgs(), throwable);
            return TResult.fail(CommonError.UNKNOWN_ERROR, throwable.getMessage());
        }
    }
}
