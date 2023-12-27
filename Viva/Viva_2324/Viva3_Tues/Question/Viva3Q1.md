# Viva3Q1

## Question

Modify your `Aran.isValid()` method to accept an input string consisting of alphabets and digits. Digits can be placed anywhere.

There are two types of characters: Main Characters (PTMQ) and Special Characters (BDGH).

Rules for Main Characters:

- P can only be followed by T.
- M can only be followed by M.
- Q can only be followed by none.

However, these rules on Main Characters can be broken due to the presence of Special Characters.

Rules for Special Characters:

- B may or may not exist before P.
- D may or may not exist before T.
- G may or may not exist after M.
- H may or may not exist after Q.

As long as the Special Characters follow the defined rules, the sequence of PTMQ could be random. For example:

```bash
- TP: false
- TBP: true
- BDT: true
- DTP: false
```

The input string should contain at least one main character, otherwise, it should return false."

## Sample Input

```java
public static void main(String[] args) {
    String[] testCases = new String[] {
            "PTM", "PTMMTP", "BPTMBPTM", "PT", "PTMQ", "PTMQH", "BPTMQH", "PTMQH", "BPDTMGQH", 
            "PTMQH", "PTMQH", "12PTHQGM", "12PTQHMG", "12PTMGQH", "PTMQBPTMQBPTMQ", "DTBP123QHMG", 
            "BTDP", "TP", "TBP", "BDT", "DTP", "ABCD", "D"
    };

    for (String input : testCases) 
        System.out.printf("%-20s : %s\n", input, Aran.isValid(input));
}
```

## Sample Output

```bash
PTM             : true
PTMMTP          : false
BPTMBPTM        : true
PT              : true
PTMQ            : true
PTMQH           : true
BPTMQH          : true
PTMQH           : true
BPDTMGQH        : true
PTMQH           : true
PTMQH           : true
12PTHQGM        : false
12PTQHMG        : false
12PTMGQH        : true
PTMQBPTMQBPTMQ  : true
DTBP123QHMG     : true
BTDP            : false
TP              : false
TBP             : true
BDT             : true
DTP             : false
ABCD            : false
D               : false
```
