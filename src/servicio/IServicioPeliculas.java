package servicio;

// Una interface no contiene la definicion de sus metodos

import dominio.Pelicula;

public interface IServicioPeliculas {

    public void listarPeliculas();

    public void agregarPelicula(Pelicula pelicula);

    public void buscarPelicula(Pelicula pelicula);
}
