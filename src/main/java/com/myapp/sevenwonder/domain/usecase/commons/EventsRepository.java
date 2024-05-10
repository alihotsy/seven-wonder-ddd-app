package com.myapp.sevenwonder.domain.usecase.commons;

import com.myapp.sevenwonder.domain.model.generic.DomainEvent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository {

    DomainEvent saveEvent(DomainEvent event);
    List<DomainEvent> findAggregateRootId(String aggregateRootId);
}
