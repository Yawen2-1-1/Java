import com.example.bean.FoodDto;
import com.example.bean.FoodRelayDto;
import com.example.controller.FoodController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) {
        FoodController foodController = new FoodController();
        FoodDto foodDto = new FoodDto();
        FoodRelayDto foodRelayDto;
        
        foodDto.setFoodType("seaFood");
        foodRelayDto = foodController.chooseFood(foodDto);
        if (foodRelayDto == null) {
            System.out.println("無資料！");
        } else {
            System.out.println("品項：" + foodRelayDto.getName());
            System.out.println("價格：" + foodRelayDto.getPrice());
        }
        
        foodDto.setFoodType("meat");
        foodRelayDto = foodController.chooseFood(foodDto);
        if (foodRelayDto == null) {
            System.out.println("無資料！");
        } else {
            System.out.println("品項：" + foodRelayDto.getName());
            System.out.println("價格：" + foodRelayDto.getPrice());
        }
        
        foodDto.setFoodType("vegetable");
        foodRelayDto = foodController.chooseFood(foodDto);
        if (foodRelayDto == null) {
            System.out.println("無資料！");
        } else {
            System.out.println("品項：" + foodRelayDto.getName());
            System.out.println("價格：" + foodRelayDto.getPrice());
        }
    }

}
