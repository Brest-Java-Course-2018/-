package com.epam.brest.course;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
@RunWith(Theories.class)
public class AppTest {
    @Test
    public void main() {
        final ByteArrayOutputStream byteArrayOutputStream =
                new ByteArrayOutputStream();
        PrintStream printStream = System.out;

        System.setOut(new PrintStream(byteArrayOutputStream));

        try {
            App.main(null);
        } catch (Exception e) {
            assertTrue(false);
            e.printStackTrace();
        } finally {
            System.setOut(printStream);
        }

        //assertEquals("Hello World!\n", byteArrayOutputStream.toString());
        assertTrue(true);
    }


    @Theory
    public void sum(long[] candidate) {
        assertEquals(candidate[2], App.sum(candidate[0], candidate[1]));
    }

    public static @DataPoints
    long[][] candidates = {{1, 2, 3}, {4, 5, 9}, {10, -15, -5}};
}
