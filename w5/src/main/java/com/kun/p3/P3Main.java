package com.kun.p3;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

/**
 * @author kun
 * @date 2022/4/3
 */
@SpringBootApplication
public class P3Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        SpringApplication.run(P3Main.class, args);

//        // h2 start
//        Server server = Server.createTcpServer();
//        server.start();
//        try {
//            // spi
//            Class.forName("org.h2.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:h2:mem://localhost:9092/test", "sa", "");
//            Statement creation = conn.createStatement();
//            int cd = creation.executeUpdate("create table student (id int primary key, name varchar(64) not null)");
//            System.out.println("create table success: " + cd);
//        } finally {
//            server.stop();
//        }

    }
}
