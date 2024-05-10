package com.myapp.sevenwonder.domain.model.deck.commands;

import com.myapp.sevenwonder.domain.model.generic.Command;
import com.myapp.sevenwonder.domain.model.shared.Card;

import java.util.List;

public class CheckOutCardsCommand extends Command {
    private String deckId;
    private List<Card> cards;

    public CheckOutCardsCommand(String deckId, List<Card> cards) {
        this.deckId = deckId;
        this.cards = cards;
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
