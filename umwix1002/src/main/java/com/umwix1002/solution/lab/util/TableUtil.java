package com.umwix1002.solution.lab.util;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestLine;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.text.WordUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.umwix1002.solution.lab.constants.CommonConstant.BLANK;

/**
 * Utility class for printing tables in a formatted manner using ASCII art.
 * It also includes methods for extracting data from objects and converting headers to field names.
 */
public class TableUtil {

    /**
     * Prints a table using the provided headers and data rows.
     *
     * @param headers  Array of column headers.
     * @param dataList List of data rows, where each row is an array of strings.
     */
    public static void printTableWithData(String[] headers, List<String[]> dataList) {
        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow((Object[]) headers);
        table.addRule();

        for (String[] data : dataList) {
            table.addRow((Object[]) data);
            table.addRule();
        }

        table.getRenderer().setCWC(new CWC_LongestLine());
        System.out.println(table.render());
    }

    /**
     * Prints a table using the provided headers and a list of raw objects.
     * The object data is dynamically extracted based on the headers.
     *
     * @param headers  Array of column headers.
     * @param dataList List of raw objects to be converted into table rows.
     * @param <T>      The type of objects in the dataList.
     */
    public static <T> void printTableWithRawData(String[] headers, List<T> dataList) {
        printTableWithData(headers, getDataList(headers, dataList));
    }

    /**
     * Converts a list of objects into a list of string arrays based on the provided headers.
     * Each string array corresponds to a row in the table.
     *
     * @param headers    Array of column headers.
     * @param objectList List of objects to extract data from.
     * @param <T>        The type of objects in the objectList.
     * @return A list of string arrays representing table rows.
     * @throws IllegalArgumentException if headers or objectList is null or empty.
     */
    public static <T> List<String[]> getDataList(String[] headers, List<T> objectList) {
        Validate.notEmpty(headers, "Headers cannot be null or empty");
        Validate.notEmpty(objectList, "Object list cannot be null or empty");

        return objectList.stream()
                .map(object -> Stream.of(headers)
                        .map(header -> getFieldValue(object, toFieldName(header)))
                        .toArray(String[]::new))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the value of a specified field from an object.
     *
     * @param object    The object from which to retrieve the field value.
     * @param fieldName The name of the field to retrieve.
     * @return The string value of the field, or a blank string if the value is null.
     * @throws RuntimeException if the field cannot be accessed.
     */
    private static String getFieldValue(Object object, String fieldName) {
        try {
            Object value = PropertyUtils.getProperty(object, fieldName);
            return Objects.nonNull(value) ? value.toString() : BLANK;
        } catch (Exception e) {
            throw new RuntimeException("Error accessing property '" + fieldName + "' on object: " + object, e);
        }
    }

    /**
     * Converts a header name into a camelCase field name.
     * Example: "Course Code" becomes "courseCode".
     *
     * @param header The header name to convert.
     * @return The corresponding field name in camelCase.
     */
    private static String toFieldName(String header) {
        String fieldName = WordUtils.capitalizeFully(header).replace(" ", "");
        return WordUtils.uncapitalize(fieldName);
    }
}
