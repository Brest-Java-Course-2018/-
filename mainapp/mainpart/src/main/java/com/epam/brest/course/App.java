package com.epam.brest.course;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        DBUtils dbUtils = new DBUtils();
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
