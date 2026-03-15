import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String username;
        String password;
        HashTable<Customer> customers = new HashTable<>(10);
        HashTable<Employee> employees = new HashTable<>(10);

        ///////////// USER LOGIN PRINT OUTS ////////////////
        //dummy users for testing
        customers.add(new Customer("Alice", "Smith", "alice@email.com", "1234", 
            "123 Main St", "San Jose", "CA", "95112"));
        employees.add(new Employee("Bob", "Jones", "bob@email.com", "abcd", true));

        Scanner input = new Scanner(System.in);

        System.out.println("1. Login");
        System.out.println("2. Create Account");
        System.out.print("Enter choice: ");

        int choice = input.nextInt();
        input.nextLine();

        //lets use 3 differend methods to separate the employee, guest, and customer menu options

        if (choice == 1) { 
            login(customers, employees, input);
        } else if (choice == 2) {
            //create an account
        } else if (choice == 3) {
            System.out.println("\nLogged in as Guest.");
            //guest menu options
        }

    }

    public static void login(HashTable<Customer> customers, HashTable<Employee> employees, Scanner input) {

        System.out.print("Enter email: ");
        String email = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        Customer tempCustomer = new Customer("", "", email, password, "", "", "", "");
        Employee tempEmployee = new Employee("", "", email, password, false);

        Customer foundCustomer = customers.get(tempCustomer);
        Employee foundEmployee = employees.get(tempEmployee);

        if (foundCustomer != null && foundCustomer.passwordMatch(password)) {
            System.out.println("Customer login successful!");
            System.out.println(foundCustomer);

        } else if (foundEmployee != null && foundEmployee.passwordMatch(password)) {
            System.out.println("Employee login successful!");
            System.out.println(foundEmployee);

        } else {
            System.out.println("Invalid email or password.");
        }
    }

    




}