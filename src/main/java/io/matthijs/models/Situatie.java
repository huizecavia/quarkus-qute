package io.matthijs.models;

import java.util.List;

public record Situatie(
        String situatieBeschrijving,
        List<String> antwoordList
) {
}
