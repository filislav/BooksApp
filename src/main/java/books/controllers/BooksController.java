package books.controllers;

import books.classes.Book;
import books.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("books")
public class BooksController {
    private static final Logger lg = LoggerFactory.getLogger(BooksController.class);
    public List<Map<String,String>> books = new ArrayList<>(){{
        add(new HashMap<String,String>() {{ put("id","1");put("title","skazka");}});
        add(new HashMap<String,String>() {{ put("id","2");put("title","rasskaz");}});
    }};

    @GetMapping
    public List<Map<String,String>> booksHelloPage(){
        return books;
    }
    @GetMapping("{id}")
    public Map<String,String> getOne(@PathVariable String id){
        return books.stream().filter(book->book.get("id").equals(id)).findFirst().orElseThrow(NotFoundException::new);
    }


}
