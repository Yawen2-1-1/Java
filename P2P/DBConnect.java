package P2P;

public class DBConnect {
    static String driver = null;
    static String host = null; // 選擇需要操作的資料庫
    static String uName = null;
    static String uPass = null;

    public DBConnect() {
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.host = "jdbc:mysql://localhost:3306/p2p";
        this.uName = "root";
        this.uPass = "rootroot";
    }
}
