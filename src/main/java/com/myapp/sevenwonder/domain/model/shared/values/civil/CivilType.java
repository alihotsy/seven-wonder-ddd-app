package com.myapp.sevenwonder.domain.model.shared.values.civil;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;
import com.myapp.sevenwonder.domain.model.shared.enums.CivilEnum;

import java.util.Objects;

public class CivilType implements ValueObject<CivilEnum> {
    private final CivilEnum civilType;

    public CivilType(CivilEnum civilType) {
        if(Objects.isNull(civilType)) {
            throw new IllegalArgumentException("Civil type must not be null");
        }
        this.civilType = civilType;
    }

    @Override
    public CivilEnum value() {
        return civilType;
    }
}
