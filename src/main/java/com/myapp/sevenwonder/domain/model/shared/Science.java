package com.myapp.sevenwonder.domain.model.shared;

import com.myapp.sevenwonder.domain.model.shared.enums.ScienceEnum;
import com.myapp.sevenwonder.domain.model.shared.values.card.*;
import com.myapp.sevenwonder.domain.model.shared.values.science.ScienceType;

import java.util.List;

public class Science extends Card {

    private ScienceType scienceType;

    public Science(CardId id) {
        super(id);
    }

    private Science(CardId id, CardName cardName, Era era, List<Cost> costs, ScienceType scienceType) {
        super(id, cardName, era, costs);
        this.scienceType = scienceType;
    }

    public static Science from(CardId id, CardName cardName, Era era, List<Cost> costs, ScienceType scienceType) {
        return new Science(id,cardName,era,costs,scienceType);
    }
    public ScienceType scienceType() {
        return scienceType;
    }


    public ScienceEnum scienceTypeValue() {
        return scienceType.value();
    }

    public Boolean isMostValuable() {
        return costs().size() == 3;
    }

    public Boolean canBeUsed() {
        return costs().isEmpty();
    }

    public Boolean hasCostInCoins() {
        if(costs().isEmpty()) {
            return false;
        }

        return costs()
                .stream()
                .map(cost -> cost.getCostType().value().toString())
                .anyMatch(cost -> cost.equals("COIN"));
    }



}
