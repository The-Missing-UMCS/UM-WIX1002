package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q3;

import java.io.FileInputStream;
import java.util.*;

import static com.umwix1002.solution.Properties.PAST_YEAR;

public class Main {
    public static void main(String[] args) throws Exception {
        String inputFile = PAST_YEAR + "PastYear2024/wix1002_2024_1/Q3/oaiset.csv";

        // 1. Read csv into JVM
        Scanner scanner = new Scanner(new FileInputStream(inputFile));
        // attribute = 13
        scanner.nextLine();
        OAIRecord[] data = new OAIRecord[50];
        int index = 0;
        while (scanner.hasNextLine()) {
            String newLine = scanner.nextLine();
            // 10.22452/2/V001,Over always security whom.,History,Lisa Goodman,,,,,,,,Keyword_1,approved
            String[] info = newLine.split(",");
            String doi = info[0];
            String title = info[1];
            String subject = info[2];

            String author1 = info[3];
            String author2 = info[4];
            String author3 = info[5];
            String author4 = info[6];
            String author5 = info[7];
            String author6 = info[8];
            String author7 = info[9];
            String author8 = info[10];

            List<String> authors = List.of(author1, author2, author3, author4, author5, author6, author7, author8);

            String keyword = info[8];
            String status = info[9];

            OAIRecord newRecord = new OAIRecord(doi, title, subject, authors, keyword, status);
            data[index] = newRecord;
            index++;
        }

        // 2. Remove `deleted`
        OAIRecord[] cleanedData = new OAIRecord[50];
        int cleanedIndex = 0;
        for (int originalIndex = 0; originalIndex < 50; originalIndex++) {
            // 1. 判断目前 status, 如果是 deleted 就不要，如果不是 deleted 我们就放进去 cleanedData
            OAIRecord currentRecord = data[originalIndex];
            if (currentRecord == null) {
                continue;
            }

            if (!currentRecord.getStatus().equals("deleted")) {
                cleanedData[cleanedIndex] = currentRecord;
                cleanedIndex++;
            }
        }

        // 3. Print report
        for (cleanedIndex = 0; cleanedIndex < 50; cleanedIndex++) {
            OAIRecord currentRecord = cleanedData[cleanedIndex];
            if (currentRecord == null) {
                continue;
            }
            System.out.printf("%s %s%n", currentRecord.getDoi(), currentRecord.getTitle());
        }

        // key-value pairs
        // Python - dictionary
        // 词汇(key) - 解释(value)
        // author1, 1
        // author2, 3
        // author3, 2
        Map<String, Integer> map = new HashMap<>();
        for (cleanedIndex = 0; cleanedIndex < 50; cleanedIndex++) {
            OAIRecord currentRecord = cleanedData[cleanedIndex];
            if (currentRecord == null) {
                continue;
            }
            List<String> authors = currentRecord.getAuthors();
            for (int i = 0; i < authors.size(); i++) {
                String author = authors.get(i);
                if (map.containsKey(author)) {
                    int currentCount = map.get(author);
                    int newCount = currentCount + 1;
                    map.put(author, newCount);
                } else {
                    map.put(author, 1);
                }
            }
        }

        // Key
        for (String author : map.keySet()) {
            int count = map.get(author);
            System.out.printf("%s: %d%n", author, count);
        }
    }
}
