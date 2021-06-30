import java.io.IOException;

public class ATM {
	private boolean userAuthenticated;
	private BankDatabase bankDatabase;
	private Screen screen;
	private Keypad keypad;
	private Transaction transaction;

	/* Constructor */
	public ATM() {
	    userAuthenticated = false;
	    bankDatabase = new BankDatabase();
	    screen = new Screen();
	    keypad = new Keypad();
    }

	public void run() throws IOException {

        while (true) {
            screen.displayMessageLine("\nWelcome!");
            screen.displayMessage("Please enter your account number : ");

            // Input account number and check
            int account = keypad.getInput();
            if (account < 0) {
                screen.displayMessageLine("Error input: account number should be positive.");
                continue;
            }

            // Input pin number and check
            screen.displayMessage("Please enter your pin : ");
            int pin = keypad.getInput();
            if (pin < 0) {
                screen.displayMessageLine("Error input: pin number should be positive.");
                continue;
            }

            // Check if the account is existed, and if the pin is correct to the account
            userAuthenticated = bankDatabase.authenticateUser(account, pin);

            if (userAuthenticated == false) {
                screen.displayMessageLine("AccountNumber or Pin Error\n");
                continue;
            } else {
                // Main menu
                screen.displayMessageLine("\nMain_menu :\n" + "1. View my balance\n" +
                        "2. Withdraw\n" + "3. Deposit\n" + "4. Loan\n" + "5. Exit");
                screen.displayMessage("Enter a choice : ");

                // Input a choice and run the system unless option is 5
                int option = keypad.getInput();
                while (option != 5) {
                    switch(option) {
                        // Show the message about balance
                        case 1:
                            transaction = new BalanceInquiry(account, bankDatabase, screen);
                            transaction.execute();
                            break;
                        // Input the amount of money to withdrawal and deduct from balance
                        case 2:
                            transaction = new Withdrawal(account, bankDatabase, keypad, screen);
                            transaction.execute();
                            break;
                        // Input the amount of money to deposit and recalculate the balance
                        case 3:
                            transaction = new Deposit(account, bankDatabase, keypad, screen);
                            transaction.execute();
                            break;
                        // Show the debt, and input the amount of loan after checking the credit level
                        case 4:
                            transaction = new Loan(account, bankDatabase, keypad, screen);
                            transaction.execute();
                            break;
                        // Log out the account but not shutdown the system
                        case 5:
                            screen.displayMessageLine("Logout.");
                            break;
                        // If users input wrong instructions, show the error message
                        default:
                            screen.displayMessageLine("Error input: legal instructors are only 1 ~ 5");
                            break;
                    }

                    // Restart from the main menu
                    screen.displayMessageLine("\nMain_menu :\n" + "1. View my balance\n" +
                            "2. Withdraw\n" + "3. Deposit\n" + "4. Loan\n" + "5. Exit");
                    screen.displayMessage("Enter a choice : ");
                    option = keypad.getInput();
                }
            }
        }
	}
}
