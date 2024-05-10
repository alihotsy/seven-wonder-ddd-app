package com.myapp.sevenwonder.domain.model.deck.events;

import com.myapp.sevenwonder.domain.model.generic.DomainEvent;
import com.myapp.sevenwonder.domain.model.shared.Card;

import java.time.LocalDate;
import java.util.List;

public class CreatedDeck extends DomainEvent {

    private List<Card> cards;
    private LocalDate createdAt;

    private CreatedDeck() {
        super("com.myapp.sevenwonder.domain.model.deck.events.DeckCreated");
    }

    public CreatedDeck(List<Card> cards, LocalDate createdAt) {
        super("com.myapp.sevenwonder.domain.model.deck.events.DeckCreated");
        this.cards = cards;
        this.createdAt = createdAt;
    }

    public List<Card> getCards() {
        return cards;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
