/** Main.java
 * @author Felipa Mendez
 * @author Peilian Song
 */
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        HashTable<Customer> customers = new HashTable<>(10);
        HashTable<Employee> employees = new HashTable<>(10);

        ///////////// USER LOGIN PRINT OUTS ////////////////
        //dummy users for testing
        customers.add(new Customer("Alicia", "Smith", "alicia@email.com", "1234", 
            "123 Main St", "San Jose", "CA", "95112"));
        employees.add(new Employee("Bobby", "Jones", "bobby@email.com", "abcd", true));

        Scanner input = new Scanner(System.in);

        int choice = 0;

        while (choice != 4) { 
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Continue as Guest");
            System.out.println("4. Quit");
            System.out.print("Enter choice: ");

            
            choice = input.nextInt();
            input.nextLine();

            //lets use 3 differend methods to separate the employee, guest, and customer menu options
            //print out 3 files one for customer.txt, employee.txt, manager.txt or something

            if (choice == 1) { 
                login(customers, employees, input);
            } else if (choice == 2) { //create an account 
                //make sure to add new account to file! - added to hashtable - tostring - we will print the hashtable with printWriter
                createAccount(customers, input);
            } else if (choice == 3) { //guest menu options
                System.out.println("\nLogged in as Guest.");
                guestInterface();
                
            } else if (choice == 4) {
                System.out.println("Exiting program...");

            } else {
                System.out.println("Invalid choice. Try again.");
            }

        }

        input.close();

    }

    /** login
     * 
     */
    public static void login(HashTable<Customer> customers, HashTable<Employee> employees, Scanner input) {

        System.out.print("Enter username: ");
        String username = input.nextLine(); 

        System.out.print("Enter password: ");
        String password = input.nextLine();

        Customer tempCustomer = new Customer("", "", username, password, "", "", "", "");
        Employee tempEmployee = new Employee("", "", username, password, false);

        Customer foundCustomer = customers.get(tempCustomer);
        Employee foundEmployee = employees.get(tempEmployee);

        if (foundCustomer != null && foundCustomer.passwordMatch(password)) {
            System.out.println("Customer login successful!");
            System.out.println(foundCustomer);

        } else if (foundEmployee != null && foundEmployee.passwordMatch(password)) {
            System.out.println("Employee login successful!");
            System.out.println(foundEmployee);

        } else {
            System.out.println("Invalid username or password.");
        }
    }

    /** createAccount
     * 
     */
    public static void createAccount(HashTable<Customer> customerTable, Scanner input) {

        System.out.print("Enter Username: ");
        String username = input.nextLine();

        System.out.print("Please Enter Your Password: ");
        String password = input.nextLine();

        System.out.print("Please Enter Your Firstname: ");
        String firstname = input.nextLine();

        System.out.print("Please Enter Your Lastname: ");
        String lastname = input.nextLine();

        Customer searchKey = new Customer(firstname, lastname, username, password, "", "", "", "");

        int bucketIndex = customerTable.find(searchKey);
        if (bucketIndex != -1) {
            System.out.println("User already exists! Please login with " + username + ".");
            return;
        }

        System.out.print("Please Enter Your Address: ");
        String address = input.nextLine();
        System.out.print("Please Enter Your City: ");
        String city = input.nextLine();
        System.out.print("Please Enter Your State: ");
        String state = input.nextLine();
        System.out.print("Please Enter Your ZIP: ");
        String zip = input.nextLine();

        Customer newCustomer = new Customer(firstname, lastname, username, password, 
            address, city, state, zip);
        customerTable.add(newCustomer);

        System.out.println("Account created successfully! You can now login.");
    }

    /** customerInterface
     * 
     */
    public static void customerInterface() {
        // - Search for a product
            // - Find and display one record using the primary key (BST search - updated to return the value instead of a boolean)
            // - Find and display one record using the secondary key (BST search - updated to return the value instead of a boolean)

        // - List Database of Products
            // - List data sorted by primary key (BST display)
            // - List data sorted by secondary key (BST display)

        // - Place an Order (add a new Order to the heap)
            // - Overnight Shipping
            // - Rush Shipping
            // - Standard Shipping

        // - View Purchases
            // - View shipped orders (LinkedList display)
            // - View unshipped orders (LinkedList display)
            // - Quit and Write to file(s) (update file(s) to reflect customer and order info changes) 
    }

    /** guestInterface
     * 
     */
    public static void guestInterface() {
        
        
    }

    /** employeeInterface
     * 
     */
    public static void employeeInterface() {

        
    }

    /** managerInterface
     * 
     */
    public static void managerInterface() {

        
    }

    




}