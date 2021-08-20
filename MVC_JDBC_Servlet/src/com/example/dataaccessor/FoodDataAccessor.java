package com.example.dataaccessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.bean.FoodDo;
import com.example.bean.MeatDo;
import com.example.bean.SeaFoodDo;

public class FoodDataAccessor extends DBConnector {
    // private String fish = "魚";
    // private String beef = "牛肉";
    // private int fishPrice = 50;
    // private int beefPrice = 100;

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // public SeaFoodDo getSeaFood(String foodType) {
    // SeaFoodDo seaFoodDo = new SeaFoodDo();
    // seaFoodDo.setName(fish);
    // seaFoodDo.setPrice(fishPrice);
    // return seaFoodDo;
    // }
    //
    // public MeatDo getMeat(String foodType) {
    // MeatDo meatDo = new MeatDo();
    // meatDo.setName(beef);
    // meatDo.setPrice(beefPrice);
    // return meatDo;
    // }

    public FoodDo query(String foodType) {
        if (foodType == null) {
            return null;
        }

        String command = "SELECT FOOD_NAME, FOOD_PRICE FROM HW_TB_FOOD_21989 WHERE FOOD_TYPE = ?";
        try (Connection conn = getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(command);) {
            preparedStatement.setString(1, foodType);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.executeQuery();

            FoodDo foodDo = null;
            while (resultSet.next()) {
                foodDo = new FoodDo();
                foodDo.setFoodName(resultSet.getString("FOOD_NAME"));
                foodDo.setFoodPrice(resultSet.getInt("FOOD_PRICE"));
            }

            return foodDo;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
