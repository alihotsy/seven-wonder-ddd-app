package com.myapp.sevenwonder.domain.model.shared;

import com.myapp.sevenwonder.domain.model.generic.Entity;
import com.myapp.sevenwonder.domain.model.shared.enums.EraType;
import com.myapp.sevenwonder.domain.model.shared.values.card.CardId;
import com.myapp.sevenwonder.domain.model.shared.values.card.CardName;
import com.myapp.sevenwonder.domain.model.shared.values.card.Cost;
import com.myapp.sevenwonder.domain.model.shared.values.card.Era;

import java.util.ArrayList;
import java.util.List;

public abstract class Card extends Entity<CardId> {

    protected CardName cardName;
    protected Era era;
    protected List<Cost> costs;
    public Card(CardId id) {
        super(id);
    }

    public Card(CardId id, CardName cardName, Era era, List<Cost> costs) {
        super(id);
        this.cardName = cardName;
        this.era = era;
        this.costs = costs;
    }

    public Boolean isFree() {
        return costs.isEmpty();
    }



    public Boolean isLast(Boolean markAsLastCard) {
        return markAsLastCard;
    }

    public String cardNameValue() {
        return cardName.value();
    }

    public EraType eraTypeValue() {
        return era.value();
    }

    public List<Cost> costs() {
        return costs;
    }

    public CardName cardName() {
        return cardName;
    }

    public Era eraType() {
        return era;
    }



}
