package com.example.telegrambot.Config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
@Setter
public class BotConfig {
    @Value("${telegram-bot-token}")
    private String token;
    @Value("${telegram-bot-name}")
    private String name;
}
