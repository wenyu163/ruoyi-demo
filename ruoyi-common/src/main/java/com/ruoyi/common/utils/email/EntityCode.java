package com.ruoyi.common.utils.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EntityCode {

    //发件人邮箱
    public  static  String DEFAULT_Encoding;

    @Value("${spring.mail.default-encoding}")
    private String defaultEncoding;


    //发件人邮箱
    public static String USER;

    @Value("${spring.mail.username}")
    private String user;



    //授权码
    public static String PWD;

    @Value("${spring.mail.password}")
    private String pwd;


    //发送给对应的app,如果是163邮箱:smtp.163.com
    public static String HOST;

    @Value("${spring.mail.host}")
    private String host;

    @PostConstruct
    private void init(){
        DEFAULT_Encoding = defaultEncoding;
        USER = user;
        PWD = pwd;
        HOST = host;
    }

}
