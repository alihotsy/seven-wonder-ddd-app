package com.myapp.sevenwonder.domain.model.shared.values.card;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;
import com.myapp.sevenwonder.domain.model.shared.enums.EraType;

import java.util.Objects;

public class Era implements ValueObject<EraType> {

    private final EraType era;

    public Era(EraType era) {
        if(Objects.isNull(era)) {
            throw new IllegalArgumentException("Era type must not be null");
        }
        this.era = era;
    }

    @Override
    public EraType value() {
        return era;
    }
}
