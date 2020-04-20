package com.carrot.testspring.entities;

import lombok.Data;

import javax.persistence.*;

/**
 * @author carrot
 */
@Data
@Entity
@Table(name="tb_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "last_name",length = 50)
    private String lastname;

    @Column
    private String email;



}
