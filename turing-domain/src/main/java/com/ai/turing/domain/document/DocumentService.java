package com.ai.turing.domain.document;

import org.springframework.ai.document.Document;
import org.springframework.web.multipart.MultipartFile;

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


public interface DocumentService {

    /**
     * 保存文档
     */
    void save(List<Document> documentList);

    /**
     * 获取文档
     */
    List<Document> simpleQuery(String query, int topK, double threshold);

    /**
     * 获取文档
     * @param file 上传的文件
     * @return 文档
     */
    List<Document> read(MultipartFile file);
}
