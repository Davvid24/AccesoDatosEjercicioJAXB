import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "libreria")

public class Libreria {
    private String nombre;
    private String lugar;
    private List<Libro> libros = new ArrayList<>();


    public Libreria(){

    }

    public Libreria(String nombre, String lugar) {
        this.nombre = nombre;
        this.lugar = lugar;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @XmlElementWrapper(name = "Libros")
    @XmlElement(name = "Libro")

    public List<Libro> getLibros() {
        return libros;
    }

    @Override
    public String toString() {
        String resultado = "Libreria:\n";
        resultado += "Nombre: " + nombre + "\n";
        resultado += "Lugar: " + lugar + "\n";
        resultado += "Libros:\n";

        for (Libro libro : libros) {

            resultado += libro.toString();
        }

        return resultado;
    }

    public String toTitulo() {
        String resultado = "Libreria:\n";
        resultado += "Nombre: " + nombre + "\n";
        resultado += "Lugar: " + lugar + "\n";
        resultado += "Libros:\n";

        for (Libro libro : libros) {
            resultado += libro.toStringTitulo();
        }

        return resultado;
    }

    public String librosAutor(String autor) {
        String resultado = "Libreria:\n";
        resultado += "Nombre: " + nombre + "\n";
        resultado += "Lugar: " + lugar + "\n";
        resultado += "Libros:\n";
        boolean encontrado = false;
        for (Libro libro : libros) {
            String contenido = libro.toStringAutores(autor);
            if (!contenido.isEmpty()) {
                resultado += contenido;
                encontrado = true;
            }
        }
        if (!encontrado){
            resultado = "No hay libros en esta librería de este autor";
        }

        return resultado;
    }
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}

