package com.umwix1002.solution.tutorial.Tutorial8.T8Q5;

public class Main {
    public static void main(String[] args) {
        Connection one = new Connection("AE016");
        Connection two = new Connection("AE017");
        Connection three = new Connection("AE018");

        Connection.showConnection();

        one.disconnect();

        Connection.showConnection();
    }
}