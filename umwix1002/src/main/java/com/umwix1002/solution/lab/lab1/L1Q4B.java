package com.umwix1002.solution.lab.lab1;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ng Zhi Yang
 */
public class L1Q4B {
    public static void main(String[] args) {
        CategoryChart chart = new CategoryChartBuilder().title("Monthly Data").xAxisTitle("Month").yAxisTitle("Values").build();
        double[] data = new double[] { 2500, 1700, 2000, 2700, 3200, 700 };
        List<String> months = Arrays.stream(Month.values()).limit(data.length).map(Month::toString).toList(); 
        List<Double> values = Arrays.stream(data).boxed().toList();
        chart.addSeries("Monthly Values", months, values);
        new SwingWrapper<>(chart).displayChart();
    }
}
