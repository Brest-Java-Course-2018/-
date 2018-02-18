package com.epam.brest.course;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        DBUtils dbUtils = new DBUtils();
        Connection connection = dbUtils.getConnection();
        dbUtils.createUserTable(connection);
        dbUtils.addUser(connection, "admin", "admin", "User admin");
        dbUtils.addUser(connection, "admin1", "admin1", "User admin1");
        dbUtils.addUser(connection, "admin2", "admin2", "User admin2");
        dbUtils.addUser(connection, "a", "b", "c");
        dbUtils.deleteUser(connection, "a");
        dbUtils.getUsers(connection);
    }

    /**
     * @param a first addendum
     * @param b second addendum
     * @return a + b
     */
    public static long sum(long a, long b) {
        return a + b;
    }
}
