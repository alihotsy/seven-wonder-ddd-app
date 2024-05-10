package com.myapp.sevenwonder.domain.model.shared.values.science;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;
import com.myapp.sevenwonder.domain.model.shared.enums.ScienceEnum;

import java.util.Objects;

public class ScienceType implements ValueObject<ScienceEnum> {
    private final ScienceEnum scienceType;

    public ScienceType(ScienceEnum scienceType) {
        if(Objects.isNull(scienceType)) {
            throw new IllegalArgumentException("Science type must not be null");
        }
        this.scienceType = scienceType;
    }

    @Override
    public ScienceEnum value() {
        return scienceType;
    }
}
