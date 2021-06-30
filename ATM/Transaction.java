import java.io.IOException;

public abstract class Transaction {
	private int accountNumber;
	private BankDatabase bankDatabase;
	private Screen screen;

	/*
	 * Constructor: initialize the three common variables in four derived class
	 * (BalanceInquiry, Withdrawal, Deposit, Loan)
	 */
    public Transaction(int account, BankDatabase bankDatabase, Screen screen) {
        this.accountNumber = account;
        this.bankDatabase = bankDatabase;
        this.screen = screen;
    }

    /* Get the account number */
    public int getAccountNumber() {
        return accountNumber;
    }

    /* Get the data of bank database */
    public BankDatabase getBankDatabase() {
        return bankDatabase;
    }

    /* Get the method of screen */
    public Screen getScreen() {
        return screen;
    }

    /* Class BalanceInquiry, Withdrawal, Deposit, Loan must extend it in order to use it */
    public abstract void execute() throws IOException;
}
