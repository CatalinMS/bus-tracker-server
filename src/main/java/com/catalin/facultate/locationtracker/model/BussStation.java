package com.catalin.facultate.locationtracker.model;

import lombok.*;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class BussStation {

    private String name;

    private GeoJsonPoint location;

}
