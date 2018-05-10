package com.catalin.facultate.locationtracker.controller;

import com.catalin.facultate.locationtracker.dto.BussRouteDto;
import com.catalin.facultate.locationtracker.service.BussRouteService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/buss-routes")
public class BussRouteController {

    private BussRouteService bussRouteService;

    public BussRouteController(BussRouteService bussRouteService) {
        this.bussRouteService = bussRouteService;
    }

    @GetMapping
    Flux<BussRouteDto> findAll() {
        return bussRouteService.findAll();
    }

    @PostMapping
    Mono<BussRouteDto> save(@RequestBody BussRouteDto bussRoute) {
        return bussRouteService.save(bussRoute);
    }

    @GetMapping("/{lineId}")
    Mono<BussRouteDto> findOne(@PathVariable String lineId) {
        return bussRouteService.findOne(lineId);
    }

    @GetMapping("/line-numbers")
    Mono<List<String>> getLineNumbers() {
        return bussRouteService.getLineNumbers();
    }

}
