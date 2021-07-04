package P2P;

public class LoanCaseWithInterest extends LoanCase {
    private int totalRepayment;
    private float interest;

    public LoanCaseWithInterest(String account, String borrower, int amount, String purpose,
                                String repaymentMethod, float interest, int repaymentDay) {
        super(account, borrower, amount, purpose, repaymentMethod, repaymentDay);
        this.interest = interest;
        this.totalRepayment = (int) Math.ceil(((float) amount * interest));
    }

    public void InsertLoanCase () {
        String applicaionID = getApplicationID();// 因為是亂數產生編號，必須用一個變數去記憶，否則每次都不同
        String statement = "insert into `t_application` (ApplicationID, Borrower, Amount, " +
                "PurposeforLoan, TotalRepaymentAmount, RepaymentMethod, MemberAccount) " +
                "values ('" + applicaionID + "', '" + getBorrower() + "', " + getAmount() + ", '" +
                getPurpose() + "', " + totalRepayment + ", '" + getRepaymentMethod() + "', '" +
                getAccount() + "')";
        DBLoan dbLoan = getDbLoan();
        if (dbLoan.LoanCaseOperation(applicaionID, statement, 1)) {
            System.out.println("\n新增有息借款案件成功！");
        } else {
            System.out.println("\n新增有息借款案件失敗！");
        }

        statement = "insert into `t_loancaseinfo` (CaseNo, Interest, RepaymentDate, LoanDate) " +
                "values ('" + applicaionID + "', " + interest + ", " +
                getRepaymentDay() + ", '" + dbLoan.getLoanDate() + "')";
        if (dbLoan.LoanCaseOperation(applicaionID, statement, 2)) {
            System.out.println("新增有息借款案件資訊成功！");
        } else {
            System.out.println("\n新增有息借款案件資訊失敗！");
        }
    }
}
