package com.ai.turing.domain.facade;

import org.springframework.ai.document.Document;

import java.util.List;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-18 11:04
 *
 */


public interface DocumentFacade {

    /**
     * 保存文档
     */
    void save(List<Document> documentList);

    /**
     * 获取文档
     */
    List<Document> simpleQuery(String query, int topK, double threshold);
}
