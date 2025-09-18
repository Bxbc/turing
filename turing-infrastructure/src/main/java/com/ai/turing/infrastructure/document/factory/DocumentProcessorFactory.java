package com.ai.turing.infrastructure.document.factory;

import com.ai.turing.domain.document.enums.FileTypeEnum;
import com.ai.turing.infrastructure.document.processor.DocumentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-18 12:12
 *
 */

@Component
public class DocumentProcessorFactory {

    private static final Map<FileTypeEnum, DocumentProcessor> processorMap = new HashMap<>();

    @Autowired
    private void init(List<DocumentProcessor> documentProcessors) {
        for (DocumentProcessor documentProcessor : documentProcessors) {
            processorMap.put(documentProcessor.getFileType(), documentProcessor);
        }
    }

    public static Optional<DocumentProcessor> getProcessor(FileTypeEnum fileType) {
        return Optional.ofNullable(processorMap.get(fileType));
    }
}
