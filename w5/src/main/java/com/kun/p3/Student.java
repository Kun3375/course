package com.kun.p3;

import lombok.Data;

import javax.persistence.*;

/**
 * @author kun
 * @date 2022/4/3
 */
@Data
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;
}
