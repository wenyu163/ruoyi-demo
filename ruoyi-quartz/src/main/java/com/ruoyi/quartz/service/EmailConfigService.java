package com.ruoyi.quartz.service;

import com.ruoyi.quartz.domain.EmailConfig;
import org.springframework.stereotype.Service;


public interface EmailConfigService {

    void sendById(Integer emailConfigId,String receiver, String title, String content);

}
