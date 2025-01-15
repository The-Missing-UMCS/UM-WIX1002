package com.umwix1002.solution.lab.lab8.l8q6;

import com.umwix1002.solution.lab.util.AssertUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @author Ng Zhi Yang
 */
@Data
public class BurgerStall {
    @Getter
    private static int allSales;
    
    private String id;
    private int totalSold;
    
    public BurgerStall(String id) {
        this.id = id;
    }

    public void sold(int count) {
        AssertUtil.assertNonNegative(count);
        this.totalSold += count;
        allSales += count;
    }
}
