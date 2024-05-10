package com.myapp.sevenwonder.domain.usecase.deck;

import com.myapp.sevenwonder.domain.model.deck.Deck;
import com.myapp.sevenwonder.domain.model.deck.commands.CheckOutCardsCommand;
import com.myapp.sevenwonder.domain.model.generic.DomainEvent;
import com.myapp.sevenwonder.domain.model.shared.values.deckAr.DeckId;
import com.myapp.sevenwonder.domain.usecase.commons.CommandUseCase;
import com.myapp.sevenwonder.domain.usecase.commons.EventsRepository;

import java.util.List;

public class CheckOutCardsUseCase implements CommandUseCase<CheckOutCardsCommand> {

    private final EventsRepository eventsRepository;

    public CheckOutCardsUseCase(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public List<DomainEvent> apply(CheckOutCardsCommand command) {
        List<DomainEvent> result = eventsRepository.findAggregateRootId(command.getDeckId());
        Deck deck = Deck.from(DeckId.of(command.getDeckId()),result);
        deck.checkoutCards(command.getCards());
        return deck.getUncommittedChanges().stream()
                .map(eventsRepository::saveEvent)
                .toList();
    }
}
