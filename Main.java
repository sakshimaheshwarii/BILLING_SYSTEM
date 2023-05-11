import java.util.*;

public class Main{
    
    static void billEnquiry() {
        System.out.println("---------Bill ENQUIRY---------");
        int balance=9876543;
        Scanner sc=new Scanner(System.in);
        System.out.print("Units Consumed: ");
        int units=sc.nextInt();
        double bill =units*0.75;

        if(bill<balance)
        {
            System.out.println("Dear Customer, please pay the "+bill+" before deadline.\n Thank You" );
        }
        else
        {
            System.out.println("You have insufficient balance to pay the "+bill);
        }

    }

    static void fine()
    {
        System.out.println("You will be fined if bill not paid before due date. And it will be accordingly the below details: \n 1. 10, \n 2. 15, \n 3. 25, \n 4. 45");
        Scanner sc = new Scanner(System.in);
        int bill=sc.nextInt();
        int days=sc.nextInt();
        switch (days)
        {
            case 1: System.out.println("After 10 days, you will have to pay "+ ((days*30)+ bill)); break;
            case 2: System.out.println("After 15 days, you will have to pay "+ ((days*50)+ bill)); break;
            case 3: System.out.println("After 25 days, you will have to pay "+ ((days*70)+ bill)); break;
            case 4: System.out.println("After 45 days, you will have to pay "+ ((days*120)+ bill)); break;
        }
    }

    static void login() {
        String savedUsername = "hello java";
        String savedPassword = "password";
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Login Page");
        System.out.println("(username and password are case sensitive)");

        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.println();

        System.out.print("Password: ");
        String password = sc.nextLine();
        System.out.println();

        if (username.equals(savedUsername) && password.equals(savedPassword))
        {
            System.out.println("Login Successful!");
            System.out.println("how may we help you?\n you want to know,\n 1. Bill enquiry,\n 2. \n 3. ");
            int num=sc.nextInt();
            switch(num)
            {
                case 1: billEnquiry();break;
            }
        }
        else
        { 
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    static void OpenAccount() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.println();

        System.out.print("Enter Mobile Number: ");
        String mobile_num = sc.nextLine();
        System.out.println("details saved.");
    }

    public static void main(String[] args) {
        System.out.println("Greetings from Bill Department");
        System.out.println("1. ARE YOU NEW HERE?\n2. EXISTING CUSTOMER?");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch (input) {
            case 1:
                OpenAccount();
                break;
            case 2:
                login();
                break;
        }
    }
}
