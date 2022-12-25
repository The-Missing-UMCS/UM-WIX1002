# Lab 7 - Question 5

## Question

Write a program that read data from a binary file `person.dat`. Then, display the name, age and gender (M – Male, F – Female) in ascending order sort by name. The structure of the binary file is as below:

```md
<intVariable-TotalNumberofRecord>
<StringVariable-Name><IntVariable-Age><CharVariable-Gender>
…
<StringVariable-Name><IntVariable-Age><CharVariable-Gender>
```

</br>

## Solution overview

---

There are various methods for answering this question. We won't go into great detail on __reading the binary file__ because it's not complicated. Please see `N_FileIO.pdf` if you're interested in learning more.

The manner we wish to sort the name in this question—in ascending order—will be the intriguing portion. Sorting can take a number of different forms depending on the data structure we employed to store those data.

In essence, there are several ways to save the details, including:

1. Multiple arrays
2. 2 Dimensional arrays
3. Class with Array/ ArrayList
4. HashMap

We'll talk about how to use these data structures to store the information and how to sort it. We won't talk about the internal implementation of `ArrayList` and `HashMap`, though. You can consult the official documentations if you are interested in these data structures.

In the following code, we'll use `//...` to indicate some of the code to keep it clean. You can refer to the GitHub for the complete source code.

</br>

### Read a binary file

```java
public static void readFile(String path, String[][] person) {
    String path = "../WIX1002/io_files/person.dat";
    try {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(path));
        
        input.close();
    } catch (IOException ex) { 
        ex.printStackTrace();
    }
}
```

</br>

## __Using multiple arrays__

---

```java
public static void main(String[] args) {
    // Skip codes ...
    final int N = output.readInt();
                
    String[] nameArr = new String[N];
    int[] ageArr = new int[N];
    char[] genderArr = new char[N];
    int[] indexArr = new int[N];


    for(int i = 0; i < N; i++) {
        indexArr[i] = i;
        nameArr[i] = output.readUTF();
        ageArr[i] = output.readInt();
        genderArr[i] = output.readChar();
    }

    sortIndexByName(indexArr, nameArr);

    for(int i : indexArr) 
            System.out.printf(" %-13s %3d %3s \n", nameArr[i], ageArr[i], genderArr[i]);
    // Skip codes ...
}

public static void sortIndexByName(int[] indexArr, String[] nameArr) {
    // Bubble sort
    for(int i = 0; i < indexArr.length; i++) {
        for(int j = 0 ; j < indexArr.length - i - 1; j++) {
            int before = indexArr[j];
            int after = indexArr[j + 1];
            
            if(nameArr[before].compareTo(nameArr[after]) > 0) {
                indexArr[j] = after;
                indexArr[j + 1] = before;
            }
        }
    }
}

```

</br>

## __Using 2-Dimensional Matrices__

---

```java
public static void main(String[] args) {
    // Skip codes ...
    
    final int N = input.readInt();
    String[][] person = new int[N][3];

    for(int i = 0; i < N; i++) {
        person[i][0] = (String) input.readObject();
        person[i][1] = Integer.toString(input.readInt());
        person[i][2] = Character.toString(input.readChar());
    }

    sortMatrixByName(person);

    for(int i : indexArr) 
            System.out.printf(" %-13s %3d %3s \n", nameArr[i], ageArr[i], genderArr[i]);
    // Skip codes ...
}

public static void sortMatrixByName(String[][] person) {
    // Bubble Sort
    for(int i = 0; i < person.length; i++) {
        for(int j = 0; j < person.length - 1 - i; j++) {
            if(person[j][0].compareTo(person[j + 1][0]) > 0) {
                String[] tmp = person[j];
                person[j] = person[j + 1];
                person[j + 1] = tmp;
            }
        }
    }
} 
```

</br>

## __Using ArrayList and Class__

### `main.java`

```java
import java.util.ArrayList;
import java.util.Collections;
// --> import java.util.Arrays;

public static void main(String[] args) {
    // Skip codes ...
    final int N = input.readInt();
    ArrayList<Person> personList = new ArrayList<Person>();
    // --> Person[] personList = new Person[N];

    for(int i = 0; i < N; i++)
        personList.add(new Person(input.readUTF(), input.readInt(), input.readChar()));
        // --> personList[i] = new Person(input.readUTF(), input.readInt(), input.readChar());

    Collections.sort(personList);
    // --> Arrays.sort(personList);

    for(Person person : personList)
        System.out.printf(" %-13s %3d %3s \n", person.getName(), person.getAge(), person.getGender());

    // Skip codes ...
}
```

### `person.java`

```java
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private char gender;

    Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public int compareTo(Person another) {
        return this.name.compareTo(another.getName());
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public char getGender() {
        return this.gender;
    }
}
```

## Using HashMap

