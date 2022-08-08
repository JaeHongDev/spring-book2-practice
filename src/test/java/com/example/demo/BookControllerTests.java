package com.example.demo;


import com.example.demo.controller.BookController;
import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Collections;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    @Test
    public void Book_MVC_테스트() throws Exception {
        Book book = new Book("Spring Boot Book", LocalDateTime.now());
        BDDMockito.given(bookService.getBookList()).willReturn(Collections.singletonList(book));
        mvc.perform(MockMvcRequestBuilders.get("/books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("book"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("bookList"))
                .andExpect(MockMvcResultMatchers.model().attribute("bookList", Matchers.contains(book)));
    }
}
