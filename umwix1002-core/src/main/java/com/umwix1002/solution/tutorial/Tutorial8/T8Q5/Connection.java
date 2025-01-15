package com.umwix1002.solution.tutorial.Tutorial8.T8Q5;

import java.util.ArrayList;

public class Connection {
    private static int connectionCount = 0;
    private static ArrayList<String> connectionList = new ArrayList<String>();
    private final String LOCAL_ID;

    Connection(String ID) {
        connectionCount++;
        this.LOCAL_ID = ID;
        connectionList.add(LOCAL_ID);
    }

    public static void showConnection() {
        System.out.printf("Current connection: %d\n", connectionCount);
        for (int i = 0; i < connectionList.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), connectionList.get(i));
        }
    }

    public void disconnect() {
        connectionCount--;
        connectionList.removeIf(this.getID()::equals);
    }

    public String getID() {
        return this.LOCAL_ID;
    }
}
