package com.catalin.facultate.locationtracker.model;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Data
@Builder
@RequiredArgsConstructor
public class Event {

    private final int id;

    private final Type type;

    private final String busLine;

    private final Instant timestamp;

    public enum Type {
        NEW_COORDINATE, REQUEST_COORDINATE;
    }

}
