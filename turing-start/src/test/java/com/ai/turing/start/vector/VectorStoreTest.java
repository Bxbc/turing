package com.ai.turing.start.vector;

import com.ai.turing.start.TuringStartApplication;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-18 10:49
 *
 */

@SpringBootTest(classes = {TuringStartApplication.class})
public class VectorStoreTest {

    @Resource
    private VectorStore vectorStore;

    @Test
    public void vector_store_test() {
        List<Document> documents = List.of(
                new Document("风桐是一名服务端开发"),
                new Document("他是一个练习了两年半的篮球选手")
        );
        vectorStore.add(documents);
        List<Document> documentsResult= this.vectorStore.similaritySearch(
                SearchRequest.builder().query("风桐是谁")
                        .topK(5)
                        .build()
        );
        Assert.notEmpty(documentsResult, "vector store && search fail");
    }
}
