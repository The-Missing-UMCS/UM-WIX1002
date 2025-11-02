package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q5;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
    private static final String FILE = "C:\\Users\\User\\Desktop\\projects\\@um-projects\\missing\\UM-WIX1002\\umwix1002-core\\src\\main\\java\\com\\umwix1002\\solution\\pastyear\\PastYear2024\\wix1002_2024_1\\Q5\\Q5A\\participants.txt";

    public static void main(String[] args) throws Exception {
        // 1. 分析他们是不是来自同个地方
        // 1.1. 读取数据
        Participant[] participants = new Participant[4];
        int participantIndex = 0;
        try (Scanner scanner = new Scanner(new FileInputStream(FILE))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(",");
                participants[participantIndex] = new Participant(info[0], info[1], info[2], info[3]);
                participantIndex++;
            }
        }

        // 1.2. 地址进行判断 - 大小写不重要 equalsIgnoreCase，空格不重要
        // Hardcoded
        for (int i = 0; i < participants.length - 1; i += 2) {
            Participant p1 = participants[i];
            Participant p2 = participants[i + 1];

            String address1 = p1.getAddress();
            String address2 = p2.getAddress();

            String address1Trim = String.join("", address1.split("\\s+")).toLowerCase();
            String address2Trim = String.join("", address2.split("\\s+")).toLowerCase();

            for (int j = 0; j < address1Trim.length(); j++) {
                if (address1Trim.charAt(j) != address2Trim.charAt(j)) {
                    System.out.println(p1.getName());
                    System.out.println(p2.getName());
                    System.out.println("They are not from the same place.");
                    break;
                }
            }
        }

        // 2. 安排座位
        Participant[] participants2 = new Participant[4];
        participants2[0] = participants[0];
        participants2[1] = participants[2];
        participants2[2] = participants[1];
        participants2[3] = participants[3];

        for(Participant participant : participants2) {
            System.out.println(participant.getName());
        }

        // HashMap - Key Value Pair 键值对
        // HashSet - Value 集合
        // 集合 -> 不重复的元素


    }

    static class Participant {
        private String name;
        private String gender;
        private String year;
        private String address;

        public Participant(String name, String gender, String year, String address) {
            this.name = name;
            this.gender = gender;
            this.year = year;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public String getYear() {
            return year;
        }

        public String getAddress() {
            return address;
        }
    }
}
