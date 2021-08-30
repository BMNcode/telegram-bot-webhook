package org.bmn.telegrambotwebhook.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.telegram.telegrambots.meta.api.objects.Update;
import reactor.core.publisher.Mono;

/**
 *  сервис удаленного обращения к ресурсу, в данный момент служит триггером, то есть ничего не получает
 */

@Service
@Slf4j
public class MessageService {

    private final WebClient webClient;

    @Autowired
    public MessageService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9595/").build();
    }

    public Update triggerMessage(Update update) {
        log.info("MessageService -> triggerMessage -> update: {}", update);
        return webClient
                .post()
                .body(Mono.just(update), Update.class)
                .retrieve()
                .bodyToMono(Update.class)
                .block();
    }
}
