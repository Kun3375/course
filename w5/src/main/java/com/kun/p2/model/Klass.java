package com.kun.p2.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author kun
 * @date 2022/4/3
 */
@Data
@Accessors(chain = true)
public class Klass {

    private String name;

    private List<Student> students;
}
