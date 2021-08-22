import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // 製造機器人的變數
        int choice = 1;
        float height = (float) 0.0;
        float width = (float) 0.0;
        String company = null;
        
        Scanner scanner = new Scanner(System.in);
        
        // 工作場景變數
        int roomLength = 0;
        int itemLength = 0;

        System.out.print("房間長度(cm)：");
        roomLength = scanner.nextInt();
        System.out.print("物品長度(cm)：");
        itemLength = scanner.nextInt();

        // 產生一個符合房間大小 (room * room) 的二維陣列，並將每一格設為 0 (空地)
        int[][] roomArray = new int[roomLength][roomLength];
        for (int i = 0; i < roomLength; i++) {
            for (int j = 0; j < roomLength; j++) {
                roomArray[i][j] = 0;
            }
        }

        int[][] roomAfterDelivery = new int[roomLength][roomLength];

        System.out.print("0: 結束\t1: 工作：");
        choice = scanner.nextInt();

        while (choice != 0) {   // 輸入 0 為結束送貨
            System.out.print("機器人的高度(cm)：");
            height = scanner.nextFloat();
            System.out.print("機器人的寬度(cm)：");
            width = scanner.nextFloat();
            System.out.print("機器人製造公司：");
            company = scanner.next();

            // 工廠製造送貨機器人
            Factory deliveryRobotFactory = new DeliveryRobotFactory("送貨機器人", height, width, company);
            Robot deliveryRobot = deliveryRobotFactory.generateRobot();

            deliveryRobot.introduce();

            System.out.println("\n送貨機器人製造完成，開始工作：");
            roomArray = initializeRoomArray(roomArray, roomLength);
            roomAfterDelivery = deliveryRobot.doWork(roomLength, itemLength, roomArray);
            if (roomAfterDelivery[0][0] == 1) {
                System.out.println("貨物堆放於門口處，機器人無法再進入房間進行工作！");
                break;
            }

            // 工廠製造掃地機器人
            Factory sweepingRobotFactory = new SweepingRobotFactory("掃地機器人", height, width, company);
            Robot sweepingRobot = sweepingRobotFactory.generateRobot();

            sweepingRobot.introduce();

            System.out.println("\n掃地機器人製造完成，開始工作：");
            roomArray = initializeRoomArray(roomArray, roomLength);
            sweepingRobot.doWork(roomLength, itemLength, roomArray);

            System.out.print("0: 結束\t1: 工作：");
            choice = scanner.nextInt();
        }

        System.out.println("機器人結束工作！");
    }

    public static int[][] initializeRoomArray(int[][] roomArray, int roomLength) {
        for (int i = 0; i < roomLength; i++) {
            for (int j = 0; j < roomLength; j++) {
                if (roomArray[i][j] != 1) {
                    roomArray[i][j] = 0;
                }
            }
        }
        return roomArray;
    }
}
