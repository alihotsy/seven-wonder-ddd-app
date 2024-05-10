package com.myapp.sevenwonder.domain.usecase.commons;



import com.myapp.sevenwonder.domain.model.generic.DomainEvent;

import java.util.List;

public interface EventUseCase<E extends DomainEvent>{
    List<DomainEvent> apply(E event);
}
