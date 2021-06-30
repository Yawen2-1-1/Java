public class Account {
	private int accountNumber;
	private int pin;
	private int totalBalance;
	private int debt;
	private char creditLevel;

	/* Constructor */
	public Account(int accountNumber, int pin, int totalBalance, int debt, char creditLevel) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.totalBalance = totalBalance;
        this.debt = debt;
        this.creditLevel = creditLevel;
    }

    /* Check if the pin is correct to the account */
    public boolean validatePIN(int userPin) {
        if (pin == userPin)
            return true;
        return false;
    }

    /* Get the account number */
    public int getAccountNumber() {
        return accountNumber;
    }

    /* Get the total balance of the account */
    public int getTotalBalance() {
        return totalBalance;
    }

    /* Get the credit level of the account */
    public char getCreditLevel() {
        return creditLevel;
    }

    /* Get the debt of the account */
    public int getDebt() {
        return debt;
    }

    /* Set the total balance of the account after depositing */
    public void setTotalBalance(int userBalance) {
        totalBalance += userBalance;
    }

    /* Set the total balance of the account after withdrawing */
    public void setWithdrawal(int userWithdrawal) {
	    totalBalance -= userWithdrawal;
    }

    /* Set the debt of the account after loaning */
    public void setDebt(int userDebt) {
        debt += userDebt;
    }
}
