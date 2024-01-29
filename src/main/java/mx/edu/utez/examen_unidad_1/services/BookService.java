package mx.edu.utez.examen_unidad_1.services;

import mx.edu.utez.examen_unidad_1.controllers.BookDto;
import mx.edu.utez.examen_unidad_1.models.Generator.FolioGenerator;
import mx.edu.utez.examen_unidad_1.models.book.Book;
import mx.edu.utez.examen_unidad_1.models.book.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    private final BookRepository repository;
    FolioGenerator folioGenerator = new FolioGenerator();

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Optional<Book> findById(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Book save(BookDto bookDto){
        Book book = Book.builder()
                .name(bookDto.getName())
                .isbn(bookDto.getIsbn())
                .autor(bookDto.getNombreAutor())
                .categoria(bookDto.getCategoria())
                .paginas(bookDto.getPaginas())
                .fechaDePublicacion(bookDto.getFechaDePublicacion())
                .folio(folioGenerator.generateFolio(
                        bookDto.getName(),
                        bookDto.getNombreAutor(),
                        bookDto.getApellidoAutor(),
                        bookDto.getFechaDePublicacion().toString(),
                        bookDto.getIsbn()
                ))
                .build();

        return repository.save(book);

    }

    @Transactional(readOnly = true)
    public List<Book> findAll(){
        return repository.findAll();
    }

    @Transactional
    public void deleteBook(Long id){
        repository.deleteBook(id);
    }







    /*

El folio del libro se debe componer de la primera letra del título,
la primera letra del nombre del autor, las primeras letras del apellido del autor,
la fecha de publicación (yyyy-MM-dd), las primeras 4 letras del ISBN y 2 dígitos random (letras y números).
No debe haber libros con el mismo folio y ISBN.

Nombre: Harry potter -> primer letra
Nombre del autor: JK ROWLING -> primer letra del nombre
Apellido del autor: -> primeras 2 letras
Fecha de publicacion: 2002-01-12 -> (yyyy-MM-dd)
ISBN: KDSHJFWER23 -> primeras 4

FOLIO:
HJRO2002-01-12 KDSH AB




     */

}
