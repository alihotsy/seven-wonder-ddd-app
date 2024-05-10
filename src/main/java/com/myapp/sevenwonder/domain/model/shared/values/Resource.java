package com.myapp.sevenwonder.domain.model.shared.values;

import com.myapp.sevenwonder.domain.model.generic.ValueObject;
import com.myapp.sevenwonder.domain.model.shared.enums.ResourceEnum;

import java.util.Objects;

public class Resource implements ValueObject<ResourceEnum> {
    private final ResourceEnum resource;

    public Resource(ResourceEnum resource) {
        if(Objects.isNull(resource)) {
            throw new IllegalArgumentException("Resource type must not be null");
        }
        this.resource = resource;
    }


    @Override
    public ResourceEnum value() {
        return resource;
    }
}
