package com.example.demo.pojo;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyTest
{

    @Autowired
    FruitProperty fruitProperty;

    @Test
    public void test(){
        List<Fruit> fruitData = fruitProperty.getList();
        Assertions.assertThat(fruitData.get(0).getName()).isEqualTo("banana");
    }
}
