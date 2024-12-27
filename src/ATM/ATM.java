package ATM;

import java.util.Scanner;

public class ATM {
    private static final String PIN = "4969";

    private static Account account;

    private static boolean authenticate(Scanner scanner) {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            String enteredPin = scanner.next();
            if (enteredPin.equals(PIN)) {
                System.out.println("Authentication successful.");
                return true;
            } else {
                System.out.println("Invalid PIN. Please try again.");
                attempts++;
            }
        }
        return false;
    }

    private static void menu() {
        System.out.println("\nATM Machine Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!authenticate(scanner)) {
            System.out.println("Too many incorrect attempts.");
            scanner.close();
            System.exit(0);
        }

        int option;
        System.out.print("Enter initial balance: ");
        int initialBalance = scanner.nextInt();

        if (initialBalance >= 0) {
            account = new BankAccount(initialBalance);
        } else {
            account = new CheckingAccount(initialBalance);
        }

        while (true) {
            menu();
            System.out.print("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount: ");
                    int depositAmount = scanner.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount: ");
                    int withdrawAmount = scanner.nextInt();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Successfully Exit. Thank you for using our ATM");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
//program ends here