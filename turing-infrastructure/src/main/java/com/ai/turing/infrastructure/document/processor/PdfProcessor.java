package com.ai.turing.infrastructure.document.processor;

import com.ai.turing.domain.document.enums.FileTypeEnum;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.ParagraphPdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
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
 * @date 2025-09-18 12:16
 *
 */

@Component
public class PdfProcessor implements DocumentProcessor {

    @Override
    public FileTypeEnum getFileType() {
        return FileTypeEnum.PDF;
    }

    @Override
    public List<Document> process(MultipartFile file) {

        PdfDocumentReaderConfig config = PdfDocumentReaderConfig.defaultConfig();
        PagePdfDocumentReader paragraphPdfDocumentReader = new PagePdfDocumentReader(file.getResource(), config);
        return paragraphPdfDocumentReader.read();
    }
}
