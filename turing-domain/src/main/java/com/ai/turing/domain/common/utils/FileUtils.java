package com.ai.turing.domain.common.utils;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-18 12:03
 *
 */

public final class FileUtils {

    public static String getFileType(String fileName) {
        String fileType = "";
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex > -1) {
            fileType = fileName.substring(dotIndex + 1);
        }
        return fileType;
    }
}
