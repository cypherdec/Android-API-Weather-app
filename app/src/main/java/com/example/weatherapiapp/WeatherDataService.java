package com.example.weatherapiapp;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataService {

    public static final String QUERY = "https://www.metaweather.com/api/location/search/?query=";
    Context context ;
    String cityID;

    public WeatherDataService(Context context) {
        this.context = context;
    }

    public String getCityID(String cityName){

        String url = QUERY + cityName; //get url with city

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() { //get json array from api
            @Override
            public void onResponse(JSONArray response) {
                cityID = "";
                try {
                    JSONObject cityInfo = response.getJSONObject(0);  //get json object from array
                    cityID = cityInfo.getString("woeid"); //object  has city id as woeid. so get this from the json object and store in a string called cityID

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(context, "city ID = " + cityID, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "error ", Toast.LENGTH_SHORT).show();
            }
        });

        // Add a request (in this example, called stringRequest) to your RequestQueue.
        MySingleton.getInstance(context).addToRequestQueue(request);

        return cityID;
    }

    /*public List<WeatherReportModel> getCityForecastByID(String cityID){

    }

    public List<WeatherReportModel> getCityForecastByName(String cityName{

    }
*/

}

