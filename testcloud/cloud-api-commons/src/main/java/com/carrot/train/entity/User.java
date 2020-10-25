package com.carrot.train.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 5237730257103305078L;
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String status;


}
