package com.example.najo.ipaddresslocator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {

    TextView country , longitude , latitude ;
    EditText addr;
    Button button , fecthadd ;
    Intent mapIntent;
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        country = findViewById(R.id.country);
        longitude = findViewById(R.id.longitude);
        latitude = findViewById(R.id.latitude);
        button = findViewById(R.id.maps);
        addr = findViewById(R.id.address);
        fecthadd = findViewById(R.id.fetchdata);

        mapIntent = new Intent(this , MapsActivity.class );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mapIntent);
            }
        });

        fecthadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Main2Activity.this, addr.getText().toString() , Toast.LENGTH_SHORT).show();
                fetchLocation(addr.getText().toString());
            }
        });
    }

    private void fetchLocation(String addr) {
        Toast.makeText(this, addr, Toast.LENGTH_SHORT).show();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ipfind.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LocatorApi locatorApi = retrofit.create(LocatorApi.class);
        Call<IPAddressLocator> call = locatorApi.getLocation(addr);

        call.enqueue(new Callback<IPAddressLocator>() {
            @Override
            public void onResponse(Call<IPAddressLocator> call, Response<IPAddressLocator> response) {
                IPAddressLocator locator = response.body();
                if(locator != null){
                    String longti = String.valueOf(locator.getLongitude());
                    String latitu = String.valueOf(locator.getLatitude());
                    country.setText(locator.getCountry());
                    longitude.setText(longti);
                    latitude.setText(latitu);
                    Double longi = Double.parseDouble(longti);
                    Double lati = Double.parseDouble(latitu);

                    mapIntent.putExtra("longitude" , longi);
                    mapIntent.putExtra("latitude" , lati);

                    Toast.makeText(Main2Activity.this, "LOADED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<IPAddressLocator> call, Throwable t) {
                Toast.makeText(Main2Activity.this, "FAILED TO LOAD", Toast.LENGTH_LONG).show();
            }
        });
    }
}