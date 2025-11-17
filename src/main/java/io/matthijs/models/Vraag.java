package io.matthijs.models;

import java.util.List;

public record Vraag(
        String vraagtekst,
        List<Antwoord> antwoordmogelijkheden
) {
}
