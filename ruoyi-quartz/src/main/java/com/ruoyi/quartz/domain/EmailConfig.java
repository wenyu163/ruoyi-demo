package com.ruoyi.quartz.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 邮件配置表 email_config
 *
 * @author ruoyi
 */
@Data
public class EmailConfig extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Integer emailConfigId;

    private String defaultEncoding;

    private String host;

    private String username;

    private String password;

}
