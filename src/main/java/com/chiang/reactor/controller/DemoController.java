package com.chiang.reactor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequestMapping("/demo")
@RestController
public class DemoController {

    public Mono<String> test() {
        return Mono.just(new String("hello World"));
    }
}
