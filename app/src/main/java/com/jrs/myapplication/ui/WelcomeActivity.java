package com.jrs.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.LocaleManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jrs.myapplication.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.jar.Pack200;

import application.MyApplication;

public class WelcomeActivity extends AppCompatActivity {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private MyApplication mApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mApplication = (MyApplication) getApplication();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            //请求权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        }else {
            // 权限已授予，开始获取位置
            getLocation();
        }
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private void getLocation() {
        LocaleManager localeManager = (LocaleManager) getSystemService(Context.LOCATION_SERVICE);
        Locale lastKnowLocaltion = localeManager.
    }

    private void getAddressFromLocation(Location location) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        try {
            List<Address> addresses = geocoder.getFromLocation(
                    location.getLatitude(),
                    location.getLongitude(),
                    1);

            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                String addressString = address.getAddressLine(0);

                // 处理获取到的地址信息
                Log.d("Address", "Current Address: " + addressString);
                Toast.makeText(this, "Current Address: " + addressString, Toast.LENGTH_LONG).show();
            } else {
                Log.d("Address", "Unable to get address for the location");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            // 位置更新时调用
            getAddressFromLocation(location);

            // 停止位置更新，因为我们只需要一次
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.removeUpdates(this);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // 状态更改时调用
        }

        @Override
        public void onProviderEnabled(String provider) {
            // 提供者启用时调用
        }

        @Override
        public void onProviderDisabled(String provider) {
            // 提供者禁用时调用
        }
    };
}