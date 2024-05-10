package com.myapp.sevenwonder.domain.model.deck.commands;

import com.myapp.sevenwonder.domain.model.generic.Command;

public class TakeOutCardCommand extends Command {
    private String deckId;
    private String cardId;

    public TakeOutCardCommand(String deckId, String cardId) {
        this.deckId = deckId;
        this.cardId = cardId;
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
