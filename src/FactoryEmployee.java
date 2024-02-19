import java.util.Arrays;

public class FactoryEmployee {

    Employee[] employees;

    public FactoryEmployee() {
        employees = new Employee[10000];
        for (int i = 0; i < 10000; i++) {
            Employee employee = new Employee();
            employees[i] = employee;
        }

    }

    //    public static void bubbleSort(Employee[] arr) {
//        int n = arr.length;
//        for (int i = 0; i < n-1; i++) {
//            for (int j = 0; j < n-i-1; j++) {
//                if (arr[j].getSalary() > arr[j+1].getSalary()) {
//                    Employee temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }


    //        bubbleSort(emp);
    //quickSort(employee_arr, 0, employee_arr.length - 1);

    public static Employee[] quickSort(Employee[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }

        return arr;
    }

    private static int partition(Employee[] arr, int low, int high) {
        double pivot = arr[high].getSalary();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].getSalary() < pivot) {
                i++;
                Employee temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Employee temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public void toStr() {
        for (int i = 0; i < employees.length; i++) {
            employees[i].toStr();
        }
    }
}

