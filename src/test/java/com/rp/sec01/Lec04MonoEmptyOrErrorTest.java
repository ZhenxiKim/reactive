package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Lec04MonoEmptyOrErrorTest {
    public static void main(String[] args) {
        Mono<String> testMono = userRepository(1);
        testMono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
        StepVerifier.create(testMono)
                .expectNext("apple")
                .verifyComplete();

    }

    private static Mono<String> userRepository(int userId){
        //1
        if(userId == 1){
            return Mono.just("apple");
        }else if(userId == 2){
            return Mono.empty();
        }else{
            return Mono.error(new RuntimeException("Not in the allowed range"));
        }
    }

}