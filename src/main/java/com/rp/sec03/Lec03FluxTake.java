package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake{
    public static void main(String[] args) {
        Flux.range(1,10)
                .log()
                .take(3)//cancels 구독취소 complete signal to the downstream
                .log()
                .subscribe(Util.subscriber());
        //complete signal to the downstream he canceled that cancles the upstream subscription.
        //구독 취소하자마자 upstream은 4번쨰 아이템 방출하지않음

    }
}
