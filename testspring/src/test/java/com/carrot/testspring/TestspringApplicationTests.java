package com.carrot.testspring;

import com.carrot.testspring.bean.Persion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestspringApplicationTests {

    @Autowired
    Persion persion;

    @Test
    void contextLoads() {
        System.out.println(persion);
    }

}
