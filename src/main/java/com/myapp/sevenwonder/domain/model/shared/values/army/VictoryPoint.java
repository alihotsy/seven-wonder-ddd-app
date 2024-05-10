package com.myapp.sevenwonder.domain.model.shared.values.army;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;

import java.util.Objects;

public class VictoryPoint implements ValueObject<Integer> {
    private final Integer victoryPoint;

    public VictoryPoint(Integer victoryPoint) {
        if(Objects.isNull(victoryPoint)) {
            throw new IllegalArgumentException("Victory point must not be null");
        }

        if(victoryPoint < 0) {
            throw new IllegalArgumentException("Victory point must be positive");
        }
        this.victoryPoint = victoryPoint;
    }


    @Override
    public Integer value() {
        return victoryPoint;
    }
}
