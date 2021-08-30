package org.bmn.telegrambotwebhook.config;

import lombok.Getter;
import lombok.Setter;
import org.bmn.telegrambotwebhook.TelegramBotWebhook;
import org.bmn.telegrambotwebhook.handle.BotUpdateHandle;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  конфигурируем телеграмм апи, передаем из свойств название, токен и вебхук бота
 */

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegram")
public class BotConfig {
    private String botUserName;
    private String botToken;
    private String botWebHookPath;

    @Bean
    public TelegramBotWebhook telegramBotWebhook() {
        TelegramBotWebhook telegramBotWebhook = new TelegramBotWebhook();
        telegramBotWebhook.setBotUserName(botUserName);
        telegramBotWebhook.setBotToken(botToken);
        telegramBotWebhook.setBotWebHookPath(botWebHookPath);

        return telegramBotWebhook;
    }
}
