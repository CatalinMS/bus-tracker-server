package com.catalin.facultate.locationtracker.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bussRoutes")
public class BussRoute {

    @Id
    private String line;

    private String description;

    private List<BussStation> bussStations;

}
