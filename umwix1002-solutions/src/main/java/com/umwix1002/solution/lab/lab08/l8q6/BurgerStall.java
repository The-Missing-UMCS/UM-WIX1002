package com.umwix1002.solution.lab.lab08.l8q6;

import com.umwix1002.solution.lab.util.AssertUtil;
import lombok.Data;
import lombok.Getter;


@Data
public class BurgerStall {
    @Getter
    private static int allSales;
    
    private final String id;
    private int totalSold;
    
    public BurgerStall(String id) {
        this.id = id;
    }

    public void sold(int count) {
        if(count >= 0) {
            this.totalSold += count;
            allSales += count;
        }
    }

    @Override
    public String toString() {
        return "BurgerStall(id = %s)".formatted(id);
    }
}
