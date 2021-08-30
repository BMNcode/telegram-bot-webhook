package org.bmn.telegrambotwebhook.controller;

import lombok.extern.slf4j.Slf4j;
import org.bmn.telegrambotwebhook.TelegramBotWebhook;
import org.bmn.telegrambotwebhook.dto.MessageDto;
import org.bmn.telegrambotwebhook.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 *ходим на удаленный сервис, триггерим сообщение в очередь, после забираем из очереди сообщение, передаем
 * управление onWebhookUpdateReceived
 */

@RestController
@RequestMapping("/")
@Slf4j
public class BotController {
    private final MessageService messageService;
    private final TelegramBotWebhook telegramBotWebhook;

    @Autowired
    public BotController(MessageService messageService, TelegramBotWebhook telegramBotWebhook) {
        this.messageService = messageService;
        this.telegramBotWebhook = telegramBotWebhook;
    }

    @PostMapping
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {

        log.info("controller -> onUpdateReceiver -> update : {}", update.toString());
        log.info("controller -> onUpdateReceiver -> trigger");
        messageService.triggerMessage(update); //триггер -> вариант просто попробовать
        return telegramBotWebhook.onWebhookUpdateReceived(update);
    }
}
