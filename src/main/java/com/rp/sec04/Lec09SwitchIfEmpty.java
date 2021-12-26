package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec09SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallBack())
                .subscribe(Util.subscriber());

    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1,10);
    }
    private static Flux<Integer> fallBack(){
        return Flux.range(100,10);
    }
}
