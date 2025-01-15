package com.umwix1002.solution.tutorial.Tutorial8.T8Q4;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardPayment extends Payment {
    private final static String PAYMENT_TYPE = "Credit Card Payment";
    String holderName;
    String cardType;
    LocalDate expirationDate;
    String validatonCode;

    CreditCardPayment(int amount, String name, String type, String date, String code) {
        super(amount);
        this.holderName = name;
        this.cardType = type;
        this.expirationDate = getDate(date);
        this.validatonCode = code;
    }

    public static LocalDate getDate(String date) {
        String dateFormat = "(?<day>[1-3]?[0-9])-(?<month>[1-3]?[0-9])-(?<year>(\\w){4})";
        Pattern pattern = Pattern.compile(dateFormat);
        Matcher matcher = pattern.matcher(date);

        if (matcher.matches()) {
            return LocalDate.of(
                Integer.parseInt(matcher.group("day")),
                Integer.parseInt(matcher.group("month")),
                Integer.parseInt(matcher.group("year")));
        }

        System.out.println("Not a valid date");
        return LocalDate.now();
    }

    @Override
    public void makePayment() {
        System.out.printf("%-15s:", PAYMENT_TYPE);
        super.makePayment();
    }

    public void setDate(String date) {
        this.expirationDate = getDate(date);
    }

}
