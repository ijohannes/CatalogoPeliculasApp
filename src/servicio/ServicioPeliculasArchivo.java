package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas {

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    // Constructor vacio
    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //Si ya existe el archivo no se vuelve a crear
            if(archivo.exists()){
                System.out.println("El archivo ya existe!");
            }else{
                // Si no existe se crea vacio
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo!");
            }
        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir el archivo " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        // Volvemos a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            System.out.println("Listado de Peliculas");
            // Abrimos el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // Leemos linea a linea el archivo
            String linea;
            linea = entrada.readLine();
            // Leemos todas las lineas disponibles
            while(linea != null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                // Antes de terminar el ciclo volvemos a leer la siguiente linea
                linea = entrada.readLine();
            }
            // Cerramos el archivo
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error al leer el archivo" + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            // Revisamos si existe el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            // Agregamos la pelicula (toString)
            salida.println(pelicula);;
            salida.close();
            System.out.println("Se agrego al archivo: " + pelicula);
        }catch (Exception e){
            System.out.println("Ocurrio un error al agregar pelicula " + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            // Abrimos el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();
            while(lineaTexto != null){
                // Buscamos sin importar mayusculas/minusculas
                if(peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                // Leemos la siguiente linea antes de la siguiente iteracion
                lineaTexto = entrada.readLine();
                indice++;
            } // fin del while
            //Imprimimos los resultados de la busqueda
            if(encontrada){
                System.out.println("Pelicula " + lineaTexto + " econtrada - linea " + indice);
            }else{
                System.out.println("NO se encontro la pelicula " + pelicula.getNombre());
            }
            entrada.close();
        }catch (Exception e){
            System.out.println("Ocurrio un error al buscar pelicula en el archivo" + e.getMessage());
        }
    }
}
