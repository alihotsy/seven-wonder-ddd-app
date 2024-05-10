package com.myapp.sevenwonder.domain.model.deck;

import com.myapp.sevenwonder.domain.model.deck.events.CheckedOutCards;
import com.myapp.sevenwonder.domain.model.deck.events.CreatedDeck;
import com.myapp.sevenwonder.domain.model.deck.events.MixedCards;
import com.myapp.sevenwonder.domain.model.deck.events.TookOutCard;
import com.myapp.sevenwonder.domain.model.generic.AggregateRoot;
import com.myapp.sevenwonder.domain.model.generic.DomainEvent;
import com.myapp.sevenwonder.domain.model.shared.Card;
import com.myapp.sevenwonder.domain.model.shared.values.deckAr.CreatedAt;
import com.myapp.sevenwonder.domain.model.shared.values.deckAr.DeckId;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck extends AggregateRoot<DeckId> {

    protected List<Card> cards;
    protected CreatedAt createdAt;

    protected Boolean isEmpty;

    private Deck(DeckId id) {
        super(id);
        subscribe(new DeckBehavior(this));
    }

    public Deck(DeckId id, List<Card> cards, LocalDate createdAt) {
        super(id);
        new DeckBehavior(this);
        appendChange(new CreatedDeck(cards,createdAt)).apply();
    }

    public static Deck from(DeckId deckId, List<DomainEvent> events) {
        Deck deck = new Deck(deckId);
        events.forEach(deck::applyEvent);
        return deck;
    }

    public LocalDate createdAtValue() {
        return createdAt.value();
    }

    public CreatedAt createdAt() {
        return createdAt;
    }

    public List<Card> cards() {
        return cards;
    }

    public void mixCards(List<Card> cards) {
        appendChange(new MixedCards(cards)).apply();
    }

    public void checkoutCards(List<Card> cards) {
        appendChange(new CheckedOutCards(cards)).apply();
    }

    public void takeOutCard(String cardId) {
       appendChange(new TookOutCard(cardId)).apply();
    }



}
