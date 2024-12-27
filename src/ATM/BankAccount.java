package ATM;

public class BankAccount implements Account {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    @Override
    public void checkBalance() {
        System.out.printf("Available balance TK: %d%n", balance);
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else {
            balance += amount;
            System.out.printf("Sucecssfully deposited TK: %d%nAvailable balance TK: %d%n", amount, balance);
        }
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.printf("Successfully withdrew TK: %d%nAvailable balance TK: %d%n", amount, balance);
        }
    }


    public int getBalance() {
        return balance;
    }


    protected void setBalance(int balance) {
        this.balance = balance;
    }
}
