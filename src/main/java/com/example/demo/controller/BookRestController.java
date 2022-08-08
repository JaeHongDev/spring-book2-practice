package com.example.demo.controller;


import com.example.demo.domain.Book;
import com.example.demo.service.BookRestService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BookRestController {
    private final BookRestService bookRestService;

    @GetMapping(path = "/rest/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getRestBooks(){
        return bookRestService.getRestBook();
    }
}
