package com.example.demo;


import com.example.demo.domain.Book;
import com.example.demo.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookJpaTest {
    private final static String BOOT_TEST_TITLE = "Spring Boot Test Book";

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void save_book_test(){
        Book book1 = Book.builder().title(BOOT_TEST_TITLE).publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book1);

        Book book2 = Book.builder().title(BOOT_TEST_TITLE + "2").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book2);

        Book book3 = Book.builder().title(BOOT_TEST_TITLE + "3").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book3);

        List<Book> bookList = bookRepository.findAll();
        Assertions.assertThat(bookList).hasSize(3);
        Assertions.assertThat(bookList).contains(book1,book2,book3);
    }

    @Test
    public void bookList_저장하고_삭제_테스트(){
        Book book1 = Book.builder().title(BOOT_TEST_TITLE + "1").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book1);
        Book book2 = Book.builder().title(BOOT_TEST_TITLE + "2").publishedAt(LocalDateTime.now()).build();
        testEntityManager.persist(book2);

        bookRepository.deleteAll();
        Assertions.assertThat(bookRepository.findAll()).isEmpty();
    }
}
