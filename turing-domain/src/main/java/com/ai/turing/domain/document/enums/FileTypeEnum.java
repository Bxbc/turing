package com.ai.turing.domain.document.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-18 11:59
 *
 */

@AllArgsConstructor
@Getter
public enum FileTypeEnum {

    PDF("pdf", "PDF"),

    MARKDOWN("md", "Markdown"),

    TEXT("txt", "Text"),
    ;

    private final String code;

    private final String desc;

    public static FileTypeEnum findOf(String code) {
        for (FileTypeEnum value : FileTypeEnum.values()) {
            if (value.code.equalsIgnoreCase(code)) {
                return value;
            }
        }
        return null;
    }
}
