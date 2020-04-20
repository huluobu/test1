package com.carrot.testspring;

import com.carrot.testspring.bean.Persion;
import com.carrot.testspring.service.Helloservice;
import org.apache.catalina.core.ApplicationContext;
import org.junit.Test;

//import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.platform.commons.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestspringApplicationTests {

    @Autowired
    Persion persion;

    @Autowired
    DataSource dataSource;

    Logger log=LoggerFactory.getLogger((getClass()));

/*    @Autowired
    ApplicationContext ioc;*/

/*    @Test
    public String testhelloservice(){
        return ioc.
    }*/

/*    @Test
    void contextLoads() {
        System.out.println(persion);
        log.trace("this is trace...");
        log.debug("this is debug");
        log.info("this is info");
        log.warn("this is warn");
        log.error("this is error");
    }*/

     @Test
     public void  contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
