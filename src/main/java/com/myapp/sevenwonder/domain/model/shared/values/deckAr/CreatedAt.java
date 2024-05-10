package com.myapp.sevenwonder.domain.model.shared.values.deckAr;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;

import java.time.LocalDate;

public class CreatedAt implements ValueObject<LocalDate> {
    private final LocalDate createdAt;

    public CreatedAt(LocalDate createdAt) {
        if(createdAt.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("created date must not be before than current one");
        }
        this.createdAt = createdAt;
    }


    @Override
    public LocalDate value() {
        return createdAt;
    }
}
