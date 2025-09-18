package com.ai.turing.infrastructure.facade;

import com.ai.turing.domain.facade.DocumentFacade;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-18 11:08
 *
 */

@Service
public class DocumentFacadeImpl implements DocumentFacade {

    @Resource
    private VectorStore vectorStore;

    @Override
    public void save(List<Document> documentList) {
        if(CollectionUtils.isEmpty(documentList)) {
            return;
        }
        vectorStore.add(documentList);
    }

    @Override
    public List<Document> simpleQuery(String query, int topK, double threshold) {
        if(StringUtils.isBlank(query)) {
            return Collections.emptyList();
        }
        SearchRequest searchRequest = SearchRequest.builder()
                .query(query)
                .topK(topK)
                .similarityThreshold(threshold)
                .build();
        return vectorStore.similaritySearch(searchRequest);
    }
}
