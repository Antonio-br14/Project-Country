package com.proyectcountry.Proyect_Country.service;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectcountry.Proyect_Country.model.Country;

public class ConvertirDatos {

    public List<Country> ConvertirJsonLista(String json){

        try {
            ObjectMapper mapper = new ObjectMapper();
            Country[] paises = mapper.readValue(json, Country[].class);
            return Arrays.asList(paises);
        } catch (Exception e) {
            System.out.println("Error a encontrar el paies que quieres buscar" + e.getMessage());
            return List.of(); // una lista vacia por si falla
        }
    }
}
