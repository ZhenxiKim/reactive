package com.rp.kakao;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.Arrays;

public class FruitBasket {
    public static void main(String[] args) {
        final List<String> basket1 = Arrays.asList(new String[]{"kiwi", "orange", "lemon", "orange", "lemon", "kiwi"});
        final List<String> basket2 = Arrays.asList(new String[]{"banana", "lemon", "lemon", "kiwi"});
        final List<String> basket3 = Arrays.asList(new String[]{"strawberry", "orange", "lemon", "grape", "strawberry"});
        final List<List<String>> baskets = Arrays.asList(basket1,basket2,basket3);
        final Flux<List<String>> basketFlux = Flux.fromIterable(baskets);

        //basketFlux 중복없이 각 과일 종류 나열 및 각 과일 개수 체크
        basketFlux.concatMap(basket -> {
            final Mono<List<String>> distinctFruits = Flux.fromIterable(basket).distinct().collectList();
            final Mono<Map<String, Long>> countFruitsMono = Flux.fromIterable(basket)
                    .groupBy(fruit -> fruit).log("=====> groupBy") // 바구니로 부터 넘어온 과일 기준으로 group을 묶는다.
                    .concatMap(groupedFlux -> groupedFlux.count()
                            .map(count -> {
                                final Map<String, Long> fruitCount = new LinkedHashMap<>();
                                fruitCount.put(groupedFlux.key(), count);
                                return fruitCount;
                            }).log("=====> map ") // 각 과일별로 개수를 Map으로 리턴
                    ).log("=====> concatMap ") // concatMap으로 순서보장
                    .reduce((accumulatedMap, currentMap) -> new LinkedHashMap<String, Long>() { {
                        putAll(accumulatedMap);
                        putAll(currentMap);
                    }}).log("=====> reduce"); // 그동안 누적된 accumulatedMap에 현재 넘어오는 currentMap을 합쳐서 새로운 Map을 만든다. // map끼리 putAll하여 하나의 Map으로 만든다.
            return Flux.zip(distinctFruits, countFruitsMono, (distinct, count) -> new FruitInfo(distinct, count)).log("=====> Flux.zip");
        }).subscribe(System.out::println);
    }
}
