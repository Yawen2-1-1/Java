package P2P;

public class Login {
    /* 選擇 1. 登入 */
    private String account;
    private String password;
    DBMember dbMember = new DBMember();

    public Login(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public boolean IfLogin() {
        // 連結資料庫比對帳號密碼，確定為會員之後將變數 iflogin 從 false 賦值為 true
        boolean iflogin = false;
        if (dbMember.Connection(account, dbMember.SHA256_Password(password), 0, "")) {
            iflogin = true;
        } else {
            System.out.println("Login failed!");
        }

        return iflogin;
    }
}
