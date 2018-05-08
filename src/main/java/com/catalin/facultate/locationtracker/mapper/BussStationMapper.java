package com.catalin.facultate.locationtracker.mapper;

import com.catalin.facultate.locationtracker.dto.BussStationDto;
import com.catalin.facultate.locationtracker.model.BussStation;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Component;

@Component
public class BussStationMapper {

    public BussStation toEntity(BussStationDto bussStationDto) {
        return BussStation.builder()
                .name(bussStationDto.getName())
                .location(buildLocation(bussStationDto))
                .build();
    }

    private GeoJsonPoint buildLocation(BussStationDto bussStationDto) {
        return new GeoJsonPoint(bussStationDto.getLongitude(), bussStationDto.getLatitude());
    }

    public BussStationDto toDto(BussStation bussStation) {
        return BussStationDto.builder()
                .name(bussStation.getName())
                .latitude(bussStation.getLocation().getY())
                .longitude(bussStation.getLocation().getX())
                .build();
    }

}
