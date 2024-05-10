package com.myapp.sevenwonder.domain.model.deck.events;

import com.myapp.sevenwonder.domain.model.generic.DomainEvent;

public class TookOutCard extends DomainEvent {

    private String cardId;

    private TookOutCard() {
        super("com.myapp.sevenwonder.domain.model.deck.events.TookOutCard");
    }

    public TookOutCard(String cardId) {
        super("com.myapp.sevenwonder.domain.model.deck.events.TookOutCard");
        this.cardId = cardId;
    }

    public String getCardId() {
        return cardId;
    }
}
