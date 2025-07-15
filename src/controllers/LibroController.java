package controllers;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import models.Book;

public class LibroController {

    public Map<Book, Book> procesarLibros(List<Book> libros) {
        Comparator<Book> comparadorLibros = new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                int comparacionPorTitulo = b2.getTitulo().compareTo(b1.getTitulo());
                
                if (comparacionPorTitulo != 0) {
                    return comparacionPorTitulo;
                } else {
                    return Integer.compare(b1.getAnio(), b2.getAnio());
                }
            }
        };

        Map<Book, Book> librosOrdenados = new TreeMap<>(comparadorLibros);

        for (Book libro : libros) {
            librosOrdenados.put(libro, libro);
        }

        return librosOrdenados;
    }
}

