package P2P;

public class DBConnect {
    static String driver = null;
    static String host = null;
    static String uName = null;
    static String uPass = null;

    public DBConnect() {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.host = "jdbc:mysql://localhost:3306/p2p"; // 選擇需要操作的資料庫
        this.uName = ""; // 管理者帳號
        this.uPass = ""; // 管理者密碼
    }
}
