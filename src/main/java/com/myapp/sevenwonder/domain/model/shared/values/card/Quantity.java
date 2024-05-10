package com.myapp.sevenwonder.domain.model.shared.values.card;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;

import java.util.Objects;

public class Quantity implements ValueObject<Integer> {
    private final Integer quantity;

    public Quantity(Integer quantity) {
        if(Objects.isNull(quantity)) {
            throw new IllegalArgumentException("Quantity must not be null");
        }

        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity must not be negative");
        }
        this.quantity = quantity;
    }

    @Override
    public Integer value() {
        return quantity;
    }
}
