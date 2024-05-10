package com.myapp.sevenwonder.domain.model.shared;

import com.myapp.sevenwonder.domain.model.shared.enums.CivilEnum;
import com.myapp.sevenwonder.domain.model.shared.values.card.*;
import com.myapp.sevenwonder.domain.model.shared.values.civil.CivilType;

import java.util.List;

public class Civil extends Card{

    private CivilType civilType;
    private Point point;

    public Civil(CardId id) {
        super(id);
    }

    private Civil(CardId id, CardName cardName, Era era, List<Cost> costs, CivilType civilType) {
        super(id, cardName, era, costs);
        this.civilType = civilType;

    }

    public static Civil from(CardId id, CardName cardName, Era era, List<Cost> costs, CivilType civilType) {
       return new Civil(id,cardName,era,costs,civilType);
    }

    public CivilEnum civilTypeValue() {
        return civilType.value();
    }

    public Integer pointValue() {
        return point.value();
    }

    public CivilType civilType() {
        return civilType;
    }

    public Point point() {
        return point;
    }

    public void providePoint(CivilType civilType) {
        switch (civilTypeValue().toString()) {
            case "ALTAR":
                this.point = new Point(2);
                return;
            case "AQUEDUCT":
                this.point = new Point(5);
                return;
            case "CITY_HALL":
                this.point = new Point(6);

        }

    }
    public Boolean isMostValuable() {
        return civilTypeValue().toString().equals("CITY__HALL");
    }

    public void updatePoints(Point point) {
        this.point = point;
    }

    public Integer obtainPoints() {
        return pointValue();
    }



}
