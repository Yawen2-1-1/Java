
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
    public Status[][] doWork(int room, int item, Status[][] roomArray) {
        // 入口點若放置貨物，則掃地機器人無法進入房間掃地
        if (roomArray[0][0] == Status.GOODS) {
            for (int i = 0; i < room; i++) {
                for (int j = 0; j < room; j++) {
                    roomArray[i][j] = Status.SPACE;
                }
            }
        } else {
            // 由左至右掃地
            for (int x = 0; x < room; x++) {
                for (int y = 0; y < room; y++) {
                    if ((x - 1 >= 0) && (roomArray[x][y] == Status.SPACE) && (roomArray[x-1][y] == Status.CLEANED)) {
                        roomArray[x][y] = Status.CLEANED;
                        if ((y + 1 < room) && (roomArray[x][y+1] == Status.GOODS)) {
                            break;
                        }
                    }
                    if ((x == 0) && (roomArray[x][y] == Status.SPACE)) {
                        roomArray[x][y] = Status.CLEANED;
                        if ((y + 1 < room) && (roomArray[x][y+1] == Status.GOODS)) {
                            break;
                        }
                    }
                }
            }

            // 從 col = 0 開始判斷是否有被貨物圍住而不能進入的封閉區域
            int space = 0;
            for (int x = 0; x < room; x++) {
                for (int y = 0; y < room; y++) {
                    if ((x - 1 >= 0) && (roomArray[x][y] == Status.SPACE || roomArray[x][y] == Status.CLEANED)
                            && (roomArray[x-1][y] == Status.GOODS)) {
                        space++;
                        if ((y + 1 < room) && (roomArray[x][y+1] == Status.GOODS)) {
                            for (int s = 0; s < space; s++) {
                                roomArray[x][s] = Status.SPACE;
                            }
                        }
                    }
                }
                space = 0;
            }

            // 清理因為貨物堆放而造成的不規則角落
            int count = 1;
            while (count != 3) {
                for (int x = 0; x < room; x++) {
                    for (int y = 0; y < room; y++) {
                        // 當格的「左邊」有掃除痕跡，代表當格也可以進行掃除
                        if ((y - 1 >= 0) && (roomArray[x][y] == Status.SPACE) && (roomArray[x][y - 1] == Status.CLEANED)) {
                            roomArray[x][y] = Status.CLEANED;
                        }
                        // 當格的「右邊」有掃除痕跡，代表當格也可以進行掃除
                        if ((y + 1 < room) && (roomArray[x][y] == Status.SPACE) && (roomArray[x][y + 1] == Status.CLEANED)) {
                            roomArray[x][y] = Status.CLEANED;
                        }
                        // 當格的「上方」有掃除痕跡，代表當格也可以進行掃除
                        if ((x - 1 >= 0) && (roomArray[x][y] == Status.SPACE) && (roomArray[x - 1][y] == Status.CLEANED)) {
                            roomArray[x][y] = Status.CLEANED;
                        }
                        // 當格的「下方」有掃除痕跡，代表當格也可以進行掃除
                        if ((x + 1 < room) && (roomArray[x][y] == Status.SPACE) && (roomArray[x + 1][y] == Status.CLEANED)) {
                            roomArray[x][y] = Status.CLEANED;
                        }
                        // 若當格為可清潔區域，但上方為為清潔區域，則一路往上清掃至底部或貨物堆放的前一格
                        if ((x - 1 >= 0) && (roomArray[x][y] == Status.CLEANED) && (roomArray[x - 1][y] == Status.SPACE)) {
                            for (int up = (x-1); up >= 0; up--) {
                                if (roomArray[up][y] == Status.SPACE) {
                                    roomArray[up][y] = Status.CLEANED;
                                    if ((up - 1 >= 0) && (roomArray[up-1][y] == Status.GOODS)) {
                                        break;
                                    }
                                }
                            }
                        }
                        // 若當格為可清潔區域，但上方為為清潔區域，則一路往左清掃至底部或貨物堆放的前一格
                        if ((y - 1 >= 0) && (roomArray[x][y] == Status.CLEANED) && (roomArray[x][y-1] == Status.SPACE)) {
                            for (int left = (y-1); left >= 0; left--) {
                                if (roomArray[x][left] == Status.SPACE) {
                                    roomArray[x][left] = Status.CLEANED;
                                    if ((left - 1 >= 0) && (roomArray[x][left-1] == Status.GOODS)) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                count++;
            }
        }

        // 房間現況
        for (int i = 0; i < room; i++) {
            for (int j = 0; j < room; j++) {
                if (roomArray[i][j] == Status.SPACE) {
                    System.out.print("空");
                } else if (roomArray[i][j] == Status.GOODS) {
                    System.out.print("貨");
                } else if (roomArray[i][j] == Status.CLEANED) {
                    System.out.print("掃");
                }
            }
            System.out.println("");
        }

        return roomArray;
    }
}
