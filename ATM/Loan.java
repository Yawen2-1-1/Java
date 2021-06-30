public class Loan extends Transaction {
    private Keypad keypad;
    private int money;

    /* Constructor */
    public Loan(int account, BankDatabase bankDatabase, Keypad keypad, Screen screen) {
        super(account, bankDatabase, screen);
        this.keypad = keypad;
        money = 0;
    }

    /*
     * First, check the loan limit of the account;
     * Second, input the amount of money to loan;
     * Finally, show the message of transaction
     */
    public void execute() throws NumberFormatException {
        int limit = 0;
        getScreen().displayMessage("Your debt : " + getBankDatabase().getDebt(getAccountNumber()) + "\n");
        switch (getBankDatabase().getCreditLevel(getAccountNumber())) {
            case 'A':
                limit = 11000;
                break;
            case 'B':
                limit = 9000;
                break;
            case 'C':
                limit = 7000;
                break;
            case 'D':
                limit = 5000;
                break;
        }

        int remain = limit - getBankDatabase().getDebt(getAccountNumber());
        if (remain == 0) {
            getScreen().displayMessageLine("Sorry, You can not loan any money now.");
        } else {
            getScreen().displayMessage("Your loan limit is " + limit);
            getScreen().displayMessage(", How much do you want to loan : ");
            money = keypad.getInput();

            if (money < 0) {
                getScreen().displayMessageLine("Error input: number of money should be positive.");
            } else if (money > remain) {
                getScreen().displayMessageLine("Transaction Error, You have not much Loan Limit");
            } else {
                getBankDatabase().setDebt(getAccountNumber(), money);
                getScreen().displayMessageLine("Transaction Success");
            }
        }
    }
}
