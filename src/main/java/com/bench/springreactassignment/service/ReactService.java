package com.bench.springreactassignment.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
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
        return s.map(String::toUpperCase).filter(e -> e.length()>i).switchIfEmpty(Flux.just("no data found"));
    }
/*
    public Flux<String> namesFlux_flatMapMany() {
        Flux<String> s = Flux.just("Shreya","Mayank","Aarya");
         s.flatM;
    }*/

    public Mono<String> demoFlatMap(){
        Mono<String> name = Mono.just("shreya");
        return name.flatMap(ReactService::transformUpperCase);
    }

    public static Mono<String> transformUpperCase(String s){
       String name = s.toUpperCase();
       return Mono.just(name);
    }

    public Flux<String> demoFlatMapFlux(){
        Flux<String> name = Flux.just("shreya","mayank");
        return name.flatMap(ReactService::transformUpperCaseFlux);
    }

    private static Flux<String> transformUpperCaseFlux(String s) {
        String name = s.toUpperCase();
        return Flux.just(name);
    }

    public Flux<String> demoConcatStreamsStatic(){
        Flux<String> name1 = Flux.just("shreya","mayank");
        Flux<String> name2 = Flux.just("usha","ashok");
        name1.concatWith(name2);
        return Flux.concat(name1,name2);
    }

    public Flux<String> demoConcatStreamsNonStatic(){
        Flux<String> name1 = Flux.just("shreya","mayank");
        Flux<String> name2 = Flux.just("usha","ashok");
        return name1.concatWith(name2);
    }

    public Flux<String> demoMergeStreamsNonStatic(){
        Flux<String> name1 = Flux.just("shreya","mayank");
        Flux<String> name2 = Flux.just("usha","ashok");
        return name1.mergeWith(name2);
    }

    public Flux<String> demoMergeStreamsStatic(){
        Flux<String> name1 = Flux.just("shreya","mayank");
        Flux<String> name2 = Flux.just("usha","ashok");
        return Flux.merge(name1,name2);
    }


}
