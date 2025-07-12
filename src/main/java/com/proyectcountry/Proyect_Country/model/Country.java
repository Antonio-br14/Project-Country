package com.proyectcountry.Proyect_Country.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Country(
    Name name,
    boolean independent,
    List<String> capital,
    List<String> continents,
    Map<String, String> languages
) {}