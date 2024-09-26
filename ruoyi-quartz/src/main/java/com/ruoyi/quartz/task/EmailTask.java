package com.ruoyi.quartz.task;


import com.ruoyi.quartz.service.EmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("emailTask")
public class EmailTask {
    @Autowired
    private EmailConfigService emailConfigService;


    public void send(Integer emailConfigId,String receiver, String title, String content){
        emailConfigService.sendById(emailConfigId,receiver,title,content);
    }


    public void send(String receiver, String title, String content){
        Integer emailConfigId = null;
        emailConfigService.sendById(emailConfigId,receiver,title,content);
    }

    public void send( String title, String content){
        Integer emailConfigId = null;
        String receiver = "ren1484312422@gmail.com";
        emailConfigService.sendById(emailConfigId,receiver,title,content);
    }


    public void send(String content){
        Integer emailConfigId = null;
        String receiver = "ren1484312422@gmail.com";
        String title = "该锻炼啦";
        emailConfigService.sendById(emailConfigId,receiver,title,content);
    }


}
