package com.carrot.testspring.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author carrot
 */

@Configuration

public class MyDruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix="spring.druid")
    public HashMap druidProperties() {
        return new HashMap();
    }

    @Bean
    public ServletRegistrationBean druidServlet(@Qualifier("druidProperties") HashMap druidProperties) {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.setInitParameters(druidProperties);
        return reg;
    }

}
