package com.thymeleaf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ThymeleafApplicationTests {

    @Test
    void contextLoads() {
        List<String> lists = new ArrayList<>();
        lists.add("老龚");
        lists.add("老蔡");
        lists.add("老蔡2");
        lists.add("老蔡3");
        System.out.println(lists);
    }

}
