package com.myapp.sevenwonder.domain.usecase.commons;


import com.myapp.sevenwonder.domain.model.generic.Command;
import com.myapp.sevenwonder.domain.model.generic.DomainEvent;

import java.util.List;

public interface CommandUseCase<C extends Command>{
    List<DomainEvent> apply(C command);
}
