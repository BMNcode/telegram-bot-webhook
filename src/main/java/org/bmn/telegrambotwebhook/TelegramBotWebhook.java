package org.bmn.telegrambotwebhook;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.bmn.telegrambotwebhook.handle.BotUpdateHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * класс унаследованный от телеграмм апи для переопределения настроек бота
 */

@Setter
@Slf4j
public class TelegramBotWebhook extends TelegramWebhookBot {

    private String botUserName;
    private String botToken;
    private String botWebHookPath;

    public TelegramBotWebhook() {

    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        log.info("TelegramBotWebhook -> onWebhookUpdateReceived -> update: {}", update);
//        log.info("TelegramBotWebhook -> onWebhookUpdateReceived -> SendMessage: {}", sendMessage);
        return null;
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotPath() {
        return botWebHookPath;
    }


}
