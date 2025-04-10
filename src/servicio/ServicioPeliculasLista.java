package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas {
    private final List<Pelicula> peliculas;

    // Constructor vacio
    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }


    @Override
    public void listarPeliculas() {
        System.out.println("Listado de peliculas...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        // Regresa el indice de la pelicula encontrada en la lista
        var indice = peliculas.indexOf(pelicula);
        System.out.println("Pelicula encontrada en el indice " + indice);
    }
}
