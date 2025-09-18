package com.ai.turing.infrastructure.document.processor;

import com.ai.turing.domain.document.enums.FileTypeEnum;
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
 * @date 2025-09-18 12:10
 *
 */

public interface DocumentProcessor {

    FileTypeEnum getFileType();

    List<Document> process(MultipartFile file);
}
