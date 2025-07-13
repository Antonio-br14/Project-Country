package com.proyectcountry.Proyect_Country.principal;

//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

///import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyectcountry.Proyect_Country.model.Country;
import com.proyectcountry.Proyect_Country.service.ConsumoAPI;
import com.proyectcountry.Proyect_Country.service.ConvertirDatos;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String url = "https://restcountries.com/v3.1/name/";
    private ConvertirDatos conversor = new ConvertirDatos();
    //private List<Country> paises = new ArrayList<>();

    
    public void mostrarMenu(){
        var opcion = -1;
        while (opcion !=0 ) { 

            System.out.println("Bienvenido a Proyect Country\n******Menú*******\nOpciones:\n1. buscar un pais\n2. Buscar paises por continente\n3. Buscar paises que hablen el mismo idioma\n0. salir");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    obtenerPais();
                    break;
                case 2:
                    buscarPoRegion();
                    break;
                case 3:
                    buscarPorIdioma();
                case 0:
                System.out.println("Saliendo del programa");
                default:
                    break;
            }
        }
    }

    public List<Country> obtenerPais(){
        System.out.println("Escribe el nombre del pais que deseas buscar: ");
        var nombrePais = teclado.nextLine().toUpperCase();
        var json = consumoAPI.obtenerDatos(url+nombrePais);
        //System.out.println(json);
        List<Country> countries = conversor.ConvertirJsonLista(json);

        if (!countries.isEmpty()) {
            System.out.println("Pais encontrado");

            countries.forEach(c ->{
                System.out.println("Nombre común: " + c.name().common());
                System.out.println("Capital: " + c.capital());
                System.out.println("Continentes: " + c.continents());
                System.out.println("Independiente: " + c.independent());
                String idioma = String.join(", ", c.languages().values());
                System.out.println("Idioma: "+idioma);
            });
        } else{
            System.out.println("No se encontro ese pais que busca");
        }
        return countries;
    }

    public void buscarPoRegion(){
        var urlRegion = "https://restcountries.com/v3.1/region/";
        System.out.println("Escribe el nombre del continente del cual quieres buscar los paises: ");
        var region = teclado.nextLine().toUpperCase();
        var json = consumoAPI.obtenerDatos(urlRegion+region);
        List<Country> paises = conversor.ConvertirJsonLista(json);

        if (!paises.isEmpty()) {
            System.out.println("Paises encontrados: "+ region+":");
            paises.forEach(c ->{
                System.out.println("- "+ c.name().common());
            });
        } else{
            System.out.println("No se encontro ese continente");
        }

    }

    public void buscarPorIdioma(){
        var urlIdiomas = "https://restcountries.com/v3.1/lang/";
        System.out.println("Escribe el idioma del cual quieres buscar los paises(en ingles): ");
        var idioma = teclado.nextLine().toUpperCase();
        var json = consumoAPI.obtenerDatos(urlIdiomas+idioma);
        List<Country> paises = conversor.ConvertirJsonLista(json);

        if (!paises.isEmpty()) {
            System.out.println("Los paises encontrados que hablan "+idioma+"son los siguientes: ");
            paises.forEach(p -> {
                System.out.println("- "+p.name().common());
            });
        } else{
            System.out.println("No se encontaron paises con ese idioma");
        }
    }
}