package com.myapp.sevenwonder.domain.model.shared.values.card;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;

public class Cost implements ValueObject<Cost> {

    private final Quantity quantity;
    private final CostType costType;

    public Cost(Quantity quantity, CostType costType) {
        this.quantity = quantity;
        this.costType = costType;
    }

    @Override
    public Cost value() {
        return this;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public CostType getCostType() {
        return costType;
    }
}
