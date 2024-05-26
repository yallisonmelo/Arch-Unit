package br.com.yfsmsystem.archunit.entity;

import lombok.Data;

@Data
public class CustomerEntity {

    private Integer id;

    private String name;

    private String email;

    private String password;

}
