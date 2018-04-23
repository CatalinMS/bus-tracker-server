package com.catalin.facultate.locationtracker.controller;

import com.catalin.facultate.locationtracker.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Slf4j
@Controller
public class LinesController {

    @MessageMapping("/new-coordinate")
    @SendTo("/topic/line")
    public Event sendMessage(@Payload Event event) {
        Event response = Event.builder()
                .timestamp(Instant.now())
                .busLine(event.getBusLine())
                .build();

        log.info("Sending back {}", response);

        return response;
    }

    @MessageMapping("/new-coordinate/{line}")
    @SendTo("/topic/line")
    public Event sendMessageVariable(@DestinationVariable("line") String line, @Payload Event event) {
        Event response = Event.builder()
                .timestamp(Instant.now())
                .busLine(line)
                .build();

        log.info("Sending {} back {}", response, line);

        return response;
    }

}
