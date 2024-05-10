package com.myapp.sevenwonder.domain.model.deck.events;

import com.myapp.sevenwonder.domain.model.generic.DomainEvent;
import com.myapp.sevenwonder.domain.model.shared.Card;

import java.util.List;

public class CheckedOutCards extends DomainEvent {
    private List<Card> cards;

    private CheckedOutCards() {
        super("com.myapp.sevenwonder.domain.model.deck.events.CheckedOutCards");
    }

    public CheckedOutCards(List<Card> cards) {
        super("com.myapp.sevenwonder.domain.model.deck.events.CheckedOutCards");
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
