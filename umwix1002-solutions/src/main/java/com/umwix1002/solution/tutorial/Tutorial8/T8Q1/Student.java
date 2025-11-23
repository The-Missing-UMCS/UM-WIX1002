package com.umwix1002.solution.tutorial.Tutorial8.T8Q1;

public class Student {
    private String contact;

    Student() {
        contact = null;
    }

    Student(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void showContact() {
        System.out.println("Contact: " + contact);
    }
}
