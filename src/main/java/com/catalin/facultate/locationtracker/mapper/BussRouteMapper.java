package com.catalin.facultate.locationtracker.mapper;

import com.catalin.facultate.locationtracker.dto.BussRouteDto;
import com.catalin.facultate.locationtracker.model.BussRoute;
import com.catalin.facultate.locationtracker.util.MapperUtils;
import org.springframework.stereotype.Component;

@Component
public class BussRouteMapper {

    private BussStationMapper bussStationMapper;

    public BussRouteMapper(BussStationMapper bussStationMapper) {
        this.bussStationMapper = bussStationMapper;
    }

    public BussRoute toEntity(BussRouteDto bussRouteDto) {
        return BussRoute.builder()
                .line(bussRouteDto.getLine())
                .description(bussRouteDto.getDescription())
                .bussStations(MapperUtils.convertList(bussRouteDto.getBussStations(), bussStationMapper::toEntity))
                .build();
    }

    public BussRouteDto toDto(BussRoute bussRoute) {
        return BussRouteDto.builder()
                .line(bussRoute.getLine())
                .description(bussRoute.getDescription())
                .bussStations(MapperUtils.convertList(bussRoute.getBussStations(), bussStationMapper::toDto))
                .build();
    }

}
