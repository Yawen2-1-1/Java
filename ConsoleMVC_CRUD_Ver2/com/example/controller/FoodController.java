package com.example.controller;

import com.example.bean.*;
import com.example.service.FoodService;

public class FoodController {

    private FoodService foodService;

    private void setFoodService() {
        this.foodService = new FoodService();
    }

    public boolean add(FoodRelayDto foodRelayDto) {
        if (foodService == null) {
            setFoodService();
        }

        if (foodRelayDto == null) {
            return false;
        } else {
            FoodOutputBo foodOutputBo = new FoodOutputBo();
            foodOutputBo.setFoodType(foodRelayDto.getFoodType());
            foodOutputBo.setFoodName(foodRelayDto.getFoodName());
            foodOutputBo.setFoodPrice(foodRelayDto.getFoodPrice());

            return foodService.add(foodOutputBo);
        }
    }

    public boolean update(FoodUpdateDto foodUpdateDto) {
        if (foodService == null) {
            return false;
        }

        if (foodUpdateDto == null) {
            return false;
        } else {
            FoodUpdateBo foodUpdateBo = new FoodUpdateBo();
            foodUpdateBo.setFoodType(foodUpdateDto.getFoodType());
            foodUpdateBo.setFoodValue(foodUpdateBo.getFoodValue());

            if ("name".equals(foodUpdateDto.getFoodProperty())) {   // 修改名子
                return foodService.updateName(foodUpdateBo);
            } else if ("price".equals(foodUpdateDto.getFoodProperty())) {   // 修改價格
                return foodService.updatePrice(foodUpdateBo);
            }
        }

        return false;
    }

    public boolean delete(FoodDto foodDto) {
        if (foodService == null) {
            return false;
        }

        if (foodDto == null) {
            return false;
        } else {
            FoodInputBo foodInputBo = new FoodInputBo();
            foodInputBo.setFoodType(foodDto.getFoodType());

            return foodService.delete(foodInputBo);
        }
    }
}
