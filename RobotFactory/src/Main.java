import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // 製造機器人的變數
        int choice = 0;
        float height = (float) 0.0;
        float width = (float) 0.0;
        String company = null;
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("1. 掃地機器人    2.  送貨機器人    3. 結束\n產生何種機器人：");
        choice = scanner.nextInt();
        
        // 工作場景變數
        int roomLength = 0;
        int itemLength = 0;
        
        while (choice != 3) {
            System.out.print("機器人的高度(cm)：");
            height = scanner.nextFloat();
            System.out.print("機器人的寬度(cm)：");
            width = scanner.nextFloat();
            System.out.print("機器人製造公司：");
            company = scanner.next();
            
            if (choice == 1) {
                // 工廠製造掃地機器人
                Factory sweepingRobotFactory = new SweepingRobotFactory("掃地機器人", height, width, company);
                Robot sweepingRobot = sweepingRobotFactory.generateRobot();
                
                sweepingRobot.introduce();
                
                System.out.println("\n掃地機器人製造完成，設定房間和貨品尺寸，讓掃地機器人開始工作：");
                System.out.print("房間長度(cm)：");
                roomLength = scanner.nextInt();
                System.out.print("物品長度(cm)：");
                itemLength = scanner.nextInt();
                System.out.println("\n掃地機器人開始工作：\n");
                
                sweepingRobot.doWork(roomLength, itemLength);
            } else if (choice == 2) {
                // 工廠製造送貨機器人
                Factory deliveryRobotFactory = new DeliveryRobotFactory("送貨機器人", height, width, company);
                Robot deliveryRobot = deliveryRobotFactory.generateRobot();
                
                deliveryRobot.introduce();
                
                System.out.println("\n送貨機器人製造完成，設定房間和貨品尺寸，讓送貨機器人開始工作：");
                System.out.print("房間長度(cm)：");
                roomLength = scanner.nextInt();
                System.out.print("物品長度(cm)：");
                itemLength = scanner.nextInt();
                System.out.println("\n送貨機器人開始工作：\n");
                
                deliveryRobot.doWork(roomLength, itemLength);
            }
            
            System.out.print("1. 掃地機器人    2. 送貨機器人 3. 結束\n需要再製作哪一種機器人：");
            choice = scanner.nextInt();
        }
        
        System.out.println("機器人結束製作！");
    }
}
