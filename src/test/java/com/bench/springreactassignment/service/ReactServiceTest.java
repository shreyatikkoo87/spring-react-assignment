package com.bench.springreactassignment.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class ReactServiceTest {
    ReactService service = new ReactService();




    @Test
    void namesMono_map() {
        ReactService reactService = new ReactService();
        Mono<String> response = reactService.namesMono_map(10);
        StepVerifier.create(response).expectNext("TEST").verifyComplete();
    }

    @Test
    void demoFlatMap() {
        ReactService reactService = new ReactService();
        Mono<String>name = reactService.demoFlatMap();
        StepVerifier.create(name).expectNext("SHREYA").verifyComplete();
    }

    @Test
    void demoFlatMapFlux() {
        ReactService reactService = new ReactService();
        Flux<String> names = reactService.demoFlatMapFlux();
        StepVerifier.create(names).expectNext("SHREYA","MAYANK").verifyComplete();


    }

    @Test
    void namesMono_map_filter_switch_if_empty() {
        Flux<String> names = service.namesMono_map_filter_switch_if_empty(10);
        StepVerifier.create(names).expectNext("no data found").verifyComplete();
    }


    @Test
    void demoConcatStreams() {
        Flux<String> names = service.demoConcatStreamsStatic();
        StepVerifier.create(names).expectNext("shreya","mayank","usha","ashok").verifyComplete();
    }
    @Test
    void demoConcatStreamsNonStatic() {
        Flux<String> names = service.demoConcatStreamsNonStatic();
        StepVerifier.create(names).expectNext("shreya","mayank","usha","ashok").verifyComplete();
    }

    @Test
    void demoMergeStreamsNonStatic() {
        Flux<String> names = service.demoMergeStreamsNonStatic();
        StepVerifier.create(names).expectNext("shreya","mayank","usha","ashok").verifyComplete();
    }


    @Test
    void demoMergeStreamsStatic() {
        Flux<String> names = service.demoMergeStreamsStatic();
        StepVerifier.create(names).expectNext("shreya","mayank","usha","ashok").verifyComplete();
    }

    @Test
    void demoZip() {
       Flux<String>zipTuple = service.demoZip();
       StepVerifier.create(zipTuple).expectNext("shreyaushaUSHAAarya").verifyComplete();
    }
}