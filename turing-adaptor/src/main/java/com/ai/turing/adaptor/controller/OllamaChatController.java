package com.ai.turing.adaptor.controller;

import com.ai.turing.adaptor.controller.request.ChatRequest;
import com.ai.turing.domain.common.asserts.TAsserts;
import com.ai.turing.domain.common.error.enums.CommonError;
import com.ai.turing.domain.common.result.TResult;
import com.ai.turing.domain.facade.OllamaFacade;
import com.ai.turing.domain.role.Role;
import com.ai.turing.domain.role.enums.RoleType;
import com.ai.turing.domain.role.factory.RoleFactory;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.Optional;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-16 15:52
 *
 */

@RestController
@RequestMapping("/ollama")
public class OllamaChatController {

    @Resource
    private OllamaFacade ollamaFacade;

    @PostMapping("/chat")
    public TResult<String> chat(@RequestBody ChatRequest chatRequest) {

        TAsserts.notBlank(chatRequest.getRoleCode(), "角色不能为空");
        TAsserts.notBlank(chatRequest.getQuestionContent(), "问题不能为空");
        RoleType roleType = RoleType.getOrDefault(chatRequest.getRoleCode());
        Optional<Role> roleOp = RoleFactory.getRole(roleType);
        return roleOp.map(role -> TResult.success(ollamaFacade.chat(role, chatRequest.getQuestionContent()))).orElseGet(() -> TResult.fail(CommonError.PARAM_ERROR, "roleCode is invalid"));
    }

    @PostMapping("/streamChat")
    public TResult<Flux<String>> streamChat(HttpServletResponse response,
                                           @RequestBody ChatRequest chatRequest) {
        response.setCharacterEncoding("UTF-8");

        TAsserts.notBlank(chatRequest.getRoleCode(), "角色不能为空");
        TAsserts.notBlank(chatRequest.getQuestionContent(), "问题不能为空");

        RoleType roleType = RoleType.getOrDefault(chatRequest.getRoleCode());
        Optional<Role> roleOp = RoleFactory.getRole(roleType);
        return roleOp.map(role -> TResult.success(ollamaFacade.streamChat(role, chatRequest.getQuestionContent()))).orElseGet(() -> TResult.fail(CommonError.PARAM_ERROR, "roleCode is invalid"));
    }
}
