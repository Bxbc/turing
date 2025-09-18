package com.ai.turing.adaptor.controller;

import com.ai.turing.adaptor.controller.dto.AvailableFileTypeDTO;
import com.ai.turing.domain.common.asserts.TAsserts;
import com.ai.turing.domain.common.result.TResult;
import com.ai.turing.domain.document.DocumentService;
import com.ai.turing.domain.document.enums.FileTypeEnum;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-18 11:02
 *
 */

@RestController
@RequestMapping("/knowledge")
public class KnowledgeController {

    @Resource
    private DocumentService documentService;

    @PostMapping("/input")
    public TResult<Void> input(@RequestBody String input) {
        TAsserts.notBlank(input, "输入不能为空");
        Document document = new Document( input);
        documentService.save(List.of(document));
        return TResult.success(null);
    }

    @PostMapping("/file/upload")
    @SneakyThrows
    public TResult<Void> uploadFile(@RequestParam MultipartFile file) {

        List<Document> readResult = documentService.read(file);
        documentService.save(readResult);

        return TResult.success(null);
    }


    @GetMapping("/file/type/available")
    public TResult<List<AvailableFileTypeDTO>> listAvailableFileType() {
        List<AvailableFileTypeDTO> availableFileTypeDTOS = Arrays.stream(FileTypeEnum.values())
                .map(fileTypeEnum -> AvailableFileTypeDTO.builder().code(fileTypeEnum.getCode()).name(fileTypeEnum.getDesc()).build())
                .toList();
        return TResult.success(availableFileTypeDTOS);
    }
}
