import jakarta.xml.bind.annotation.XmlType;
@XmlType(propOrder = {"autor", "titulo", "editorial", "isbn", "precio"})

public class Libro {

    private String autor;
    private String titulo;
    private String editorial;
    private String isbn;
    private double precio;


    public Libro(String autor, String titulo, String editorial, String isbn, double precio) {
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.isbn = isbn;
        this.precio = precio;

    }

    public Libro() {

    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "\tTítulo: " + titulo + "\n" +
                "\tAutor: " + autor + "\n" +
                "\tPrecio: " + precio + "\n" +
                "-------------------------------------\n"
                ;
    }

    public String toStringTitulo() {
        return "\tTítulo: " + titulo + "\n" +
                "-------------------------------------\n"
                ;
    }

    public String toStringAutores(String autorBuscar) {
        if (autor.matches(autorBuscar)) {
            return "\tTítulo: " + titulo + "\n" +
                    "\tAutor: " + autor + "\n" +
                    "\tPrecio: " + precio + "\n" +
                    "-------------------------------------\n"
                    ;
        }else{
            return "";
        }
    }

}
