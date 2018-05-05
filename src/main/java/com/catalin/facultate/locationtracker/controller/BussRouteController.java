package com.catalin.facultate.locationtracker.controller;

import com.catalin.facultate.locationtracker.dto.BussRouteDto;
import com.catalin.facultate.locationtracker.model.BussRoute;
import com.catalin.facultate.locationtracker.service.BussRouteService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/buss-routes")
public class BussRouteController {

    private BussRouteService bussRouteService;

    public BussRouteController(BussRouteService bussRouteService) {
        this.bussRouteService = bussRouteService;
    }

    @GetMapping
    Flux<BussRoute> findAll() {
        return bussRouteService.findAll();
    }

    @PostMapping
    Mono<BussRouteDto> save(@RequestBody BussRouteDto bussRoute) {
        return bussRouteService.save(bussRoute);
    }

}
