package com.epam.brest.course;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DBUtilsTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private PrintStream printStream;
    private DBUtils dbUtils = new DBUtils();

    //@org.junit.Test
    @Test
    public void getConnection() throws SQLException, ClassNotFoundException {
        DBUtils dbUtils = new DBUtils();
        dbUtils.getConnection();
        assertEquals("Connect to DB.\n", byteArrayOutputStream.toString());
    }

    @Before
    public void setUp() {
        printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    public void addUser() throws SQLException, ClassNotFoundException {
        Connection connection = dbUtils.getConnection();
        dbUtils.createUserTable(connection);
        dbUtils.addUser(connection, "log", "pas", "des");
        dbUtils.deleteUser(connection, "log");
        assertEquals("Connect to DB.\n" +
                "Create app_user table.\n" +
                "Add user: log.\n" +
                "Delete user: log.\n", byteArrayOutputStream.toString());
    }
}