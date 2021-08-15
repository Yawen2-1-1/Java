import com.example.bean.FoodDto;
import com.example.bean.FoodRelayDto;
import com.example.bean.FoodUpdateDto;
import com.example.controller.FoodController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FoodController foodController = new FoodController();
        while (true) {
            System.out.print("輸入指令：");
            String command = scanner.nextLine();
            String[] commandSplit = command.split(" ");

            if ("add".equals(commandSplit[0]) && commandSplit.length == 4) {
                FoodRelayDto foodRelayDto = new FoodRelayDto();
                foodRelayDto.setFoodType(commandSplit[1]);
                foodRelayDto.setFoodName(commandSplit[2]);
                foodRelayDto.setFoodPrice(Integer.parseInt(commandSplit[3]));

                if (foodController.add(foodRelayDto)) {
                    System.out.println("資料已儲存！");
                } else {
                    System.out.println("資料未儲存！");
                }
            } else if ("update".equals(commandSplit[0]) && commandSplit.length == 4) {
                FoodUpdateDto foodUpdateDto = new FoodUpdateDto();
                foodUpdateDto.setFoodType(commandSplit[1]);
                foodUpdateDto.setFoodProperty(commandSplit[2]);
                foodUpdateDto.setFoodValue(commandSplit[3]);

                if (foodController.update(foodUpdateDto)) {
                    System.out.println("資料已修改！");
                } else {
                    System.out.println("資料未修改！");
                }
            } else if ("delete".equals(commandSplit[0]) && commandSplit.length == 2) {
                FoodDto foodDto = new FoodDto();
                foodDto.setFoodType(commandSplit[1]);

                if (foodController.delete(foodDto)) {
                    System.out.println("資料已刪除！");
                } else {
                    System.out.println("資料未刪除！");
                }
            }
        }
    }
}
