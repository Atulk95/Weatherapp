package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    Button getcityid,bycityid,bycityname;
    EditText input;
    ListView weatherlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getcityid=findViewById(R.id.getcityid);
        bycityid=findViewById(R.id.bycityid);
        bycityname=findViewById(R.id.bycityname);
        input=findViewById(R.id.input);
        weatherlist=findViewById(R.id.weatherlist);

        WeatherDataService weatherDataService=new WeatherDataService(MainActivity.this);

        getcityid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               weatherDataService.getCityId(input.getText().toString(), new WeatherDataService.volleyResponseListener() {
                   @Override
                   public void onError(String message) {
                       Toast.makeText(MainActivity.this, "Something Went wrong", Toast.LENGTH_SHORT).show();
                   }

                   @Override
                   public void onResponse(String cityid) {
                       Toast.makeText(MainActivity.this, "Returned id is "+cityid, Toast.LENGTH_SHORT).show();
                   }
               });

            }
        });
        bycityid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weatherDataService.getForcastByCityId(input.getText().toString(), new WeatherDataService.ForcastById() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void OnResponse(List<WeatherReportModel> weatherReportModels) {
                        ArrayAdapter arr=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,weatherReportModels);
                        weatherlist.setAdapter(arr);

                    }
                });
            }
        });
        bycityname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                weatherDataService.getCityId(input.getText().toString(), new WeatherDataService.volleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(MainActivity.this, "Something Went wrong", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String cityid) {

                        weatherDataService.getForcastByCityId(cityid, new WeatherDataService.ForcastById() {
                            @Override
                            public void onError(String message) {
                                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void OnResponse(List<WeatherReportModel> weatherReportModels) {
                                ArrayAdapter arr=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,weatherReportModels);
                                weatherlist.setAdapter(arr);

                            }
                        });

                    }
                });




            }
        });
        
        
    }
}