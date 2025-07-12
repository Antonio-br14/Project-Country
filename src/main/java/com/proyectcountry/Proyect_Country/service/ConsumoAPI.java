package com.proyectcountry.Proyect_Country.service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String obtenerDatos(String url){
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse <String> response = null;
        try {
            response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("Se produjo un error: "+e.getMessage());
            return null;
            }
            
        String json = response.body();
        //return json;
        return json;
    } 

}
