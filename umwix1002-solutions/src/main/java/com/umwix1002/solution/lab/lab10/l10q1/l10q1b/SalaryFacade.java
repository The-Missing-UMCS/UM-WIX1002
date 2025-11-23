package com.umwix1002.solution.lab.lab10.l10q1.l10q1b;

import com.umwix1002.solution.lab.util.AssertUtil;
import com.umwix1002.solution.lab.util.Cache;
import com.umwix1002.solution.lab.util.PropertiesUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.umwix1002.solution.lab.lab10.config.Constants.PROPERTY_FILE_PATH;

public class SalaryFacade {
    private static final Cache CACHE = new Cache();
    private static final Map<EmployeeTypeEnum, Function<Employee, Double>> HANDLERS = new HashMap<>();

    private static final String CONTRACT_STAFF_BASE = "contract_staff_base";
    private static final String CONTRACT_STAFF_BONUS = "contract_staff_bonus";
    private static final String TEMPORARY_STAFF_PAY_RATE = "temporary_staff_pay_rate";

    // For the future update, add more properties here
    static {
        CACHE.put(CONTRACT_STAFF_BASE, PropertiesUtil.read(PROPERTY_FILE_PATH, CONTRACT_STAFF_BASE));
        CACHE.put(CONTRACT_STAFF_BONUS, PropertiesUtil.read(PROPERTY_FILE_PATH, CONTRACT_STAFF_BONUS));
        CACHE.put(TEMPORARY_STAFF_PAY_RATE, PropertiesUtil.read(PROPERTY_FILE_PATH, TEMPORARY_STAFF_PAY_RATE));

        HANDLERS.put(EmployeeTypeEnum.PERMANENT, (employee) -> {
            PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
            return permanentEmployee.getCategory().getSalary();
        });
        HANDLERS.put(EmployeeTypeEnum.CONTRACT, (employee) -> {
            double totalSales = ((ContractStaff) employee).getTotalSales();
            double base = Double.parseDouble(CACHE.get(CONTRACT_STAFF_BASE));
            double bonus = Double.parseDouble(CACHE.get(CONTRACT_STAFF_BONUS));
            return base + totalSales * bonus;
        });
        HANDLERS.put(EmployeeTypeEnum.TEMPORARY, (employee) -> {
            double totalHours = ((TemporaryStaff) employee).getTotalHours();
            return totalHours * Double.parseDouble(CACHE.get(TEMPORARY_STAFF_PAY_RATE));
        });
    }

    public static double calculate(Employee employee) {
        Function<Employee, Double> algo = HANDLERS.get(employee.getEmployeeType());
        AssertUtil.isNotNull(algo, "Invalid employee type");
        return algo.apply(employee);
    }
}
