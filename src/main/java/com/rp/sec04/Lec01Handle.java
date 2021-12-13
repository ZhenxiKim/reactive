package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {
    public static void main(String[] args) {
        //handle = map + filter
        Flux.range(1,20)
                .handle((integer, synchronousSink) -> {
                    if(integer == 7)
                        synchronousSink.next(integer);
                    else
                        synchronousSink.next(integer);
                }).subscribe(Util.subscriber());
    }
}
