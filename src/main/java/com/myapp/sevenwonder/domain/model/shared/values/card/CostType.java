package com.myapp.sevenwonder.domain.model.shared.values.card;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;
import com.myapp.sevenwonder.domain.model.shared.enums.CostEnum;

import java.util.Objects;

public class CostType implements ValueObject<CostEnum> {
    private final CostEnum costType;

    public CostType(CostEnum costType) {
        if(Objects.isNull(costType)) {
            throw new IllegalArgumentException("Cost type must not be null");
        }
        this.costType = costType;
    }

    @Override
    public CostEnum value() {
        return costType;
    }
}
