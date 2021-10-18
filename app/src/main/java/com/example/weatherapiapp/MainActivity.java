package com.example.weatherapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    Button btnCity, btnWeatherID, btnWeatherName;
    EditText etData;
    ListView lvReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assign values to each control in the layout
        btnCity = findViewById(R.id.btn_getCityID);
        btnWeatherID = findViewById(R.id.btn_getWeatherByCityID);
        btnWeatherName = findViewById(R.id.btn_getWeatherByCityName);
        etData = findViewById(R.id.et_dataInput);
        lvReport = findViewById(R.id.lv_weatherReports);


        //set on click listeners// these are called anonymous functions, they don't have a name , just an in line definition
        btnCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WeatherDataService weatherDataService = new WeatherDataService(MainActivity.this);

                String cityID = weatherDataService.getCityID(etData.getText().toString());
                Toast.makeText(MainActivity.this, "id = " + cityID, Toast.LENGTH_SHORT).show();

            }
        });

        btnWeatherID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnWeatherName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}