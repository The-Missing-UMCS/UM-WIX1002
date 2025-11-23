package com.umwix1002.solution.pastyear.PastYear2020.Q3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, Integer> map = new HashMap<>();

        // 1. 读取数据 - Scanner + FileInputStream + copy paste 绝对路径 + throws Exception
        // 2. 这个题目适合怎么存储？ Array + ArrayList
        // 3. 我们达到目标
        // 4. 我们怎么呈现数据
        try(Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\User\\Desktop\\projects\\@um-projects\\missing\\UM-WIX1002\\umwix1002-core\\src\\main\\java\\com\\umwix1002\\solution\\pastyear\\PastYear2020\\Q3\\raw.txt"))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] info = line.split(" ");
                int[] values = new int[info.length];

                for(int i = 0; i < info.length; i++) {
                    values[i] = Integer.parseInt(info[i]);
                    // values[i] = 2, 4, 6, 8, 10...
                    // Key=2, Value=5
                    if(map.containsKey(values[i])) {
                        // 1. 如果 map 他没有这个 key，他就会把右边的数值放进去
                        // 2. 如果 map 他有这个 key，那他就会更新这个数值
                        int oldValue = map.get(values[i]);
                        int newValue = oldValue + 1;
                        map.put(values[i], newValue);
                    } else {
                        map.put(values[i], 1);
                    }
                }
            }
        }

        for(Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        // 1. For loop
        // 2. Enhanced
    }
}
