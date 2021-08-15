package com.example.service;

import com.example.bean.*;
import com.example.dataaccessor.FoodDataAccessor;

public class FoodService {

    private FoodDataAccessor foodDataAccessor;

    private void setFoodDataAccessor() {
        this.foodDataAccessor = new FoodDataAccessor();
    }

    public boolean add(FoodOutputBo foodOutputBo) {
        if (foodDataAccessor == null) {
            setFoodDataAccessor();
        }

        if (foodOutputBo == null) {
            return false;
        } else {
            if ("seaFood".equals(foodOutputBo.getFoodType())) {
                SeaFoodDo seaFoodDo = new SeaFoodDo();
                seaFoodDo.setFoodName(foodOutputBo.getFoodName());
                seaFoodDo.setFoodPrice(String.valueOf(foodOutputBo.getFoodPrice()));

                return foodDataAccessor.addSeaFood(seaFoodDo);
            } else if ("meat".equals(foodOutputBo.getFoodType())) {
                MeatDo meatDo = new MeatDo();
                meatDo.setFoodName(foodOutputBo.getFoodName());
                meatDo.setFoodPrice(String.valueOf(foodOutputBo.getFoodPrice()));

                return foodDataAccessor.addMeat(meatDo);
            }
        }

        return false;
    }

    public boolean updateName(FoodUpdateBo foodUpdateBo) {
        if (foodDataAccessor == null) {
            return false;
        }

        if (foodUpdateBo == null) {
            return false;
        } else {
            return foodDataAccessor.updateName(foodUpdateBo.getFoodType(), foodUpdateBo.getFoodValue());
        }
    }

    public boolean updatePrice(FoodUpdateBo foodUpdateBo) {
        if (foodDataAccessor == null) {
            return false;
        }

        if (foodUpdateBo == null) {
            return false;
        } else {
            return foodDataAccessor.updatePrice(foodUpdateBo.getFoodType(), foodUpdateBo.getFoodValue());
        }
    }

    public boolean delete(FoodInputBo foodInputBo) {
        if (foodDataAccessor == null) {
            return false;
        }

        if (foodInputBo == null) {
            return false;
        } else {
            return foodDataAccessor.delete(foodInputBo.getFoodType());
        }
    }
}
