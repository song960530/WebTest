package com.example.sprirngboot.web.dto;


import com.example.springboot.web.dto.HelloResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class HelloResponseDtoTest {
    @Test
    public void lombokTest(){
        String name="test";
        int amount=10000;

        HelloResponseDto dto = new HelloResponseDto(name,amount);

        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
