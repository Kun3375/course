package com.kun.p2.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author kun
 * @date 2022/4/3
 */
@Data
@Accessors(chain = true)
public class StudentImpl implements Student {

    private Long id;

    private String name;

    @Override
    public void doing() {
        System.out.println("student is studying");
    }
}
