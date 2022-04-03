package com.kun.p2.config;

import com.kun.p2.model.Klass;
import com.kun.p2.model.School;
import com.kun.p2.model.Student;
import com.kun.p2.model.StudentImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * @author kun
 * @date 2022/4/3
 */
@Configuration
// it's unnecessary for p3
@ConditionalOnProperty(prefix = "homework.p2", value = "enabled", matchIfMissing = true)
public class AutoConfig {

    /*
     * 不加条件 粗暴地引入即装配
     */

    @Bean
    public Student student() {
        return new StudentImpl().setId(3375L).setName("goodStudent");
    }

    @Bean
    public Klass klass(Student student) {
        return new Klass().setName("camp").setStudents(Collections.singletonList(student));
    }

    @Bean
    public School school(Klass klass) {
        return new School().setName("geekSchool").setKlasses(Collections.singletonList(klass));
    }
}
