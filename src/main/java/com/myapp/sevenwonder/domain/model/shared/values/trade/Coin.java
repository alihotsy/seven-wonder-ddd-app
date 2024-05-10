package com.myapp.sevenwonder.domain.model.shared.values.trade;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;

import java.util.List;
import java.util.Objects;

public class Coin implements ValueObject<Integer> {
    private final Integer coin;
    private static final List<Integer> VALUES = List.of(1,2,3,4,5);
    public Coin(Integer coin) {
        if(Objects.isNull(coin)) {
            throw new IllegalArgumentException("Coin must not be null");
        }
        if(!VALUES.contains(coin)) {
            throw new IllegalArgumentException("Coin invalid value");
        }
        this.coin = coin;
    }


    @Override
    public Integer value() {
        return coin;
    }
}
