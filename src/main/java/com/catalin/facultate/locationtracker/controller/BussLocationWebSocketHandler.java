package com.catalin.facultate.locationtracker.controller;

import com.catalin.facultate.locationtracker.dto.BussLocationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class BussLocationWebSocketHandler {

    @MessageMapping("/new-coordinate/{lineId}")
    @SendTo("/topic/line.{lineId}")
    public BussLocationDto sendMessageVariable(@DestinationVariable("lineId") String lineId,
                                               @Payload BussLocationDto bussLocationDto) {
        log.info("var Sending {} back {}", bussLocationDto, lineId);

        return bussLocationDto;
    }

}
