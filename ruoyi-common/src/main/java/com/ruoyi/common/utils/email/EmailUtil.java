package com.ruoyi.common.utils.email;


import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮件发送工具类
 */

public class EmailUtil {


    //发件人邮箱
    private static String DEFAULT_Encoding;


    private static String USER;

    //授权码
    private static String PWD;


    private static String HOST;


    /**
     * 创建邮件消息
     *
     * @return 创建的邮件消息
     */
    private static MimeMessage createMail() {
        try {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", true);
            properties.put("mail.smtp.host", HOST);
            properties.put("mail.user", USER);
            properties.put("mail.password", PWD);


            //SSL加密
            MailSSLSocketFactory msf = new MailSSLSocketFactory();
            msf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", msf);

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USER, PWD);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(properties, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送一个简单的文本邮件
     *
     * @param receiver    收件人邮箱
     * @param title 邮件标题
     * @param content  邮件内容
     * @return
     */
    public static boolean sendText(String receiver, String title, String content) {
        USER = EntityCode.USER;
        PWD = EntityCode.PWD;
        HOST = EntityCode.HOST;
        return sendTextMail(receiver, title, content);

    }


    /**
     * 发送一个简单的文本邮件
     *
     * @param receiver    收件人邮箱
     * @param title 邮件标题
     * @param content  邮件内容
     * @param username 发送人
     * @param password 授权码
     * @param host 地址
     * @return
     */
    public static boolean sendText(String receiver, String title, String content, String username, String password, String host) {
        USER = username;
        PWD = password;
        HOST = host;
        return sendTextMail(receiver, title, content);

    }

    /**
     * 发送一个简单的文本邮件
     *
     * @param to    收件人邮箱
     * @param title 邮件标题
     * @param text  邮件内容
     * @return
     */
    private static boolean sendTextMail(String to, String title, String text) {
        MimeMessage message = createMail();
        if (message == null) {
            return false;
        }
        try {
            // 设置发件人
            InternetAddress form = new InternetAddress(USER);
            message.setFrom(form);

            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // 设置邮件标题
            message.setSubject(title);

            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
