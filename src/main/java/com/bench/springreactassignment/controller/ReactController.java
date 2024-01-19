package com.bench.springreactassignment.controller;

import com.bench.springreactassignment.service.ReactService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/assignment1")
@AllArgsConstructor
public class ReactController {

    ReactService reactService;

    @GetMapping("/getNames")
    public ResponseEntity<Mono<String>> getNames(){
       Mono<String> namesMono = reactService.namesMono_map(5);
        return ResponseEntity.ok(namesMono);
    }

    @GetMapping("/filteredNames")
    public ResponseEntity<Flux<String>> getNamesFilter(){
        Flux<String> namesMono = reactService.namesMono_map_filter(5);
        return ResponseEntity.ok(namesMono);
    }

    @GetMapping("/filteredNamesDefaultIfEmpty")
    public ResponseEntity<?> getNamesFilterDefaultIfEmpty(){
        Flux<String> namesMono = reactService.namesMono_map_filter_default_if_empty(10);
        return ResponseEntity.ok(namesMono);
    }

    @GetMapping("/filteredNamesSwitchIfEmpty")
    public ResponseEntity<?> getNamesFilterSwitchIfEmpty(){
        Flux<String> namesMono = reactService.namesMono_map_filter_switch_if_empty(10);
        return ResponseEntity.ok(namesMono);
    }

}
