package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
        Flux.range(1,10)
                .next()
                .filter(i -> i > 3)
                .subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}
