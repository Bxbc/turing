package com.ai.turing.adaptor.controller;

import com.ai.turing.domain.common.error.enums.CommonError;
import com.ai.turing.domain.common.result.TResult;
import com.ai.turing.domain.facade.OllamaFacade;
import com.ai.turing.domain.role.Role;
import com.ai.turing.domain.role.enums.RoleType;
import com.ai.turing.domain.role.factory.RoleFactory;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

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
    public TResult<String> chat(@RequestParam(value = "roleCode", required = false) String roleCode,
                        @RequestBody String questionContent) {
        RoleType roleType = RoleType.getOrDefault(roleCode);
        Optional<Role> roleOp = RoleFactory.getRole(roleType);
        return roleOp.map(role -> TResult.success(ollamaFacade.chat(role, questionContent))).orElseGet(() -> TResult.fail(CommonError.PARAM_ERROR, "roleCode is invalid"));
    }

    @PostMapping("/streamChat")
    public TResult<String> streamChat(HttpServletResponse response,  @RequestParam(value = "roleCode", required = false) String roleCode,
                                      @RequestBody String questionContent) {
        response.setCharacterEncoding("UTF-8");
        RoleType roleType = RoleType.getOrDefault(roleCode);
        Optional<Role> roleOp = RoleFactory.getRole(roleType);
        return roleOp.map(role -> TResult.success(ollamaFacade.streamChat(role, questionContent).blockFirst())).orElseGet(() -> TResult.fail(CommonError.PARAM_ERROR, "roleCode is invalid"));
    }
}
