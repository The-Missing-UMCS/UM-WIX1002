package Lab10;

import java.util.*;

public class DataStructure {
    public static void main(String[] args) {
        // // ArrayList
        // // HashSet
        // // HashMap
        // // Collections.sort()
        // // Arrays.sort()
        // StringBuilder

        // StringBuilder sb = new StringBuilder();
        // String - immutable, cannot be changed
        // Once the string is created, it cannot be changed
        // String s = "Hello";
        // s = s + " World";
        // In your heap memory, there will be 2 strings
        // 1. Hello
        // 2. Hello World
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        // still have 1 stringBuilder only in heap memory
        System.out.println(sb.reverse());


        // HashMap
        // 1. No duplicate key
        // 2. No order
        // 3. No index
        // 4. No get
        // 5. No set
        // Key - Value
        // Map<String, String> hm = Map.of(
        //     "M001", "John",
        //     "M002", "Peter",
        //     "M003", "Mary",
        //     "M004", "Jane"
        // );

        // System.out.println(hm);
        // String value = "Jane";
        
        // // Entry means key-value pair
        // // entry will have method for access key - entry.getKey()
        // // entry will have method for access value - entry.getValue()
        // for(Map.Entry<String, String> entry : hm.entrySet()) {
        //     if(entry.getValue().equals(value)) {
        //         System.out.println("The matric no for " + value + " is " + entry.getKey());
        //     }
        // }


        // // HashSet
        // ArrayList<Integer> ls = new ArrayList<>();
        // HashSet<Integer> hs = new HashSet<>();
        // ls.add(1);
        // ls.add(1);
        // ls.add(1);
        // System.out.println(ls);

        // HashSet
        // 1. No duplicate
        // 2. No order
        // 3. No index
        // 4. No get

        // System.out.println("1st add on hs : " + hs.add(2));
        // System.out.println("2nd add on hs : " + hs.add(2));
        // System.out.println("3rd add on hs : " + hs.add(2));
        // hs.add(3);
        // hs.add(4);
        // hs.add(5);
        // hs.add(5);
        // hs.add(6);
        // hs.add(6);
        // hs.add(6);
        // hs.add(2);
        
        // System.out.println(hs);
        // System.out.println("Hashset contains 1: " + hs.contains(1));
        // System.out.println("Hashset contains 2: " + hs.contains(2));
        // System.out.println("Hashset contains 3: " + hs.contains(3));
    

        // System.out.println("1st add on hs : " + hs.add(1));
        // System.out.println("2nd add on hs : " + hs.add(1));
        // System.out.println("3rd add on hs : " + hs.add(1));
        // System.out.println(hs);

        // Two Sum
        
        // HashMap








        // int[] arr = { 3, 1, 2 };

        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(3);
        // list.add(1);
        // list.add(2);

        // System.out.println("List : " + list);
        // System.out.println("Array: " + Arrays.toString(arr));

        // Arrays.sort(arr);
        // System.out.println("Array: " + Arrays.toString(arr)
        //         .replace("[", "")
        //         .replace("]", ""));

        // Collections.sort(list);
        // System.out.println("List : " + list);

        // // Student's list
        // // Student - name, age, cgpa
        // List<Student> studentList = new ArrayList<>(List.of(
        //     new Student("John", 20, 3.5),
        //     new Student("Peter", 21, 3.6),
        //     new Student("Mary", 19, 3.7),
        //     new Student("Jane", 20, 3.8)
        // ));
        
        // System.out.println();

        // for(Student s : studentList)
        //     System.out.println(s);

        // Collections.sort(studentList);

        // System.out.println();

        // for(Student s : studentList)
        //     System.out.println(s);
    }
}

class Student implements Comparable<Student> {
    String name;
    int age;
    double cgpa;

    public Student(String name, int age, double cgpa) {
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", name, age, cgpa);
    }

    @Override
    public int compareTo(Student o) {
        return -1 * Double.compare(this.cgpa, o.cgpa);
    }

    
}
