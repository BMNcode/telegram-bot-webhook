package org.bmn.telegrambotwebhook.handle;

import lombok.extern.slf4j.Slf4j;
import org.bmn.telegrambotwebhook.TelegramBotWebhook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class BotUpdateHandle {

    private final TelegramBotWebhook telegramBotWebhook;

    @Autowired
    public BotUpdateHandle(TelegramBotWebhook telegramBotWebhook) {
        this.telegramBotWebhook = telegramBotWebhook;
    }

    public void botUpdateHandle(Update update) throws TelegramApiException {
        log.info("BotUpdateHandle -> botUpdateHandle -> update: {}", update);
        telegramBotWebhook.execute(new SendMessage(update.getMessage().getChatId().toString(), update.getMessage().getText()));
    }
}
