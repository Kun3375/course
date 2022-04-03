package com.kun.p1.model;

import lombok.Data;

/**
 * @author kun
 * @date 2022/4/3
 */
@Data
public class StudentImpl implements Student {

    private Long id;

    private String name;

    @Override
    public void doing() {
        System.out.println("student is studying");
    }
}
