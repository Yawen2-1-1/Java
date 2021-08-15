package com.example.service;

import com.example.bean.*;
import com.example.dataaccessor.FoodDataAccessor;

import java.util.Map;

public class FoodService {
    private FoodDataAccessor foodDataAccessor;

    private FoodDataAccessor generateFoodDataAccessor() {
        this.foodDataAccessor = new FoodDataAccessor();
        return foodDataAccessor;
    }

    public boolean add(FoodOutputBo foodOutputBo) {
        if (foodDataAccessor == null) {
            foodDataAccessor = generateFoodDataAccessor();
        }

        if ("seaFood".equals(foodOutputBo.getType())) {
            SeaFoodDo seaFoodDo = new SeaFoodDo();
            seaFoodDo.setName(foodOutputBo.getName());
            seaFoodDo.setPrice(foodOutputBo.getPrice());

            return foodDataAccessor.saveSeaFood(seaFoodDo);
        } else if ("meat".equals(foodOutputBo.getType())) {
            MeatDo meatDo = new MeatDo();
            meatDo.setName(foodOutputBo.getName());
            meatDo.setPrice(foodOutputBo.getPrice());

            return foodDataAccessor.saveMeat(meatDo);
        } else {
            System.out.println("食物類型錯誤！");
            return false;
        }
    }

    public boolean update(FoodOutputBo foodOutputBo) {
        if (foodDataAccessor == null) {
            return false;
        }

        if ("seaFood".equals(foodOutputBo.getType())) {
            SeaFoodDo seaFoodDo = new SeaFoodDo();
            seaFoodDo.setName(foodOutputBo.getName());
            seaFoodDo.setPrice(foodOutputBo.getPrice());

            return foodDataAccessor.updateSeaFood(seaFoodDo);
        } else if ("meat".equals(foodOutputBo.getType())) {
            MeatDo meatDo = new MeatDo();
            meatDo.setName(foodOutputBo.getName());
            meatDo.setPrice(foodOutputBo.getPrice());

            return foodDataAccessor.updateMeat(meatDo);
        } else {
            System.out.println("食物類型錯誤");
            return false;
        }
    }

    public boolean delete(FoodInputBo foodInputBo) {
        if (foodDataAccessor == null) {
            return false;
        }

        if ("seaFood".equals(foodInputBo.getType())) {
            return foodDataAccessor.deleteSeaFood();
        } else if ("meat".equals(foodInputBo.getType())) {
            return foodDataAccessor.deleteMeat();
        } else {
            System.out.println("食物類型錯誤");
            return false;
        }
    }

    public void querySeaFood() {
        if (foodDataAccessor == null) {
            System.out.println("目前尚無資料！");
        } else {
            Map<String, Integer> seaFoodMap = foodDataAccessor.querySeaFood();
            if (seaFoodMap == null) {
                System.out.println("seaFood 尚無資料！");
            } else {
                for (Map.Entry<String, Integer> entry : seaFoodMap.entrySet()) {
                    System.out.println("seaFood " + entry.getKey() + " : " + entry.getValue());
                }
            }
        }
    }

    public void queryMeat() {
        if (foodDataAccessor == null) {
            System.out.println("目前尚無資料！");
        } else {
            Map<String, Integer> meatMap = foodDataAccessor.queryMeat();
            if (meatMap == null) {
                System.out.println("meat 尚無資料！");
            } else {
                for (Map.Entry<String, Integer> entry : meatMap.entrySet()) {
                    System.out.println("meat " + entry.getKey() + " : " + entry.getValue());
                }
            }
        }
    }

    public FoodOutputBo getFirstInSeaFoodMap() {
        if (foodDataAccessor == null) {
            System.out.println("目前尚無資料！");
            return null;
        }

        SeaFoodDo seaFoodDo = foodDataAccessor.getFirstInSeaFoodMap();

        if (seaFoodDo == null) {
            System.out.println("seaFood 無資料！");
            return null;
        } else {
            FoodOutputBo foodOutputBo = new FoodOutputBo();
            foodOutputBo.setName(seaFoodDo.getName());
            foodOutputBo.setPrice(seaFoodDo.getPrice());

            return foodOutputBo;
        }
    }

    public FoodOutputBo getFirstInMeatMap() {
        if (foodDataAccessor == null) {
            System.out.println("目前尚無資料！");
            return null;
        }

        MeatDo meatDo = foodDataAccessor.getFirstInMeatMap();

        if (meatDo == null) {
            System.out.println("meat 無資料！");
            return null;
        } else {
            FoodOutputBo foodOutputBo = new FoodOutputBo();
            foodOutputBo.setName(meatDo.getName());
            foodOutputBo.setPrice(meatDo.getPrice());

            return foodOutputBo;
        }
    }
}
