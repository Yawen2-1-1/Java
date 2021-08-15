package com.example.bean;

public class FoodRelayDto {
    private int foodPrice;
    private String foodName;
    private String foodType;

    public void setPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getPrice() {
        return foodPrice;
    }

    public void setName(String foodName) {
        this.foodName = foodName;
    }

    public String getName() {
        return foodName;
    }

    public void setType(String foodType) {
        this.foodType = foodType;
    }

    public String getType() {
        return foodType;
    }
}
