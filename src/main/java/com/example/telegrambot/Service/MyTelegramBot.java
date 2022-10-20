package com.example.telegrambot.Service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MyTelegramBot extends TelegramLongPollingBot {
    private final Parse parse;
    private final String token = "5056421940:AAHV3nlWpmUd8_DrjbVHKICKkxt7SmmBbPM";
    private final String name = "AEAEAE140";

    public MyTelegramBot( Parse parse) {
        this.parse = parse;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        final long chatId = update.getMessage().getChatId();
        final String message = /*parse.getCourses();*/"assd";
        sendMessage(String.valueOf(chatId),message);
    }

    @Override
    public String getBotUsername() {
        return name;
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
