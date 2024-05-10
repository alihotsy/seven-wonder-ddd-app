package com.myapp.sevenwonder.domain.model.deck;

import com.myapp.sevenwonder.domain.model.deck.events.CheckedOutCards;
import com.myapp.sevenwonder.domain.model.deck.events.CreatedDeck;
import com.myapp.sevenwonder.domain.model.deck.events.MixedCards;
import com.myapp.sevenwonder.domain.model.deck.events.TookOutCard;
import com.myapp.sevenwonder.domain.model.generic.EventChange;
import com.myapp.sevenwonder.domain.model.shared.values.card.CardId;
import com.myapp.sevenwonder.domain.model.shared.values.deckAr.CreatedAt;

import java.util.Collection;
import java.util.Collections;

public class DeckBehavior extends EventChange {

    public DeckBehavior(Deck deck) {

        apply((CreatedDeck event) -> {
           deck.createdAt = new CreatedAt(event.getCreatedAt());
           deck.cards = event.getCards();
        });

        apply((MixedCards event) -> {
            if(event.getCards().isEmpty()) {
                throw new IllegalArgumentException("There must be at least 1 card");
            }
            Collections.shuffle(event.getCards());
            deck.cards = event.getCards();
        });

        apply((CheckedOutCards event) -> {
            deck.isEmpty = event.getCards().isEmpty();
        });

        apply((TookOutCard event) -> {
            CardId cardId = CardId.of(event.getCardId());
            deck.cards.removeIf(card -> card.identity().value().equals(cardId.value()));
        });

    }

}
