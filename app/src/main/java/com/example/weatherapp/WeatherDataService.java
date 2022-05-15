package com.example.weatherapp;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {

    Context context;
    String cityid=null;



    public interface volleyResponseListener{
        void onError(String message);
        void onResponse(String cityid);
    }
    public WeatherDataService(Context context) {
        this.context = context;
    }

    public void getCityId(String cityName,volleyResponseListener volleyResponseListener)
    {


        String url = getUrl();
        url=url.concat(cityName);

        JsonArrayRequest request = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        cityid="";
                        try {
                            JSONObject cityinfo = response.getJSONObject(0);
                            cityid=cityinfo.getString("woeid");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        volleyResponseListener.onResponse(cityid);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        volleyResponseListener.onError("Something went wrong");

                    }
                });
        MySingleton.getInstance(context).addToRequestQueue(request);



    }
    public interface ForcastById
    {
        void onError(String message);
        void OnResponse(List<WeatherReportModel> weatherReportModels);

    }

    public void getForcastByCityId(String cityid,ForcastById forcastById){
        List<WeatherReportModel> weatherReportModels=new ArrayList<>();


        String url2= getUrl2()+cityid;

        System.out.println(url2);

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url2, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();

                try {

                    JSONArray consolidated_weather_list=response.getJSONArray("consolidated_weather");



                    for(int i=0;i<consolidated_weather_list.length();i++) {

                        WeatherReportModel one_day_weather = new WeatherReportModel();


                        JSONObject first_day_from_api = (JSONObject) consolidated_weather_list.get(i);
                        one_day_weather.setId(first_day_from_api.getInt("id"));
                        one_day_weather.setWeather_state_name(first_day_from_api.getString("weather_state_name"));
                        one_day_weather.setWeather_state_abbr(first_day_from_api.getString("weather_state_abbr"));
                        one_day_weather.setWind_direction_compass(first_day_from_api.getString("wind_direction_compass"));
                        one_day_weather.setCreated(first_day_from_api.getString("created"));
                        one_day_weather.setApplicable_date(first_day_from_api.getString("applicable_date"));
                        one_day_weather.setMin_temp(first_day_from_api.getDouble("min_temp"));
                        one_day_weather.setMax_temp(first_day_from_api.getDouble("max_temp"));
                        one_day_weather.setThe_temp(first_day_from_api.getDouble("the_temp"));
                        one_day_weather.setWind_speed(first_day_from_api.getDouble("wind_speed"));
                        one_day_weather.setWind_direction(first_day_from_api.getDouble("wind_direction"));
                        one_day_weather.setAir_pressure(first_day_from_api.getDouble("air_pressure"));
                        one_day_weather.setHumidity(first_day_from_api.getInt("humidity"));
                        one_day_weather.setVisibility(first_day_from_api.getDouble("visibility"));
                        one_day_weather.setPredictability(first_day_from_api.getInt("predictability"));

                        weatherReportModels.add(one_day_weather);

                    }

                    forcastById.OnResponse(weatherReportModels);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               Toast.makeText(context, "Something went wrong ", Toast.LENGTH_SHORT).show();
                forcastById.onError("Somwthing went wrong");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);

    }

    @NonNull
    private String getUrl2() {
        return "https://www.metaweather.com/api/location/";
    }


    @NonNull
    private String getUrl() {
        return "https://www.metaweather.com/api/location/search/?query=";
    }
}
