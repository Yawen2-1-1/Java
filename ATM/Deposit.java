public class Deposit extends Transaction {
    private Keypad keypad;
    private int money;

    /* Constructor */
    public Deposit(int account, BankDatabase bankDatabase, Keypad keypad, Screen screen) {
        super(account, bankDatabase, screen);
        this.keypad = keypad;
        money = 0;
    }

    /* Input the amount of money to deposit, and show the message of transaction */
    public void execute() throws NumberFormatException {
        getScreen().displayMessage("How much do you want to deposit : ");
        money = keypad.getInput();

        if (money < 0) {
            getScreen().displayMessageLine("Error input : number of money should be positive.");
        } else {
            getBankDatabase().setTotalBalance(getAccountNumber(), money);
            getScreen().displayMessageLine("Transaction Success.");
        }
    }
}
