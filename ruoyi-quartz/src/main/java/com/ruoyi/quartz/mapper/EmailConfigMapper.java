package com.ruoyi.quartz.mapper;


import com.ruoyi.quartz.domain.EmailConfig;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailConfigMapper {
    EmailConfig getById(Integer emailConfigId);
}
