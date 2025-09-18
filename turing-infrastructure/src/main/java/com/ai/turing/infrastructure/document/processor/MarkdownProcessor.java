package com.ai.turing.infrastructure.document.processor;

import com.ai.turing.domain.document.enums.FileTypeEnum;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.markdown.MarkdownDocumentReader;
import org.springframework.ai.reader.markdown.config.MarkdownDocumentReaderConfig;
import org.springframework.stereotype.Component;
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
 * @date 2025-09-18 12:53
 *
 */

@Component
public class MarkdownProcessor implements DocumentProcessor {
    @Override
    public FileTypeEnum getFileType() {
        return FileTypeEnum.MARKDOWN;
    }
    @Override
    public List<Document> process(MultipartFile file) {
        MarkdownDocumentReaderConfig config = MarkdownDocumentReaderConfig.builder()
                .withIncludeBlockquote( true)
                .withHorizontalRuleCreateDocument( true)
                .withIncludeCodeBlock( true)
                .build();
        MarkdownDocumentReader markdownDocumentReader = new MarkdownDocumentReader(file.getResource(), config);
        return markdownDocumentReader.get();
    }
}
