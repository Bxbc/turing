package com.ai.turing.adaptor.controller;

import com.ai.turing.domain.facade.OllamaFacade;
import com.ai.turing.domain.role.Role;
import com.ai.turing.domain.role.enums.RoleType;
import com.ai.turing.domain.role.factory.RoleFactory;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/chat")
    public String chat(@RequestParam(value = "roleCode", required = false) String roleCode,
                       @RequestParam(value = "question", required = false) String question) {
        RoleType roleType = RoleType.getOrDefault(roleCode);
        Optional<Role> roleOp = RoleFactory.getRole(roleType);
        if(roleOp.isEmpty()) {
            return "角色不存在";
        }
        return ollamaFacade.chat(roleOp.get(), question);
    }
}
