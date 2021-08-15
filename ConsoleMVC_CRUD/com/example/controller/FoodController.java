package com.example.controller;

import com.example.bean.*;
import com.example.service.FoodService;

public class FoodController {
    private FoodService foodService;

    private FoodService generateFoodService() {
        this.foodService = new FoodService();
        return foodService;
    }

    public boolean add(FoodRelayDto foodRelayDto) {
        if (foodService == null) {
            foodService = generateFoodService();
        }

        FoodOutputBo foodOutputBo = new FoodOutputBo();
        foodOutputBo.setType(foodRelayDto.getType());
        foodOutputBo.setName(foodRelayDto.getName());
        foodOutputBo.setPrice(foodRelayDto.getPrice());

        return foodService.add(foodOutputBo);
    }

    public boolean update(FoodRelayDto foodRelayDto) {
        if (foodService == null) {
            return false;
        }

        FoodOutputBo foodOutputBo = new FoodOutputBo();
        foodOutputBo.setType(foodRelayDto.getType());
        foodOutputBo.setName(foodRelayDto.getName());
        foodOutputBo.setPrice(foodRelayDto.getPrice());

        return foodService.update(foodOutputBo);
    }

    public boolean delete(FoodDto foodDto) {
        if (foodService == null) {
            return false;
        }

        FoodInputBo foodInputBo = new FoodInputBo();
        foodInputBo.setType(foodDto.getType());

        return foodService.delete(foodInputBo);
    }

    public void queryAll() {
        if (foodService == null) {
            System.out.println("目前尚無資料！");
        } else {
            foodService.querySeaFood();
            foodService.queryMeat();
        }
    }

    public FoodRelayDto queryByType(FoodDto foodDto) {
        if (foodService == null) {
            System.out.println("目前尚無資料！");
            return null;
        }

        FoodRelayDto foodRelayDto = new FoodRelayDto();
        FoodOutputBo foodOutputBo;

        String foodType = foodDto.getType();
        if ("seaFood".equals(foodType)) {
            foodOutputBo = foodService.getFirstInSeaFoodMap();
            if (foodOutputBo == null) {
                System.out.println("seaFood 無資料！");
                return null;
            } else {
                foodRelayDto.setType(foodType);
                foodRelayDto.setName(foodOutputBo.getName());
                foodRelayDto.setPrice(foodOutputBo.getPrice());
            }
        } else if ("meat".equals(foodType)) {
            foodOutputBo = foodService.getFirstInMeatMap();
            if (foodOutputBo == null) {
                System.out.println("meat 無資料！");
                return null;
            } else {
                foodRelayDto.setType(foodType);
                foodRelayDto.setName(foodOutputBo.getName());
                foodRelayDto.setPrice(foodOutputBo.getPrice());
            }
        }

        return foodRelayDto;
    }
}
