package com.ai.turing.domain.facade;

import com.ai.turing.domain.role.Role;
import org.springframework.ai.chat.prompt.Prompt;
import reactor.core.publisher.Flux;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-16 16:01
 *
 */

public interface OllamaFacade {

    String chat(Role role, String question);

    Flux<String> streamChat(Role role, String question);
}
