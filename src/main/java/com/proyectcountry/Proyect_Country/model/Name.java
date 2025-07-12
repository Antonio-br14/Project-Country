package com.proyectcountry.Proyect_Country.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Name(
    String common
) {
}
