package com.myapp.sevenwonder.domain.model.generic;

import java.time.Instant;
import java.util.UUID;

public abstract class Command {

    private final Instant when;
    private final String uuid;

    public Command() {
        this.uuid = UUID.randomUUID().toString();
        this.when = Instant.now();
    }

    public Instant when() {
        return when;
    }

    public String uuid() {
        return uuid;
    }
}
