package com.myapp.sevenwonder.domain.model.shared;

import com.myapp.sevenwonder.domain.model.shared.values.army.DefeatPoint;
import com.myapp.sevenwonder.domain.model.shared.values.army.VictoryPoint;
import com.myapp.sevenwonder.domain.model.shared.values.card.CardId;
import com.myapp.sevenwonder.domain.model.shared.values.card.CardName;
import com.myapp.sevenwonder.domain.model.shared.values.card.Cost;
import com.myapp.sevenwonder.domain.model.shared.values.card.Era;

import java.util.List;

public class Army extends Card{

    private DefeatPoint defeatPoint;
    private VictoryPoint victoryPoint;
    public Army(CardId id) {
        super(id);
    }

    private Army(CardId id, CardName cardName, Era era, List<Cost> costs, DefeatPoint defeatPoint, VictoryPoint victoryPoint) {
        super(id, cardName, era, costs);
        this.defeatPoint = defeatPoint;
        this.victoryPoint = victoryPoint;
    }

    public Army from(CardId id, CardName cardName, Era era, List<Cost> costs, DefeatPoint defeatPoint, VictoryPoint victoryPoint) {
        return new Army(id,cardName,era,costs,defeatPoint,victoryPoint);
    }

    public Integer defeatPointValue() {
        return defeatPoint.value();
    }

    public Integer victoryPointValue() {
        return victoryPoint.value();
    }

    public DefeatPoint defeatPoint() {
        return defeatPoint;
    }

    public VictoryPoint victoryPoint() {
        return victoryPoint;
    }

    public void gatherVictoryPoints() {
        this.victoryPoint = new VictoryPoint(this.victoryPoint.value()+1);
    }

    public void gatherDefeatPoints() {
        this.defeatPoint = new DefeatPoint(this.defeatPoint.value()-1);
    }
    public Integer finalPoints() {
        return victoryPointValue() + defeatPointValue();
    }
}
