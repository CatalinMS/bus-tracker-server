package com.catalin.facultate.locationtracker.repository;

import com.catalin.facultate.locationtracker.model.BussRoute;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

public interface BussRouteRepository extends ReactiveSortingRepository<BussRoute, String> {

    Mono<BussRoute> findByDescription(String description);

}