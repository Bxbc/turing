package com.ai.turing.adaptor.controller;

import com.ai.turing.adaptor.controller.dto.RoleDTO;
import com.ai.turing.domain.common.result.TResult;
import com.ai.turing.domain.role.enums.RoleType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 * @date 2025-09-18 10:59
 *
 */

@RestController
@RequestMapping("/role")
public class RoleController {

    @GetMapping("/list")
    public TResult<List<RoleDTO>> getRoleList() {
        List<RoleDTO> collect = Arrays.stream(RoleType.values())
                .map(roleType -> RoleDTO.builder().name(roleType.getRoleDescription()).code(roleType.getRoleCode()).build())
                .toList();
        return TResult.success(collect);
    }
}
