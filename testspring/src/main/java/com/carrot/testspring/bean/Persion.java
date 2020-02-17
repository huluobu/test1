package com.carrot.testspring.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "persion")

/*@Data
@Builder
@AllArgsConstructor*/
public class Persion {
//    @Value('$zhangsan')
    private  String lastName;
/*    @Value("#{36/2}")*/
    private  int age;
    private  Date data;
    private  List<Object> list;

    @Override
    public String toString() {
        return "person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", data=" + data +
                ", list=" + list +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Date getData() {
        return data;
    }

    public List<Object> getList() {
        return list;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}

