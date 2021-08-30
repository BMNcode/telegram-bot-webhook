package org.bmn.telegrambotwebhook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
@Slf4j
public class TelegramBotWebhookApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramBotWebhookApplication.class, args);
	}
}
