package com.myapp.sevenwonder.domain.model.shared.values.card;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;

import java.util.Objects;

public class CardName implements ValueObject<String> {
    private final String cardName;

    public CardName(String cardName) {
        if(Objects.isNull(cardName)) {
            throw new IllegalArgumentException("Card name must not be null");
        }

        if(cardName.trim().isEmpty()) {
            throw new IllegalArgumentException("Card name is required");
        }
        this.cardName = cardName;
    }

    @Override
    public String value() {
        return cardName;
    }
}
