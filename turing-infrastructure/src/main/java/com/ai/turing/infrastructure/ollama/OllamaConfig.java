package com.ai.turing.infrastructure.ollama;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

@Configuration
public class OllamaConfig {

    @Resource
    private ChatModel chatModel;

    @Resource
    private MessageWindowChatMemory messageWindowChatMemory;

    @Bean(name = "ollamaChatClient")
    public ChatClient ollamaChatClient() {
        return ChatClient.builder(chatModel)
                .defaultOptions(
                        OllamaOptions.builder()
                                .model("qwen3:30b")
                                .build()
                )
                .defaultAdvisors(PromptChatMemoryAdvisor.builder(messageWindowChatMemory).build())
                .build();
    }
}
