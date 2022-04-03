package com.kun.p2.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author kun
 * @date 2022/4/3
 */
@Data
@Accessors(chain = true)
public class School {

    private String name;

    private List<Klass> klasses;

    @PostConstruct
    private void afterInit() {
        System.out.println("done: " + this);
    }
}
