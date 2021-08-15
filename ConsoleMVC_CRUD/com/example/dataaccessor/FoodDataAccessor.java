package com.example.dataaccessor;

import com.example.bean.MeatDo;
import com.example.bean.SeaFoodDo;

import java.util.HashMap;
import java.util.Map;

public class FoodDataAccessor {
    private Map<String, Integer> seaFoodDataMap;
    private Map<String, Integer> meatDataMap;

    private Map<String, Integer> generateDataMap() {
        Map<String, Integer> dataMap = new HashMap<>();
        return dataMap;
    }

    public boolean saveSeaFood(SeaFoodDo seaFoodDo) {
        // 在 map 中儲存 seaFood 的 foodName 和 foodPrice
        if (seaFoodDataMap == null) {
            this.seaFoodDataMap = generateDataMap();
        }

        try {
            seaFoodDataMap.put(seaFoodDo.getName(), seaFoodDo.getPrice());
            return true;
        } catch(NullPointerException e) {
            System.out.println("NPE 錯誤，無資料儲存！");
            return false;
        }
    }

    public boolean saveMeat(MeatDo meatDo) {
        // 在 map 中儲存 meat 的 foodName 和 foodPrice
        if (meatDataMap == null) {
            this.meatDataMap = generateDataMap();
        }

        try {
            meatDataMap.put(meatDo.getName(), meatDo.getPrice());
            return true;
        } catch(NullPointerException e) {
            System.out.println("NPE 錯誤，無法儲存資料！");
            return false;
        }
    }

    public boolean updateSeaFood(SeaFoodDo seaFoodDo) {
        if (seaFoodDataMap == null) {
            return false;
        }
        try {
            String key = seaFoodDo.getName();
            int oldValue = seaFoodDataMap.get(key);
            int newValue = seaFoodDo.getPrice();

            seaFoodDataMap.replace(key, oldValue, newValue);
            return true;
        } catch (NullPointerException e) {
            System.out.println("NPE 錯誤，無法修改資料！");
            return false;
        }
    }

    public boolean updateMeat(MeatDo meatDo) {
        if (meatDataMap == null) {
            return false;
        }
        try {
            String key = meatDo.getName();
            int oldValue = meatDataMap.get(key);
            int newValue = meatDo.getPrice();

            meatDataMap.replace(key, oldValue, newValue);
            return true;
        } catch (NullPointerException e) {
            System.out.println("NPE 錯誤，無法修改資料！");
            return false;
        }
    }

    public boolean deleteSeaFood() {
        if (seaFoodDataMap == null) {
            return false;
        }

        try {
            seaFoodDataMap = null;
            return true;
        } catch (NullPointerException e) {
            System.out.println("NPE 錯誤，無法刪除資料！");
            return false;
        }
    }

    public boolean deleteMeat() {
        if (meatDataMap == null) {
            return false;
        }

        try {
            meatDataMap = null;
            return true;
        } catch (NullPointerException e) {
            System.out.println("NPE 錯誤，無法刪除資料！");
            return false;
        }
    }

    public Map<String, Integer> querySeaFood() {
        if (seaFoodDataMap == null) {
            return null;
        }

        return seaFoodDataMap;
    }

    public Map<String, Integer> queryMeat() {
        if (meatDataMap == null) {
            return null;
        }

        return meatDataMap;
    }

    public SeaFoodDo getFirstInSeaFoodMap() {
        if (seaFoodDataMap == null) {
            return null;
        } else {
            SeaFoodDo seaFoodDo = new SeaFoodDo();
            seaFoodDo.setName((String) seaFoodDataMap.keySet().toArray()[0]);
            seaFoodDo.setPrice(Integer.parseInt(String.valueOf(seaFoodDataMap.values().toArray()[0])));

            return seaFoodDo;
        }
    }

    public MeatDo getFirstInMeatMap() {
        if (meatDataMap == null) {
            return null;
        } else {
            MeatDo meatDo = new MeatDo();
            meatDo.setName((String) meatDataMap.keySet().toArray()[0]);
            meatDo.setPrice(Integer.parseInt(String.valueOf(meatDataMap.values().toArray()[0])));

            return meatDo;
        }
    }
}
