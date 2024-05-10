package com.myapp.sevenwonder.domain.model.shared.values.card;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;

import java.util.List;
import java.util.Objects;

public class Point implements ValueObject<Integer> {
    private final Integer point;
    private static final List<Integer> VALUES = List.of(2,5,6);

    public Point(Integer point) {
        if(Objects.isNull(point)) {
            throw new IllegalArgumentException("Point must not be null");
        }
        if(point < 0) {
            throw new IllegalArgumentException("Point must not be negative");
        }

        if(!VALUES.contains(point)) {
            throw new IllegalArgumentException("Value not valid");
        }
        this.point = point;
    }


    @Override
    public Integer value() {
        return point;
    }
}
