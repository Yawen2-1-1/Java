import java.util.Random;

public class DeliveryRobot implements Robot {

    private String name;
    private float height;
    private float width;
    private String company;
    
    public DeliveryRobot(String name, float height, float width, String company) {
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
        // 隨機產生兩個整數作為一組座標 [x][y]，並依據貨物大小 (item * item)，向右下拓展至 [x+item-1][y+item-1]，
        // 並判別這塊正方形區域是否與其他貨物重疊或是空間不足擺放貨物，若是則重複步驟 2.，若否則進行步驟 3.
        Random random = new Random();
        int row = 0;
        int col = 0;
        boolean emptyPlace = false;
        while (!emptyPlace) {
            emptyPlace = true;
            row = random.nextInt(room);
            col = random.nextInt(room);
            for (int y = col; y <= (col+item-1); y++) {
                for (int x = row; x <= (row+item-1); x++) {
                    if (x >= room || y >= room) {
                        System.out.println("空間不足，重新選擇放置地點！");
                        emptyPlace = false;
                        break;
                    }
                    if (roomArray[x][y] == 1) {
                        System.out.println("貨物重疊，重新選擇放置地點！");
                        emptyPlace = false;
                        break;
                    }
                }
                if (!emptyPlace) {
                    break;
                }
            }
        }

        // 由送貨機器人工廠生產一個送貨機器人擺放貨物，並將貨物擺放範圍設為 1 (已擺放貨物)
        for (int y = col; y <= (col+item-1); y++) {
            for (int x = row; x <= (row+item-1); x++) {
                roomArray[x][y] = 1;
            }
        }

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
