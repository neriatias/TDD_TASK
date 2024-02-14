import java.util.Objects;
import java.util.Random;

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private int salary;
    private int count=0;

    public Employee(String id, String firstName, String lastName, String email, String phone, String address, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
        this.count++;
    }

    public static String generateRandomId() {
        Random random = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            id.append(random.nextInt(10));
        }
        return id.toString();
    }

    public static String generateRandomName() {
        String[] firstNames = {"John", "Jane", "Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};
        Random random = new Random();
        return firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
    }

    public static String generateRandomEmail(String firstName, String lastName) {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "company.com"};
        Random random = new Random();
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + domains[random.nextInt(domains.length)];
    }

    public static String generateRandomPhone() {
        Random random = new Random();
        return "+972-" + (500000000 + random.nextInt(100000000));
    }

    public static String generateRandomAddress() {
        String[] cities = {"Tel Aviv", "Jerusalem", "Haifa", "Beersheba", "Eilat", "Rishon LeZion", "Petah Tikva", "Ashdod", "Netanya", "Herzliya"};
        String[] streets = {"Main St.", "First St.", "Second St.", "Third St.", "Oak St.", "Park Ave.", "Elm St.", "Maple Ave.", "Washington St.", "Broadway"};
        Random random = new Random();
        return random.nextInt(100) + ", " + streets[random.nextInt(streets.length)] + ", " + cities[random.nextInt(cities.length)];
    }

    public static int generateRandomSalary() {
        Random random = new Random();
        return 3000 + random.nextInt(12000);
    }

    public int getSalary() {
        return this.salary;
    }


    public static void main(String[] args) {
        int[] salary_arr = new int[10000];
        Employee[] emp = new Employee[10000];

        for (int i = 0; i < 10000; i++) {
            String id = generateRandomId();
            String name = generateRandomName();
            String[] nameParts = name.split(" ");
            String firstName = nameParts[0];
            String lastName = nameParts[1];
            String email = generateRandomEmail(firstName, lastName);
            String phone = generateRandomPhone();
            String address = generateRandomAddress();
            int salary = generateRandomSalary();
            Employee employee = new Employee(id, firstName, lastName, email, phone, address, salary);
            emp[i] = employee;
        }
        long startTime = System.currentTimeMillis(); // זמן התחלתי

//        bubbleSort(emp);
        quickSort(emp, 0, emp.length - 1);

        long endTime = System.currentTimeMillis(); // זמן סיום

        long duration = endTime - startTime; // משך הזמן במילישניות

        System.out.println("Sorted array:");
        for (int i = 0; i < 10000; i++) {
            System.out.println(emp[i].toString());
        }


        System.out.println("\nTime taken for the sort: " + duration + " milliseconds");
        System.out.println("it's all good!");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
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
//    }

    public static void quickSort(Employee[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
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

}
