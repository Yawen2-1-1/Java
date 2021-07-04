package P2P;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private LoanCase loanCase;
    private LoanCaseQuery loanCaseQuery;

    public void printMenu(String account) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("功能選單：\n1. 有息借款\n2. 無息借款\n3. 單筆案件查詢\n選擇功能：");
        try {
            int choice = scanner.nextInt();

            String applicationID;
            String borrower;
            int amount;
            String purpose;
            String repaymentMethod;
            float interest;
            int repaymentDay;

            switch (choice) {
                case 1: // 有息借款
                    System.out.println("\n填寫申請單資料：");
                    System.out.print("借款人：");
                    borrower = scanner.next();
                    System.out.print("借款金額：");
                    amount = scanner.nextInt();
                    System.out.print("借款目的：");
                    purpose = scanner.next();
                    System.out.print("匯款帳戶：");
                    repaymentMethod = scanner.next();
                    System.out.print("利率：");
                    interest = scanner.nextFloat();
                    System.out.print("還款日期：");
                    repaymentDay = scanner.nextInt();

                    loanCase = new LoanCaseWithInterest(account, borrower, amount, purpose,
                            repaymentMethod, interest, repaymentDay);
                    loanCase.InsertLoanCase();
                    break;
                case 2: // 無息借款
                    System.out.println("\n填寫申請單資料：");
                    System.out.print("借款人：");
                    borrower = scanner.next();
                    System.out.print("借款金額：");
                    amount = scanner.nextInt();
                    System.out.print("借款目的：");
                    purpose = scanner.next();
                    System.out.print("匯款帳戶：");
                    repaymentMethod = scanner.next();
                    System.out.print("還款日期：");
                    repaymentDay = scanner.nextInt();

                    loanCase = new LoanCaseWithoutInterest(account, borrower, amount, purpose,
                            repaymentMethod, repaymentDay);
                    loanCase.InsertLoanCase();
                    break;
                case 3: // 單筆案件查詢
                    System.out.print("案件編號：");
                    applicationID = scanner.next();

                    System.out.println("\n輸出申請單資料：");
                    loanCaseQuery = new LoanCaseQuery(applicationID);
                    loanCaseQuery.QueryLoanCase();
                    break;
                default:
                    System.out.println("指令錯誤：功能尚未開啟");
            }
        } catch (InputMismatchException e) {
            System.out.println("輸入錯誤：選擇功能只接受整數！");
        }
    }
}
