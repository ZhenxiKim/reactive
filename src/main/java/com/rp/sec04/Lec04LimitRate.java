package com.rp.sec04;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec04LimitRate {
    public static void main(String[] args) {
        Flux.range(1,100)
                .log()
                .limitRate(10)
               // .delayElements(Duration.ofMillis(100))
                .subscribe(System.out::println);
    }
}
