package com.ai.turing.infrastructure.facade;

import com.ai.turing.domain.facade.OllamaFacade;
import com.ai.turing.domain.role.Role;
import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-16 16:13
 *
 */

@Service
public class OllamaFacadeImpl implements OllamaFacade {

    @Resource(name = "ollamaChatClient")
    private ChatClient ollamaChatClient;

    @Override
    public String chat(Role role, String question) {
        return ollamaChatClient.prompt(role.getPrompt()).user(question).call().content();
    }

    @Override
    public Flux<String> streamChat(Role role, String question) {
        return ollamaChatClient.prompt(role.getPrompt()).user( question).stream().content();
    }
}
