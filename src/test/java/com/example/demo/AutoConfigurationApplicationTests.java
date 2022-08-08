package com.example.demo;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoConfigurationApplicationTests
{
    @Value("${property.test.name}")
    private String propertyName;

    @Test
    public void testValue(){
        Assertions.assertThat(this.propertyName).isEqualTo("property depth test");
    }

}
