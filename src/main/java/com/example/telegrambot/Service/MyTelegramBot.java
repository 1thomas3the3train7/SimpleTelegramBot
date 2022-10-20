package com.example.telegrambot.Service;

import com.example.telegrambot.Config.BotConfig;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MyTelegramBot extends TelegramLongPollingBot {
    private final BotConfig botConfig;
    private final Parse parse;

    public MyTelegramBot(BotConfig botConfig, Parse parse) {
        this.botConfig = botConfig;
        this.parse = parse;
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        final long chatId = update.getMessage().getChatId();
        final String message = parse.getCourses();
        sendMessage(String.valueOf(chatId),message);
    }

    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }
    private void sendMessage(final String chatId,final String message){
        final SendMessage sendMessage = new SendMessage(chatId,message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
