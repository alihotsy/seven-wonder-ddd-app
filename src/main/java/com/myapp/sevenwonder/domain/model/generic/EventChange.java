package com.myapp.sevenwonder.domain.model.generic;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class EventChange {

    protected Set<Consumer<? super DomainEvent>> behaviors = new HashSet<>();

    protected void apply(Consumer<? extends DomainEvent> changeEvent) {
        behaviors.add((Consumer<? super DomainEvent>) changeEvent);
    }
}
