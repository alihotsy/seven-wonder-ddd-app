package com.myapp.sevenwonder.domain.model.deck.events;

import com.myapp.sevenwonder.domain.model.generic.DomainEvent;
import com.myapp.sevenwonder.domain.model.shared.Card;

import java.util.List;

public class MixedCards extends DomainEvent {

    List<Card> cards;
    private MixedCards() {
        super("com.myapp.sevenwonder.domain.model.deck.events.MixedCards");
    }

    public MixedCards(List<Card> cards) {
        super("com.myapp.sevenwonder.domain.model.deck.events.MixedCards");
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}
