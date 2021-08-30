package org.bmn.telegrambotwebhook.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MessageDto {
    private String text;
}
