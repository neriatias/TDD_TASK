import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
public class Employee_Tests {
    FactoryEmployee  employee_arr = new FactoryEmployee();


    @Test
    public void ReturnValueTest() {
        // Test if the array is not null
        assertNotNull(employee_arr.employees);
    }

    @Test
    public void NoLossTest() {
        // Test if all records exist in the array
        assertEquals(10000, employee_arr.employees.length);
    }

    @Test
    public void SortedArrTest() {
        //employee_arr.employees = bubbleSort(employee_arr.employees)
        employee_arr.employees = FactoryEmployee.quickSort(employee_arr.employees,0,employee_arr.employees.length-1);
        for (int i = 0; i <employee_arr.employees.length - 1; i++) {
            // Using JUnit assertion to check if the array is sorted
            assertTrue(employee_arr.employees[i].getSalary() <= employee_arr.employees[i + 1].getSalary());
        }
    }
}
