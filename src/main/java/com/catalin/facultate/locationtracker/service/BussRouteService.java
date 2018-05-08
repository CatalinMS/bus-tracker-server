package com.catalin.facultate.locationtracker.service;

import com.catalin.facultate.locationtracker.dto.BussRouteDto;
import com.catalin.facultate.locationtracker.mapper.BussRouteMapper;
import com.catalin.facultate.locationtracker.model.BussRoute;
import com.catalin.facultate.locationtracker.repository.BussRouteRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BussRouteService {

    private BussRouteMapper bussRouteMapper;
    private BussRouteRepository bussRouteRepository;

    public BussRouteService(BussRouteMapper bussRouteMapper, BussRouteRepository bussRouteRepository) {
        this.bussRouteMapper = bussRouteMapper;
        this.bussRouteRepository = bussRouteRepository;
    }

    public Flux<BussRouteDto> findAll() {
        return bussRouteRepository.findAll()
                .map(bussRouteMapper::toDto);
    }

    public Mono<BussRouteDto> findOne(String line) {
        return bussRouteRepository.findById(line)
                .map(bussRouteMapper::toDto);
    }

    public Mono<BussRouteDto> save(BussRouteDto bussRouteDto) {
        BussRoute bussRoute = bussRouteMapper.toEntity(bussRouteDto);

        return bussRouteRepository.save(bussRoute)
                .map(bussRouteMapper::toDto);
    }

}
