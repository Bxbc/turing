package com.ai.turing.infrastructure.dao.base.memory.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * <p>
 * Copyright (C) Taobao.com 淘宝（中国）软件有限公司 版权所有.
 * 淘天集团-业务技术-天猫技术-新品营销技术
 * </p>
 *
 * @author bixi
 * @description:
 * @date 2025-09-17 14:33
 *
 */

@Getter
@Setter
@ToString
@TableName("turing_memory")
public class TuringMemoryDO {

    @TableId(type = IdType.ASSIGN_ID)
    private String conversationId;

    private LocalDate gmtCreate;

    private String content;

    private String type;
}
