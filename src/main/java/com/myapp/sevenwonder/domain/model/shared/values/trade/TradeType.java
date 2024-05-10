package com.myapp.sevenwonder.domain.model.shared.values.trade;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;
import com.myapp.sevenwonder.domain.model.shared.enums.TradeEnum;

import java.util.Objects;

public class TradeType implements ValueObject<TradeEnum> {

    private final TradeEnum tradeType;

    public TradeType(TradeEnum tradeType) {
        if(Objects.isNull(tradeType)) {
            throw new IllegalArgumentException("Trade type must not be null");
        }
        this.tradeType = tradeType;
    }

    @Override
    public TradeEnum value() {
        return tradeType;
    }
}
