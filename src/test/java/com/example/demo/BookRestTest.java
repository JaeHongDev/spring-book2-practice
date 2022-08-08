package com.example.demo;

import com.example.demo.domain.Book;
import com.example.demo.service.BookRestService;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.HttpServerErrorException;

@RunWith(SpringRunner.class)
@RestClientTest(BookRestService.class)
public class BookRestTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private BookRestService bookRestService;

    @Autowired
    private MockRestServiceServer server;


    @Test
    public void rest_test(){
        this.server.expect(MockRestRequestMatchers.requestTo("/rest/test"))
                .andRespond(MockRestResponseCreators.withSuccess(new ClassPathResource("/test.json", getClass()), MediaType.APPLICATION_JSON));
        Book book = this.bookRestService.getRestBook();
        Assertions.assertThat(book.getTitle()).isEqualTo("테스트");
    }
    @Test
    public void rest_error_test(){
        this.server.expect(MockRestRequestMatchers.requestTo("/rest/test"))
                .andRespond(MockRestResponseCreators.withServerError());
        this.thrown.expect(HttpServerErrorException.class);
        this.bookRestService.getRestBook();
    }

}
