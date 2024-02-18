import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
public class Employee_Tests {
    @Test
    public void SortedArrTest() {
        FactoryEmployee  employee_arr = new FactoryEmployee();
        //employee_arr.employees = bubbleSort(employee_arr.employees)
        employee_arr.employees = FactoryEmployee.quickSort(employee_arr.employees,0,employee_arr.employees.length-1);
        assertNotNull(employee_arr.employees);
        assertEquals(10000, employee_arr.employees.length);
        for (int i = 0; i <employee_arr.employees.length - 1; i++) {
            assertTrue(employee_arr.employees[i].getSalary() <= employee_arr.employees[i + 1].getSalary());
        }
        employee_arr.employees.toString();
    }
}
