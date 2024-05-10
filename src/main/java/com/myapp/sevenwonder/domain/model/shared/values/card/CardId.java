package com.myapp.sevenwonder.domain.model.shared.values.card;

import com.myapp.sevenwonder.domain.model.generic.Identity;

public class CardId extends Identity {
    public CardId() {
        super();
    }

    private CardId(String uuid) {
        super(uuid);
    }

    public static CardId of(String uuid) {
        return new CardId(uuid);
    }

}
