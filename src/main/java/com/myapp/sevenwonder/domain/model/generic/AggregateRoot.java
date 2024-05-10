package com.myapp.sevenwonder.domain.model.generic;

import java.util.List;

public class AggregateRoot<I extends Identity> extends Entity<I> {

    private final ChangeEventSubscriber changeEventSubscriber;

    public AggregateRoot(I id) {
        super(id);
        changeEventSubscriber = new ChangeEventSubscriber();
    }

    protected ChangeApply appendChange(DomainEvent domainEvent) {
        var nameClass = identity().getClass().getSimpleName();
        var aggregate = nameClass.replaceAll("Identity|Id|ID","").toLowerCase();
        domainEvent.setAggregateName(aggregate);
        domainEvent.setAggregateRootId(identity().value());
        return changeEventSubscriber.changeApply(domainEvent);
    }

    public List<DomainEvent> getUncommittedChanges() { //Cambios que no han sido implementados en el agregado
        return List.copyOf(changeEventSubscriber.changes());
    }

    public final void subscribe(EventChange eventChange) { //Generar los suscriptores
        changeEventSubscriber.subscribe(eventChange);

    }

    //Una vez aplicado todos esos eventos y que se terminó toda la lógica con esos eventos
    //Simplemente limpiamos los cambios que ya debieron aplicarse
    public void markChangeAsCommitted() {
        changeEventSubscriber.changes().clear();
    }

    //Una vez ejecutado ese evento con este método,
    // ya después se pueden limpiar con el método markChangeAsCommitted
    protected void applyEvent(DomainEvent event) {
        changeEventSubscriber.applyEvent(event);
    }

}
