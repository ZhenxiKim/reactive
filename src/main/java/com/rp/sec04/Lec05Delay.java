package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class Lec05Delay {
    public static void main(String[] args) {
            Flux.range(1,100)
                    .log()

                    .delayElements(Duration.ofMillis(100))
                    .subscribe(System.out::println);
        Util.sleepSeconds(60);

    }
}
