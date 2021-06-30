public class BalanceInquiry extends Transaction{
    /* Constructor */
    public BalanceInquiry (int account, BankDatabase bankDatabase, Screen screen) {
        super(account, bankDatabase, screen);
    }

    /* Show the balance information of the account */
	public void execute() {
        getScreen().displayMessageLine("Balance information");
        getScreen().displayMessage("Total balance : " +
                getBankDatabase().getTotalBalance(getAccountNumber()) + "\n");
    }
}
