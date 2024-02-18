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

    public Employee() {
        id = generateRandomId();
        String name = generateRandomName();
        String[] nameParts = name.split(" ");
        firstName = nameParts[0];
        lastName = nameParts[1];
        email = generateRandomEmail(firstName, lastName);
        phone = generateRandomPhone();
        address = generateRandomAddress();
        salary = generateRandomSalary();
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


}