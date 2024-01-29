package mx.edu.utez.examen_unidad_1.controllers;

import mx.edu.utez.examen_unidad_1.models.book.Book;
import mx.edu.utez.examen_unidad_1.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = {"*"})
public class BookController {
    private final BookService service;


    public BookController(BookService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.POST)
    public Book save(@RequestBody BookDto bookDto){
        return service.save(bookDto);
    }

    @GetMapping("/{id}")
    public Optional<Book> getOneById(@PathVariable Long  id){
        return service.findById(id);
    }

    @RequestMapping(value = "/books", produces = "application/json", method = RequestMethod.GET)
    public List<Book> findAll(){
        return service.findAll();
    }

//    @GetMapping("/getAll")
//    public List<Book> findAll(){
//        return service.findAll();
//    }

    @DeleteMapping("/{id}")
    public void delte(@PathVariable Long id){
        service.deleteBook(id);
    }






}
