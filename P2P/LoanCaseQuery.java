package P2P;

public class LoanCaseQuery {
    private String applicationID;

    public LoanCaseQuery(String applicationID) {
        this.applicationID = applicationID;
    }

    public void QueryLoanCase() {
        //String statement = "select * from `t_application` " +
        //        "where `t_application`.ApplicationID = '" + getApplicationID() + "'";
        DBLoan dbLoan = new DBLoan();
        if (dbLoan.LoanCaseOperation(getApplicationID(), null, 3)) {
            System.out.println("借款案件資訊輸出完畢！");
        } else {
            System.out.println("借款案件資訊不存在！");
        }
    }

    public String getApplicationID() {
        return this.applicationID;
    }
}
