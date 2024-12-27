package ATM;

public class CheckingAccount extends BankAccount {
    private static final int OVERDRAFT_LIMIT = -100;

    public CheckingAccount(int balance) {
        super(balance);
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > (getBalance() - OVERDRAFT_LIMIT)) {
            System.out.println("Withdrawal amount exceeds overdraft limit.");
        } else {
            setBalance(getBalance() - amount);
            System.out.printf("Successfully withdrew TK: %d%nAvailable balance TK: %d%n", amount, getBalance());
        }
    }
}
