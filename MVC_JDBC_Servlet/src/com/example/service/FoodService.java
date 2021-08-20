package com.example.service;

import com.example.bean.FoodDo;
import com.example.bean.FoodInputBo;
import com.example.bean.FoodOutputBo;
import com.example.bean.MeatDo;
import com.example.bean.SeaFoodDo;
import com.example.dataaccessor.FoodDataAccessor;

public class FoodService {
    /**
     * foodDataAccessor 在全域變數產生實體
     */
    private FoodDataAccessor foodDataAccessor = new FoodDataAccessor();

//    public FoodOutputBo getFood(FoodInputBo inputBo) {
//        /**
//         * foodOutputBo 只需先宣告，然後在判斷食物類型正確再產生實體
//         */
//        FoodOutputBo foodOutputBo;
//
//        if (inputBo == null) {
//            return null;
//        }
//
//        /**
//         * else 不需要，減少縮排
//         */
//        String foodType = inputBo.getFoodType();
//        if ("seaFood".equals(foodType)) {
//            foodOutputBo = new FoodOutputBo();
//
//            /**
//             * foodDataAccessor.getSeaFood() 回傳一個 seaFoodDo 的實體，因此 SeaFoodDo seaFoodDo = new SeaFoodDo(); 不需要
//             */
//            SeaFoodDo seaFoodDo = foodDataAccessor.getSeaFood(inputBo.getFoodType());
//            foodOutputBo.setName(seaFoodDo.getName());
//            foodOutputBo.setPrice(seaFoodDo.getPrice());
//        } else if ("meat".equals(foodType)) {
//            foodOutputBo = new FoodOutputBo();
//
//            MeatDo meatDo = foodDataAccessor.getMeat(inputBo.getFoodType());
//            foodOutputBo.setName(meatDo.getName());
//            foodOutputBo.setPrice(meatDo.getPrice());
//        } else {
//            /**
//             * System.out.println(); 是給螢幕印的，對 Service 而言無用
//             */
//            return null;
//        }
//
//        return foodOutputBo;
//    }
    
    public FoodOutputBo query(FoodInputBo foodInputBo) {
        if (foodDataAccessor == null) {
            return null;
        }
        
        if (foodInputBo == null) {
            return null;
        }
        
        FoodDo foodDo = foodDataAccessor.query(foodInputBo.getFoodType());
        
        if (foodDo == null) {
            return null;
        }
        
        FoodOutputBo foodOutputBo = new FoodOutputBo();
        foodOutputBo.setName(foodDo.getFoodName());
        foodOutputBo.setPrice(foodDo.getFoodPrice());
        
        return foodOutputBo;        
    }
}
