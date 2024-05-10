package com.myapp.sevenwonder.domain.model.shared.values.army;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;

import java.util.Objects;

public class DefeatPoint implements ValueObject<Integer> {
    private final Integer defeatPoint;

    public DefeatPoint(Integer defeatPoint) {
        if(Objects.isNull(defeatPoint)) {
            throw new IllegalArgumentException("Defeat point must not be null");
        }

        if(defeatPoint > 0) {
            throw new IllegalArgumentException("Defeat point must be negative");
        }
        this.defeatPoint = defeatPoint;
    }

    @Override
    public Integer value() {
        return defeatPoint;
    }
}
