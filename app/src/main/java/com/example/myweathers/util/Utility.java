package com.example.myweathers.util;

import android.text.TextUtils;

import com.example.myweathers.db.City;
import com.example.myweathers.db.County;
import com.example.myweathers.db.Province;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

    /**
     * @param response 解析和处理服务器返回的省级数据
     * @return
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray jsonProvince = new JSONArray(response);
                for (int i = 0; i < jsonProvince.length(); i++) {
                    JSONObject provinceObject = jsonProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * @param response
     * @param provinceId
     * @return 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){

        if (!TextUtils.isEmpty(response)){

            try {
                JSONArray jsonCity = new JSONArray(response);
                for (int i = 0; i < jsonCity.length(); i++) {
                    JSONObject cityObject = jsonCity.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * @param response
     * @param cityId
     * @return 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response,int cityId){

        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray jsonCounty = new JSONArray(response);
                for (int i = 0; i < jsonCounty.length(); i++) {
                    JSONObject countyObject = jsonCounty.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
