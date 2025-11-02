package com.umwix1002.solution.lab.lab07;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. 读取数据
        // 2. 存储数据
        // 怎么存储? 几个 array/ arraylist?

        List<Person> newList = new ArrayList<>();
        newList.add(new Person("abc", 25, 'M'));
        newList.add(new Person("abdcff", 27, 'C'));
        Collections.sort(newList);

        // Collections.sort() -> ArrayList/ LinkedList
        // Arrays.sort() -> Array

        int[] array = {2, 5, 1, 4, 9, 3};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));


        System.out.println(newList);

        // String[] -> name
        // int[] -> age
        // char[] -> gender
        // -> PersonalData


        // 3. 处理数据
        // 4. 呈现数据
    }

    @ToString
    static class Person implements Comparable<Person> {
        private String name;
        private int age;
        private char gender;

        public Person(String name, int age, char gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public int compareTo(Person o) {
            return -1 * (age - o.age);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public char getGender() {
            return gender;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }
    }
}
