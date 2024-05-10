package com.myapp.sevenwonder.domain.usecase.deck;

import com.myapp.sevenwonder.domain.model.deck.Deck;
import com.myapp.sevenwonder.domain.model.deck.commands.CreateDeckCommand;
import com.myapp.sevenwonder.domain.model.generic.DomainEvent;
import com.myapp.sevenwonder.domain.model.shared.values.deckAr.CreatedAt;
import com.myapp.sevenwonder.domain.model.shared.values.deckAr.DeckId;
import com.myapp.sevenwonder.domain.usecase.commons.CommandUseCase;
import com.myapp.sevenwonder.domain.usecase.commons.EventsRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CreateDeckUseCase implements CommandUseCase<CreateDeckCommand> {

    private final EventsRepository eventsRepository;

    public CreateDeckUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateDeckCommand command) {
        Deck deck = new Deck(
                DeckId.of(command.getDeckId()),
                command.getCards(),
                command.getCreatedAt()
        );
        return deck.getUncommittedChanges()
                .stream()
                .map(eventsRepository::saveEvent)
                .toList();
    }
}
