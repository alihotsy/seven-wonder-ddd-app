package com.myapp.sevenwonder.domain.model.shared.values.deckAr;

import com.myapp.sevenwonder.domain.model.generic.Identity;
import com.myapp.sevenwonder.domain.model.shared.values.card.CardId;

public class DeckId extends Identity {
    public DeckId() {
        super();
    }

    private DeckId(String uuid) {
        super(uuid);
    }

    public static DeckId of(String uuid) {
        return new DeckId(uuid);
    }
}
