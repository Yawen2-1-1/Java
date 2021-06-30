package P2P;

public class Register {
    /* 選擇 2. 註冊 */
    private String account;
    private String password;
    private String name;
    private String contact;
    private boolean ifregister;

    public Register(String account, String password, String name, String contact) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.contact = contact;
        this.ifregister = false;
    }

    public boolean IfRegister() {
        DBMember dbMember = new DBMember();
        password = dbMember.SHA256_Password(this.password);
        String statement = "insert into `t_member_data` (MemberAccount, " +
                "MemberPassword, MemberName, ContactMethod) values('" + this.account + "', '" +
                this.password + "', '" + this.name + "', '" + this.contact + "')";

        // 連結資料庫比對帳號密碼，確定註冊為會員之後將變數 ifregister 從 false 賦值為 true
        if (dbMember.Connection(this.account, this.password,1, statement)) {
            System.out.println("Register successfully!");
            ifregister = true;
        } else {
            System.out.println("Register failed!");
        }

        return ifregister;
    }

    public String getName() {
        return this.name;
    }
}
