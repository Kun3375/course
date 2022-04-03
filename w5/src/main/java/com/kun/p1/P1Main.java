package com.kun.p1;

import com.kun.p1.model.Student;
import com.kun.p1.model.School;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author kun
 * @date 2022/4/3
 */
public class P1Main {

    public static void main(String[] args) {
        // xml 装配
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        School school = context.getBean(School.class);
        System.out.println(school);

        // aop
        Map<String, Student> persons = context.getBeansOfType(Student.class);
        Student goodStudent = persons.get("goodStudent");
        System.out.println(goodStudent);
        goodStudent.doing();
    }


}
