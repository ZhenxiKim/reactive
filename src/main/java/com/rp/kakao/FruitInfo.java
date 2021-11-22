package com.rp.kakao;

import java.util.List;
import java.util.Map;

public class FruitInfo {
    private final List<String> distinctFruits;
    private final Map<String, Long> countFruits;

    public FruitInfo(List<String> distinctFruits, Map<String, Long> countFruits) {
        this.distinctFruits = distinctFruits;
        this.countFruits = countFruits;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "FruitInfo{" +
                "distinctFruits=" + distinctFruits +
                ", countFruits=" + countFruits +
                '}';
    }
}
