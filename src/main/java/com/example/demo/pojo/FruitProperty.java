package com.example.demo.pojo;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties("fruit")
public class FruitProperty
{
    private List<Fruit> list;
}
