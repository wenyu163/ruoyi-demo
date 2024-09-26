package com.ruoyi.quartz.service.impl;

import com.ruoyi.common.utils.email.EmailUtil;
import com.ruoyi.quartz.domain.EmailConfig;
import com.ruoyi.quartz.mapper.EmailConfigMapper;
import com.ruoyi.quartz.service.EmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailConfigServiceImpl implements EmailConfigService {

    @Autowired
    private EmailConfigMapper emailConfigMapper;


    public void sendEmail(String receiver, String title, String content, EmailConfig emailConfig) {

        boolean b = EmailUtil.sendText(receiver, title, content,emailConfig.getUsername(),emailConfig.getPassword(),emailConfig.getHost());
        System.out.println("发送成功");
    }

    public void sendEmail(String receiver, String title, String content) {
        boolean b = EmailUtil.sendText(receiver, title, content);
        System.out.println("发送成功");
    }

    @Override
    public void sendById(Integer emailConfigId,String receiver, String title, String content) {
        if (emailConfigId == null){
            sendEmail(receiver,title,content);
        }else {
            EmailConfig emailConfig = emailConfigMapper.getById(emailConfigId);
            sendEmail(receiver,title,content,emailConfig);
        }

    }



}
