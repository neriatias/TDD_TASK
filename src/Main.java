public class Main {
    public static void main(String[] args) {
        FactoryEmployee  employee_arr = new FactoryEmployee();
        long startTime = System.currentTimeMillis(); // start time
        employee_arr.employees = FactoryEmployee.quickSort(employee_arr.employees,0,employee_arr.employees.length-1);
        long endTime = System.currentTimeMillis(); // end time
        long duration = endTime - startTime;
        employee_arr.toStr();
        System.out.println("Time taken for the sort: " + duration + " milliseconds");

    }
}
