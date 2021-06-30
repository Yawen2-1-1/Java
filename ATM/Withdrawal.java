public class Withdrawal extends Transaction {
    private Keypad keypad;
    private int money;

    /* Constructor */
    public Withdrawal(int account, BankDatabase bankDatabase, Keypad keypad, Screen screen) {
        super(account, bankDatabase, screen);
        this.keypad = keypad;
        money = 0;
    }

    /* Input the amount of money to withdraw, and show the message of transaction */
    public void execute() throws NumberFormatException {
        getScreen().displayMessage("How much do you want to withdraw : ");
        money = keypad.getInput();

        if (money < 0) {
            getScreen().displayMessageLine("Error input: number of money should be positive.");
        } else if (money > getBankDatabase().getTotalBalance(getAccountNumber())) {
            getScreen().displayMessageLine("Warning: you have over-withdrawn!!");
        } else {
            getBankDatabase().setWithdrawal(getAccountNumber(), money);
            getScreen().displayMessageLine("Transaction Success.");
        }
    }
}
