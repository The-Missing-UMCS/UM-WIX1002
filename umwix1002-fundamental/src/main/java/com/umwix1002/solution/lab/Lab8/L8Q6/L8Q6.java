package com.umwix1002.solution.lab.Lab8.L8Q6;

public class L8Q6 {
    public static void main(String[] args) {
        BurgerStall stall_one = new BurgerStall("A001");
        BurgerStall stall_two = new BurgerStall("A002");
        stall_one.sold(100);
        System.out.println(stall_one + " total Sales = " + stall_one.getTotalSold());
        System.out.println("All sales = " + BurgerStall.getAllSales());
        stall_two.sold(230);
        System.out.println(stall_two + " total Sales = " + stall_two.getTotalSold());
        System.out.println("All sales = " + BurgerStall.getAllSales());
    }
}