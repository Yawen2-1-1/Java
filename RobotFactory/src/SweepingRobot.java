import java.lang.reflect.Array;
import java.util.Random;

public class SweepingRobot implements Robot {

    private String name;
    private float height;
    private float width;
    private String company;
    
    public SweepingRobot(String name, float height, float width, String company) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.company = company;
    }
    
    @Override
    public void introduce() {
        System.out.println("\n機器人產品資料如下：");
        System.out.println("這是一台「" + getName() + "」，高：「" + getHeight() + "」公分，寬：「" + getWidth() + "」公分，由「 " 
                            + getCompany() + "」製造。");
    }
    
    public String getName() {
        return name;
    }
    
    public String getCompany() {
        return company;
    }
    
    public float getHeight() {
        height = (float) (Math.round(height * 100.0) / 100.0);
        return height;
    }
    
    public float getWidth() {
        width = (float) (Math.round(width * 100.0) / 100.0);
        return width;
    }
    
    @Override
    public int[][] doWork(int room, int item, int[][] roomArray) {
        // 入口點若放置貨物，則掃地機器人無法進入房間掃地
        if (roomArray[0][0] == 1) {
            for (int i = 0; i < room; i++) {
                for (int j = 0; j < room; j++) {
                    roomArray[i][j] = 0;
                }
            }
        } else {
            // 由左至右掃地
            for (int x = 0; x < room; x++) {
                for (int y = 0; y < room; y++) {
                    if (roomArray[x][y] == 0) {
                        roomArray[x][y] = 2;
                        if ((y + 1 < room) && (roomArray[x][y+1] == 1)) {
                            break;
                        }
                    }
                }
            }

            // 由上至下掃地
            for (int x = 1; x < room; x++) {
                for (int y = 0; y < room; y++) {
                    if ((roomArray[x][y] == 2) && (roomArray[x-1][y] == 0)) {
                        for (int up = (x-1); up >= 0; up--) {
                            if (roomArray[up][y] == 0) {
                                roomArray[up][y] = 2;
                                if ((up - 1 >= 0) && (roomArray[up-1][y] != 0)) {
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            // 清理因為貨物堆放而造成的不規則角落
            int count = 1;
            while (count <= 2) {
                for (int x = 0; x < room; x++) {
                    for (int y = 0; y < room; y++) {
                        // 當格的「左邊」有掃除痕跡，代表當格也可以進行掃除
                        if ((y - 1 >= 0) && (roomArray[x][y] == 0) && (roomArray[x][y-1] == 2)) {
                            roomArray[x][y] = 2;
                        }
                        // 當格的「右邊」有掃除痕跡，代表當格也可以進行掃除
                        if ((y + 1 < room) && (roomArray[x][y] == 0) && (roomArray[x][y+1] == 2)) {
                            roomArray[x][y] = 2;
                        }
                        // 當格的「上方」有掃除痕跡，代表當格也可以進行掃除
                        if ((x - 1 >= 0) && (roomArray[x][y] == 0) && (roomArray[x-1][y] == 2)) {
                            roomArray[x][y] = 2;
                        }
                        // 當格的「下方」有掃除痕跡，代表當格也可以進行掃除
                        if ((x + 1 < room) && (roomArray[x][y] == 0) && (roomArray[x+1][y] == 2)) {
                            roomArray[x][y] = 2;
                        }
                    }
                }
                count++;
            }
        }

        // 房間現況
        for (int i = 0; i < room; i++) {
            for (int j = 0; j < room; j++) {
                if (roomArray[i][j] == 0) {
                    System.out.print("空");
                } else if (roomArray[i][j] == 1) {
                    System.out.print("貨");
                } else if (roomArray[i][j] == 2) {
                    System.out.print("掃");
                }
            }
            System.out.println("");
        }

        return roomArray;
    }
}
