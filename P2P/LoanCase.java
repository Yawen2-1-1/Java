package P2P;

import java.util.Random;

public abstract class LoanCase {
    private String account;
    private String applicationID;
    private String borrower;
    private int amount;
    private String purpose;
    private String repaymentMethod;
    private int repaymentDay;

    public LoanCase (String account, String borrower, int amount, String purpose,
                     String repaymentMethod, int repaymentDay) {
        this.account = account;
        this.applicationID = getApplicationID();
        this.borrower = borrower;
        this.amount = amount;
        this.purpose = purpose;
        this.repaymentMethod = repaymentMethod;
        this.repaymentDay = repaymentDay;
    }

    public abstract void InsertLoanCase ();

    // 以亂數產生申請單編號
    public void setApplicationID () {
        Random random = new Random();
        String caseNo = Integer.toString(random.nextInt(100) + 1000);
        this.applicationID = this.account + "_" + caseNo;
    }

    public String getApplicationID () {
        setApplicationID();
        return this.applicationID;
    }

    public String getAccount() {
        return this.account;
    }

    public String getBorrower() {
        return this.borrower;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public String getRepaymentMethod() {
        return this.repaymentMethod;
    }

    public int getRepaymentDay() {
        return this.repaymentDay;
    }
}
