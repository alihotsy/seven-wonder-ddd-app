package com.myapp.sevenwonder.domain.model.deck.commands;

import com.myapp.sevenwonder.domain.model.generic.Command;
import com.myapp.sevenwonder.domain.model.shared.Card;
import com.myapp.sevenwonder.domain.model.shared.values.deckAr.DeckId;

import java.time.LocalDate;
import java.util.List;

public class CreateDeckCommand extends Command {

    private String deckId;
    private List<Card> cards;
    private LocalDate createdAt;

    public CreateDeckCommand(String deckId, List<Card> cards, LocalDate createdAt) {
        this.cards = cards;
        this.createdAt = createdAt;
        this.deckId = deckId;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }
}
