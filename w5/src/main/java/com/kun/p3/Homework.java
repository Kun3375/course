package com.kun.p3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;

/**
 * @author kun
 * @date 2022/4/3
 */
@Component
public class Homework {

    @PostConstruct
    private void init() throws SQLException {
        System.out.println("--- homework: statement");

        Connection conn = DriverManager.getConnection("jdbc:h2:mem://localhost:9092/test;DB_CLOSE_ON_EXIT=FALSE", "sa", "");
        Statement stat = conn.createStatement();
        stat.executeUpdate("insert into student values (1, 'zhangsang'), (2, 'lisi'), (3, 'wangwu')");
        System.out.println("insert completed");

        stat.clearBatch();
        stat.execute("select * from student");
        ResultSet resultSet = stat.getResultSet();
        while (resultSet.next()) {
            System.out.println("user id: " + resultSet.getLong("id") + ", name: " + resultSet.getString("name"));
        }
        stat.close();

        System.out.println();
        System.out.println("--- homework: batch & tx");

        conn.setAutoCommit(false);
        PreparedStatement ps = conn.prepareStatement("update student set name = ? where id = ?");
        ps.setString(1, "zhangUpdated");
        ps.setLong(2, 1);
        ps.addBatch();
        ps.setString(1, "liUpdate");
        ps.setLong(2, 2);
        ps.addBatch();
        ps.executeBatch();
        System.out.println("batch updated");
        ps.close();
        conn.commit();

        Statement s2 = conn.createStatement();
        s2.execute("select * from student");
        ResultSet rs2 = s2.getResultSet();
        while (rs2.next()) {
            System.out.println("user id: " + rs2.getLong("id") + ", name: " + rs2.getString("name"));
        }
        s2.close();
        conn.close();

        // 手动使用连接池只需要使用 Datasource.getConnection。非 Spring 环境下多一步手动初始化连接池
    }
}
