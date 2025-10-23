import jakarta.xml.bind.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JAXBException {
        //Comentado por si el archivo inicial no se encuentra, descomentar y genera el archivo con estos libros
     /*   Libreria lib = new Libreria("Las Hojas", "Getafe");
        lib.getLibros().add(new Libro("Cervantes", "El quijote", "El barco de vapor", "1234", 20.30));
        lib.getLibros().add(new Libro("Fernando de Rojas", "La celestina", "Santillana", "5678", 25.37));
        lib.getLibros().add(new Libro("Gabriel García Márquez", "Cien años de soledad", "Editorial Sudamericana", "9012", 18.50));
        lib.getLibros().add(new Libro("Isabel Allende", "La casa de los espíritus", "Plaza & Janés", "3456", 21.75));
        lib.getLibros().add(new Libro("J.R.R. Tolkien", "El hobbit", "Minotauro", "7890", 19.99));
        try {
            /*
            JAXBContext contexto = JAXBContext.newInstance(Libreria.class);
            //Marshalling --> objetos JAVA a XML
            Marshaller m = contexto.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            System.out.println("Generando XML....");
            m.marshal(lib, new File("libreria.xml"));
            m.marshal(lib, System.out);
            // unmarshalling objetos XML a JAVA
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }*/


        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor dime el nombre del XML");
        String ruta = sc.nextLine();
        File fichero = new File(ruta);
        if (!fichero.exists()){
            System.out.println("El nombre del archivo XML no existe, finalizando programa...");
            System.exit(0);
        }

        while (true) {
            System.out.println("Por favor, introduce el número de la opción a realizar");

            System.out.println("1. Crea un método que lea el XML y muestre solo los títulos de los libros.");
            System.out.println("2. Crea un programa que pida un autor por teclado y muestre sus libros.");
            System.out.println("3. Añade un nuevo libro al XML y vuelve a guardarlo.");
            System.out.println("4. Finalizar el programa.");


            System.out.print("OPCION: ");
            int opcion = sc.nextInt();
            JAXBContext contexto = JAXBContext.newInstance(Libreria.class);
            Marshaller m = contexto.createMarshaller();
            switch (opcion) {
                case 1:
                    System.out.println(leerTitulos(m, contexto));
                    break;
                case 2:
                    System.out.println("Por favor, dime un autor");
                    sc.nextLine();
                    String autorABuscar = sc.nextLine();
                    System.out.println(buscarPorAutor(m, contexto, autorABuscar));
                    break;
                case 3:
                    generarLibro(m, contexto);
                    break;
                case 4:
                    System.out.println("Finalizando programa...");
                    System.exit(0);
            }
        }

    }

    public static String leerTitulos(Marshaller m, JAXBContext contexto) throws JAXBException {
        Unmarshaller um = contexto.createUnmarshaller();
        Libreria libreriaGetafe = (Libreria) um.unmarshal(new File("libreria.xml"));
        return libreriaGetafe.toTitulo();

    }

    public static String buscarPorAutor(Marshaller m, JAXBContext contexto, String autor) throws JAXBException {
        Unmarshaller um = contexto.createUnmarshaller();
        Libreria libreriaGetafe = (Libreria) um.unmarshal(new File("libreria.xml"));
        return libreriaGetafe.librosAutor(autor);

    }

    public static void generarLibro(Marshaller m, JAXBContext contexto) {
//autor, titulo, editorial, isbn, precio
        System.out.println("Por favor, introduce los datos del libro");
        Scanner sc = new Scanner(System.in);

        System.out.println("Autor: ");
        String autor = sc.nextLine();

        System.out.println("Título");
        String titulo = sc.nextLine();

        System.out.println("Editorial");
        String editorial = sc.nextLine();

        System.out.println("ISBN");
        String isbn = sc.nextLine();

        System.out.println("Precio");
        double precio = sc.nextDouble();

        Libro libroAnadir = new Libro(autor, titulo, editorial, isbn, precio);

        try {
            Unmarshaller um = contexto.createUnmarshaller();
            Libreria libreriaGetafe = (Libreria) um.unmarshal(new File("libreria.xml"));
            libreriaGetafe.getLibros().add(libroAnadir);

            Marshaller marshallerAnadir = contexto.createMarshaller();
            marshallerAnadir.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            System.out.println("Generando XML con el nuevo libro....");
            marshallerAnadir.marshal(libreriaGetafe, new File("libreria.xml"));

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
    public static void generarXML(String nombreXML) throws IOException {
        File fichero = new File(nombreXML);
        boolean creado = fichero.createNewFile();
        if (creado){
            System.out.println("Fichero generado correctamente");
        }
    }
//cambio realiado
}
