package com.kun.p1.model;

import lombok.Data;

import java.util.List;

/**
 * @author kun
 * @date 2022/4/3
 */
@Data
public class School {

    private String name;

    private List<Klass> klasses;
}
