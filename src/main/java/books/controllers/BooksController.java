package books.controllers;

import books.classes.Book;
import books.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BooksController {
    private static final Logger lg = LoggerFactory.getLogger(BooksController.class);
    private int count = 4;
    private List<Book> books = new ArrayList<>(){
        {
            add (new Book(1,"Skazki","Tolstoi"));
            add (new Book (2,"Rasskazi","Rybakov"));
        }
    };

    @GetMapping
    public List<Book> booksHelloPage(){
        return books;
    }
    @GetMapping("{id}")
    public Book getOneId(@PathVariable String id){
        long longId = Long.valueOf(id);
        return getBook(longId);
    }

    private Book getBook(long longId) {
        return books.stream().filter(book->book.getId()==longId).findFirst().orElseThrow(NotFoundException::new);
    }

//    @GetMapping("{title}")
//    public Book getOneTitle(@PathVariable String title){
//        return books.stream().filter(book->book.getTitle().equals(title)).findFirst().orElseThrow(NotFoundException::new);
//    }
    @PostMapping()
    public Book create(@RequestBody Book book){
        Book newBook = new Book(++count,book.getTitle(),book.getAuthor());
        books.add(newBook);
        return newBook;
    }
    @PutMapping("{id}")
    public Book update(@PathVariable String id,@RequestBody Book book){
        Book bookFromDB = getBook(Long.valueOf(id));
        bookFromDB.setTitle(book.getTitle());
        bookFromDB.setAuthor(book.getAuthor());
        bookFromDB.setId(Long.valueOf(id));
        return bookFromDB;
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        books.remove(getBook(Long.valueOf(id)));
    }
}
