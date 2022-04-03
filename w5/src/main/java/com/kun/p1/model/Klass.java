package com.kun.p1.model;

import lombok.Data;

import java.util.List;

/**
 * @author kun
 * @date 2022/4/3
 */
@Data
public class Klass {

    private String name;

    private List<Student> students;
}
