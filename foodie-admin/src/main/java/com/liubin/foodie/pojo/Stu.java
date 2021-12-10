package com.liubin.foodie.pojo;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Stu {
    @Id
    private Integer id;

    private String name;

    private Integer age;

}