package com.carrot.testspring;

import com.carrot.testspring.bean.Persion;
import com.carrot.testspring.service.Helloservice;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;

//import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.platform.commons.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SpringBootTest
class TestspringApplicationTests {

    @Autowired
    Persion persion;

    Logger log=LoggerFactory.getLogger((getClass()));

/*    @Autowired
    ApplicationContext ioc;*/

/*    @Test
    public String testhelloservice(){
        return ioc.
    }*/

    @Test
    void contextLoads() {
        System.out.println(persion);
        log.trace("this is trace...");
        log.debug("this is debug");
        log.info("this is info");
        log.warn("this is warn");
        log.error("this is error");
    }

}
