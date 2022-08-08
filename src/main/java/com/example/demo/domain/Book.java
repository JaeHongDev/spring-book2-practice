package com.example.demo.domain;


import jdk.jfr.Enabled;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
@Table
public class Book {

    @Id
    @GeneratedValue
    private Integer idx;
    @Column
    private String title;
    @Column
    private LocalDateTime publishedAt;

    @Builder
    public Book(String title, LocalDateTime publishedAt){
        this.title = title;
        this.publishedAt = publishedAt;
    }

}
