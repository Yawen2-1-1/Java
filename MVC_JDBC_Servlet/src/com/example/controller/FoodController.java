package com.example.controller;

import com.example.bean.FoodDto;
import com.example.bean.FoodInputBo;
import com.example.bean.FoodOutputBo;
import com.example.bean.FoodRelayDto;
import com.example.service.FoodService;

public class FoodController {
    private FoodService foodService = new FoodService();

    public FoodRelayDto chooseFood(FoodDto inputDto) {
        if (foodService == null) {
            return null;
        }
        
        if (inputDto == null) {
            return null;
        }

        FoodInputBo foodInputBo = new FoodInputBo();
        foodInputBo.setFoodType(inputDto.getFoodType());

        FoodOutputBo foodOutputBo = foodService.query(foodInputBo);

        if (foodOutputBo == null) {
            return null;
        }
        
        FoodRelayDto foodRelayDto = new FoodRelayDto();
        foodRelayDto.setName(foodOutputBo.getName());
        foodRelayDto.setPrice(foodOutputBo.getPrice());

        return foodRelayDto;
    }
}
