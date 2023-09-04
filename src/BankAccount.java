import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawn $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean createNewAccount = true;

        while (createNewAccount) {


            System.out.print("Enter your account number: ");
            String accountNumber = scanner.nextLine();

            System.out.print("Enter your initial balance: ");
            double initialBalance = scanner.nextDouble();

            BankAccount myAccount = new BankAccount(accountNumber, initialBalance);

            boolean continueTransactions = true;
            while (continueTransactions) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        myAccount.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter the withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        myAccount.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.println("Current balance: $" + myAccount.getBalance());
                        break;
                    case 4:
                        System.out.println("Exiting the program.");
                        continueTransactions = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
            System.out.print("Do you want to create another account? (yes/no): ");
            String response = scanner.next();
            createNewAccount = response.equalsIgnoreCase("yes");
            scanner.nextLine();
        }
        scanner.close();
    }
}

