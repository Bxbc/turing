package com.ai.turing.infrastructure.dao.base.memory.mapper;

import com.ai.turing.infrastructure.dao.base.memory.model.TuringMemoryDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

@Mapper
public interface TuringMemoryMapper extends BaseMapper<TuringMemoryDO> {

    @Select("select distinct conversation_id from `turing_memory`")
    List<String> findConversationIds();
}
