import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
public class Employee_Tests {
    @Test
    public void SortedArrTest() {
        FactoryEmployee  employee_arr = new FactoryEmployee();
        long startTime = System.currentTimeMillis(); // start time
        //employee_arr.employees = bubbleSort(employee_arr.employees)
        employee_arr.employees = FactoryEmployee.quickSort(employee_arr.employees,0,employee_arr.employees.length-1);
        long endTime = System.currentTimeMillis(); // end time
        long duration = endTime - startTime;

        assertNotNull(employee_arr.employees); //Checking whether the function returns any value
        assertEquals(10000, employee_arr.employees.length); //Checking whether the array has lost records
        for (int i = 0; i <employee_arr.employees.length - 1; i++) {
            assertTrue(employee_arr.employees[i].getSalary() <= employee_arr.employees[i + 1].getSalary()); //Checking whether the array is sorted
        }
        employee_arr.toStr();
        System.out.println("Time taken for the sort: " + duration + " milliseconds");

    }
}
