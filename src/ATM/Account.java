package ATM;

public interface Account {
    void checkBalance();

    void deposit(int amount);

    void withdraw(int amount);
}
