import java.util.*;

class Customer {
    private String username;
    private String password;
    private String name;
    private String mobileNumber;
    private double balance;

    public Customer(String username, String password, String name, String mobileNumber, double balance) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.balance = balance;
    }

    // Getters and setters
    // ...

    // Method to perform bill enquiry
    public void billEnquiry(int unitsConsumed) {
        System.out.println("---------Bill ENQUIRY---------");
        double bill = unitsConsumed * 0.75;

        if (bill <= balance) {
            System.out.println("Dear Customer, please pay the " + bill + " before the deadline.\nThank You");
        } else {
            System.out.println("You have insufficient balance to pay the bill.");
        }
    }

    // Method to calculate fine
    public void calculateFine(int bill, int days) {
        System.out.println("You will be fined if the bill is not paid before the due date.");
        double fineAmount = 0;

        switch (days) {
            case 1:
                fineAmount = days * 10;
                break;
            case 2:
                fineAmount = days * 15;
                break;
            case 3:
                fineAmount = days * 25;
                break;
            case 4:
                fineAmount = days * 45;
                break;
        }

        double totalAmount = bill + fineAmount;
        System.out.println("After " + days + " days, you will have to pay " + totalAmount);
    }
}

public class Main {
    private static Map<String, Customer> customers = new HashMap<>();

    // Method to perform login
    static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Login Page");
        System.out.println("(username and password are case sensitive)");

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        Customer customer = customers.get(username);
        if (customer != null && customer.getPassword().equals(password)) {
            System.out.println("Login Successful!");
            System.out.println("How may we help you?");
            System.out.println("You want to know:");
            System.out.println("1. Bill enquiry");
            System.out.println("2. Calculate fine");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter units consumed: ");
                    int units = sc.nextInt();
                    customer.billEnquiry(units);
                    break;
                case 2:
                    System.out.print("Enter bill amount: ");
                    int bill = sc.nextInt();
                    System.out.print("Enter number of days past due date: ");
                    int days = sc.nextInt();
                    customer.calculateFine(bill, days);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    // Method to open a new account
    static void openAccount() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Mobile Number: ");
        String mobileNumber = sc.nextLine();

        System.out.println("Account created successfully.");
        customers.put(username, new Customer(username, password, name, mobileNumber, 9876543));
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("Greetings from Bill Department");
        System.out.println("1. New Customer\n2. Existing Customer?");

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        switch (input) {
            case 1:
                openAccount();
                break;
            case 2:
                login();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
