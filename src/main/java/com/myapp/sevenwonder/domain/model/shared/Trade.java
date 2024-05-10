package com.myapp.sevenwonder.domain.model.shared;

import com.myapp.sevenwonder.domain.model.shared.enums.ResourceEnum;
import com.myapp.sevenwonder.domain.model.shared.enums.TradeEnum;
import com.myapp.sevenwonder.domain.model.shared.values.Resource;
import com.myapp.sevenwonder.domain.model.shared.values.card.CardId;
import com.myapp.sevenwonder.domain.model.shared.values.card.CardName;
import com.myapp.sevenwonder.domain.model.shared.values.card.Cost;
import com.myapp.sevenwonder.domain.model.shared.values.card.Era;
import com.myapp.sevenwonder.domain.model.shared.values.trade.Coin;
import com.myapp.sevenwonder.domain.model.shared.values.trade.TradeType;

import java.util.List;
import java.util.Random;

public class Trade extends Card{

    private Coin coin;
    private TradeType tradeType;
    private Resource resourceSelected;
    private List<Resource> resources;

    public Trade(CardId id) {
        super(id);
    }

    private Trade(CardId id, CardName cardName, Era era, List<Cost> costs, Coin coin, TradeType tradeType, Resource resourceSelected, List<Resource> resources) {
        super(id, cardName, era, costs);
        this.coin = coin;
        this.tradeType = tradeType;
        this.resourceSelected = resourceSelected;
        this.resources = resources;
    }

    public static Trade from(CardId id, CardName cardName, Era era, List<Cost> costs, Coin coin, TradeType tradeType, Resource resourceSelected, List<Resource> resources) {
        return new Trade(id,cardName,era, costs, coin,tradeType,resourceSelected,resources);
    }

    public Coin coin() {
        return coin;
    }

    public TradeType tradeType() {
        return tradeType;
    }

    public Resource resource() {
        return resourceSelected;
    }

    public Integer coinValue() {
        return coin.value();
    }
    public TradeEnum tradeTypeValue() {
        return tradeType.value();
    }
    public ResourceEnum resourceValue() {
        return resourceSelected.value();
    }
    public List<Resource> resources() {
        return resources;
    }

    public void provideCoin(Coin coin) {
        if(tradeTypeValue().toString().equals("COIN")) {
            this.coin = coin;
        }
    }

    public Boolean isNegotiable() {
        return tradeTypeValue().toString().equals("TRADING_RULE");
    }

    public void selectResource() {
        Random random = new Random();
        final int LENGTH = resources.size();
        int indexValue = random.nextInt(LENGTH);

        if(indexValue >= LENGTH) {
            throw new IllegalArgumentException("index value is not included as valid index inside resource list");
        }

        this.resourceSelected = resources.get(indexValue);

    }
}
