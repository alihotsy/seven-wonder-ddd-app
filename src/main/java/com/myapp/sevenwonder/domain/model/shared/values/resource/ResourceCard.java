package com.myapp.sevenwonder.domain.model.shared.values.resource;

import com.myapp.sevenwonder.domain.model.shared.Card;
import com.myapp.sevenwonder.domain.model.shared.enums.ResourceEnum;
import com.myapp.sevenwonder.domain.model.shared.values.Resource;
import com.myapp.sevenwonder.domain.model.shared.values.card.CardId;
import com.myapp.sevenwonder.domain.model.shared.values.card.CardName;
import com.myapp.sevenwonder.domain.model.shared.values.card.Cost;
import com.myapp.sevenwonder.domain.model.shared.values.card.Era;

import java.util.List;
import java.util.Random;

public class ResourceCard extends Card {

    private Resource resourceSelected;
    private List<Resource> resources;
    public ResourceCard(CardId id) {
        super(id);
    }

    private ResourceCard(CardId id, CardName cardName, Era era, List<Cost> costs, Resource resourceSelected, List<Resource> resources) {
        super(id, cardName, era, costs);
        this.resourceSelected = resourceSelected;
        this.resources = resources;
    }

    public static ResourceCard from(CardId id, CardName cardName, Era era, List<Cost> costs, Resource resourceSelected, List<Resource> resources) {
        return new ResourceCard(id,cardName,era,costs,resourceSelected,resources);
    }

    public ResourceEnum resourceValue() {
        return resourceSelected.value();
    }

    public Resource resource() {
        return resourceSelected;
    }

    public List<Resource> resources() {
        return resources;
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

    public void addResource(Resource resource) {
        if(resources.contains(resource)) {
            throw new IllegalArgumentException("This resources already exists");
        }
        this.resources.add(resource);
    }
}
