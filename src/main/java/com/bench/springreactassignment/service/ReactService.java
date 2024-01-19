package com.bench.springreactassignment.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class ReactService {
    public Mono<String> namesMono_map(int i) {
        Mono<String> s = Mono.just("test");
        return s.map(String::toUpperCase);
    }

    public Flux<String> namesMono_map_filter(int i) {
        Flux<String> s = Flux.just("Shreya","Mayank","Aarya");
        return s.map(String::toUpperCase).filter(e -> e.length()>i);
    }

    public Flux<String> namesMono_map_filter_default_if_empty(int i) {
        Flux<String> s = Flux.just("Shreya","Mayank","Aarya");
        return s.map(String::toUpperCase).filter(e -> e.length()>i).defaultIfEmpty("no string found");
    }

    public Flux<String> namesMono_map_filter_switch_if_empty(int i) {
        Flux<String> s = Flux.just("Shreya","Mayank","Aarya");
        return s.map(String::toUpperCase).filter(e -> e.length()>i).switchIfEmpty(Mono.just("no data found"));
    }


}
