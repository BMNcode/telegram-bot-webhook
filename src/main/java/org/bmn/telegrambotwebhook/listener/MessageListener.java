package org.bmn.telegrambotwebhook.listener;

import lombok.extern.slf4j.Slf4j;
import org.bmn.telegrambotwebhook.TelegramBotWebhook;
import org.bmn.telegrambotwebhook.handle.BotUpdateHandle;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * слушаем очередь, выдаем шутку в телеграм по запросу из очереди
 */

@Service
@Slf4j
public class MessageListener {

    private final BotUpdateHandle botUpdateHandle;

    @Autowired
    public MessageListener(BotUpdateHandle botUpdateHandle) {
        this.botUpdateHandle = botUpdateHandle;
    }

    @RabbitListener(queues = "telegram_queue")
    public void getMessage(Update update) throws TelegramApiException {
        log.info("MessageListener -> getMessage -> update : {}", update);
        botUpdateHandle.botUpdateHandle(update);
    }
}
