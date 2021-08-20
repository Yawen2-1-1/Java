
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
    public void doWork(int room, int item) {
        // room * room: 房間面積； item * item: 物品尺寸
        // 上下左右會預留 edge 行作為打掃範圍，即為印出「掃」字的區域
        int edge = (room - item) / 2;
        
        // 上下的前後 edge 行皆為「掃」字
        int s = 1;
        String sweeping = "";
        for (s = 1; s <= room; s++) {
            sweeping = sweeping + "    ";
        }
        
        int row = 1;
        // 第 1 行到第 edge 行
        for (row = 1; row <= edge; row++) {
            System.out.println(sweeping);
        }
        
        int col = 1;
        // 第 edge + 1 行到倒數 edge 行的前一行
        for (; row < (room - edge + 1); row++) {
            for (col = 1; col <= edge; col++) {
                System.out.print("    ");
            }
            for (; col <= (room - edge); col++) {
                System.out.print("貨");
            }
            for (; col <= room; col++) {
                System.out.print("    ");
            }
            System.out.println("");
        }
        
        // 倒數 edge 行至最後一行
        for (; row <= room; row++) {
            System.out.println(sweeping);
        }
        
        System.out.print("\n送貨機器人工作完畢\n\n");
    }
}
