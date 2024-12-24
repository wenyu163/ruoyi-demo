package com.ruoyi.web.service;

import com.ruoyi.web.controller.demo.controller.ExecBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBotService {

    @Autowired
    public TelegramBotService(TelegramBotsApi telegramBotsApi, ExecBot execBot) {
        try {
            telegramBotsApi.registerBot(execBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}