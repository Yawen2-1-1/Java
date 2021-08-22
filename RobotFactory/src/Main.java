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
        Status[][] roomArray = new Status[roomLength][roomLength];
        for (int i = 0; i < roomLength; i++) {
            for (int j = 0; j < roomLength; j++) {
                roomArray[i][j] = Status.SPACE;
            }
        }

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
            Status[][] roomAfterDelivery = deliveryRobot.doWork(roomLength, itemLength, roomArray);
            if (roomAfterDelivery[0][0] == Status.GOODS) {
                System.out.println("貨物堆放於門口處，機器人無法再進入房間進行工作！");
                break;
            }

            // 工廠製造掃地機器人
            Factory sweepingRobotFactory = new SweepingRobotFactory("掃地機器人", height, width, company);
            Robot sweepingRobot = sweepingRobotFactory.generateRobot();

            sweepingRobot.introduce();

            System.out.println("\n掃地機器人製造完成，開始工作：");
            //roomArray = initializeRoomArray(roomArray, roomLength);
            sweepingRobot.doWork(roomLength, itemLength, roomArray);

            System.out.print("0: 結束\t1: 工作：");
            choice = scanner.nextInt();
        }

        System.out.println("機器人結束工作！");
    }

    public static Status[][] initializeRoomArray(Status[][] roomArray, int roomLength) {
        // 送貨機器人：接收來自掃地機器人清掃完畢的 roomArray，需先將掃除紀錄清除，因為不需要判斷何處為清掃區域
        // 掃地機器人：將非貨物區域設為 Status.SPACE，方便掃地機器人在送貨機器人工作完畢，可以判斷何處為須清掃區域
        for (int i = 0; i < roomLength; i++) {
            for (int j = 0; j < roomLength; j++) {
                if (roomArray[i][j] != Status.GOODS) {
                    roomArray[i][j] = Status.SPACE;
                }
            }
        }
        return roomArray;
    }
}
