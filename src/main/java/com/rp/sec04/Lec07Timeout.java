package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07Timeout {
    public static void main(String[] args) {
        getOrderNumbers()
                .timeout(Duration.ofSeconds(2),fallBack())
                .subscribe(Util.subscriber());
                Util.sleepSeconds(60);
    }
    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(10));
    }
    private static Flux<Integer> fallBack(){
        return Flux.range(100,10)
                .delayElements(Duration.ofMillis(200));
    }
}
