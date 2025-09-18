package com.ai.turing.infrastructure.document;

import com.ai.turing.domain.common.asserts.TAsserts;
import com.ai.turing.domain.common.utils.FileUtils;
import com.ai.turing.domain.document.DocumentService;
import com.ai.turing.domain.document.enums.FileTypeEnum;
import com.ai.turing.infrastructure.document.factory.DocumentProcessorFactory;
import com.ai.turing.infrastructure.document.processor.DocumentProcessor;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
public class DocumentServiceImpl implements DocumentService {

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

    @Override
    public List<Document> read(MultipartFile file) {

        TAsserts.notNull(file, "文件内容不能为空");
        String originalFilename = file.getOriginalFilename();

        String fileType = FileUtils.getFileType(originalFilename);

        FileTypeEnum fileTypeEnum = FileTypeEnum.findOf(fileType);
        TAsserts.notNull(fileTypeEnum, "不支持的文件类型");

        Optional<DocumentProcessor> processorOp = DocumentProcessorFactory.getProcessor(fileTypeEnum);
        TAsserts.isTrue(processorOp.isPresent(), "未找到对应的文档解析器");

        List<Document> documentList = processorOp.get().process(file);
        TokenTextSplitter splitter = new TokenTextSplitter();
        return splitter.apply(documentList);
    }
}
