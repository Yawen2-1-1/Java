import com.example.bean.FoodDto;
import com.example.bean.FoodRelayDto;
import com.example.controller.FoodController;

import java.util.Scanner;
//1. update 只能修改 value，無法修改 key
//2. search 未完成
public class Main {
    public static void main(String[] args) {
        // 使用者選擇功能
        Scanner scanner = new Scanner(System.in);

        FoodController foodController = new FoodController();
        while (true) {
            System.out.print("輸入指令：");
            String command = scanner.nextLine();
            String[] commandSplit = command.split(" ");

            // 導引至使用者選擇的功能
            if ("add".equals(commandSplit[0]) && commandSplit.length == 4) {	// add
                FoodRelayDto foodRelayDto = new FoodRelayDto();
                foodRelayDto.setType(commandSplit[1]);
                foodRelayDto.setName(commandSplit[2]);
                foodRelayDto.setPrice(Integer.parseInt(commandSplit[3]));

                if (foodController.add(foodRelayDto)) {
                    System.out.println("資料已儲存！");
                } else {
                    System.out.println("資料未儲存！");
                }
            } else if ("update".equals(commandSplit[0]) && commandSplit.length == 4) {	// update
                FoodRelayDto foodRelayDto = new FoodRelayDto();
                foodRelayDto.setType(commandSplit[1]);
                foodRelayDto.setName(commandSplit[2]);
                foodRelayDto.setPrice(Integer.parseInt(commandSplit[3]));


                if (foodController.update(foodRelayDto)) {
                    System.out.println("資料已修改！");
                } else {
                    System.out.println("資料未修改！");
                }
            } else if ("delete".equals(commandSplit[0]) && commandSplit.length == 2) {	// delete
                FoodDto foodDto = new FoodDto();
                foodDto.setType(commandSplit[1]);

                if (foodController.delete(foodDto)) {
                    System.out.println("資料已刪除！");
                } else {
                    System.out.println("資料未刪除！");
                }
            } else if ("query".equals(commandSplit[0]) && commandSplit.length == 1) {	// queryAll
                foodController.queryAll();
            } else if ("query".equals(commandSplit[0]) && commandSplit.length == 2) {	// query
                FoodDto foodDto = new FoodDto();
                foodDto.setType(commandSplit[1]);

                FoodRelayDto foodRelayDto = foodController.queryByType(foodDto);
                if (foodRelayDto == null) {
                    System.out.println(foodDto.getType() + " 無資料！");
                } else {
                    System.out.println("食物類型：" + foodRelayDto.getType());
                    System.out.println("食物名稱：" + foodRelayDto.getName());
                    System.out.println("食物價格：" + foodRelayDto.getPrice());
                }
            } else if ("search".equals(commandSplit[0]) && commandSplit.length == 2) {	// search

            } else {
                System.out.println("指令格式錯誤！");
            }
        }
    }
}
