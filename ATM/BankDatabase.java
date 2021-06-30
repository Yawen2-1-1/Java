public class BankDatabase {
	private Account[] accounts;
	
    /* Constructor */
	public BankDatabase () {
		accounts = new Account[4];  // just 4 accounts for testing
		accounts[0] = new Account(111, 222, 5000,0,'A');
		accounts[1] = new Account(222, 333, 4000,0,'B');
		accounts[2] = new Account(333, 444, 3000,0,'C');
		accounts[3] = new Account(444, 555, 2000,0,'D');
	}

	/* Check if the account input from users is existed,
	   and if the pin is correct to the account */
	public boolean authenticateUser(int account, int pin) {
		for (Account i : accounts) {
			if (i.getAccountNumber() == account) {
				if (i.validatePIN(pin)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	/* Get the total balance of the account */
	public int getTotalBalance(int account) {
		for (Account i : accounts) {
			if (i.getAccountNumber() == account) {
				return i.getTotalBalance();
			}
		}

		return -1;
	}

	/* Get the credit level of the account */
	public char getCreditLevel(int account) {
		for (Account i : accounts) {
			if (i.getAccountNumber() == account) {
				return i.getCreditLevel();
			}
		}

		return 'n';
	}

	/* Get the debt of the account */
	public int getDebt(int account) {
		for (Account i : accounts) {
			if (i.getAccountNumber() == account) {
				return i.getDebt();
			}
		}

		return -1;
	}

	/* Set the total balance of the account after depositing */
	public void setTotalBalance(int account, int userBalance) {
		for (Account i : accounts) {
			if (i.getAccountNumber() == account) {
				i.setTotalBalance(userBalance);
			}
		}
	}

	/* Set the total balance of the account after withdrawing */
	public void setWithdrawal(int account, int userWithdrawal) {
		for (Account i : accounts) {
			if (i.getAccountNumber() == account) {
				i.setWithdrawal(userWithdrawal);
			}
		}
	}

	/* Set the debt of the account after loaning */
	public void setDebt(int account, int userDebt) {
		for (Account i : accounts) {
			if (i.getAccountNumber() == account) {
				i.setDebt(userDebt);
			}
		}
	}
}
