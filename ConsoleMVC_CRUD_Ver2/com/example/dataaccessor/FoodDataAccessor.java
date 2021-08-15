package com.example.dataaccessor;

import com.example.bean.MeatDo;
import com.example.bean.SeaFoodDo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FoodDataAccessor {

    private Map<String, List> dataBaseMap;

    private void setDataBaseMap() {
        this.dataBaseMap = new HashMap<>();
    }

    public boolean addSeaFood(SeaFoodDo seaFoodDo) {
        if (dataBaseMap == null) {
            setDataBaseMap();
        }

        if (seaFoodDo == null) {
            return false;
        } else {
            List<String> valueList = new LinkedList<>();
            valueList.add(seaFoodDo.getFoodName());
            valueList.add(seaFoodDo.getFoodPrice());

            dataBaseMap.put("seaFood", valueList);

            return true;
        }
    }

    public boolean addMeat(MeatDo meatDo) {
        if (dataBaseMap == null) {
            setDataBaseMap();
        }

        if (meatDo == null) {
            return false;
        } else {
            List<String> valueList = new LinkedList<>();
            valueList.add(meatDo.getFoodName());
            valueList.add(meatDo.getFoodPrice());

            dataBaseMap.put("meat", valueList);

            return true;
        }
    }

    public boolean updateName(String foodType, String foodName) {
        if (dataBaseMap == null) {
            return false;
        }

        // 如果資料新增後刪除，要再修改食物名稱，需先檢查存放食物名稱的 list 是否存在
        // 以免發生 NullPointerException
        List<String> valueList = dataBaseMap.get(foodType);
        if (valueList == null) {
            return false;
        } else {
            String oldName = valueList.get(0);
            if (oldName.equals(valueList.set(0, foodName))) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean updatePrice(String foodType, String foodPrice) {
        if (dataBaseMap == null) {
            return false;
        }

        // 如果資料新增後刪除，要再修改食物價格，需先檢查存放食物價格的 list 是否存在
        // 以免發生 NullPointerException
        List<String> valueList = dataBaseMap.get(foodType);
        if (valueList == null) {
            return false;
        } else {
            String oldValue = valueList.get(0);
            if (oldValue.equals(valueList.set(0, foodPrice))) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean delete(String foodType) {
        if (dataBaseMap == null) {
            return false;
        }

        if (dataBaseMap.remove(foodType, dataBaseMap.get(foodType))) {
            return true;
        } else {
            return false;
        }
    }
}
