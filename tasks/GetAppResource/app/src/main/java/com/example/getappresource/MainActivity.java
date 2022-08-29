package com.example.getappresource;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView displayResource = (TextView) findViewById(R.id.sharedRes);
        try {
            Context sharedResource = this.createPackageContext("com.example.sendmessage", Context.CONTEXT_IGNORE_SECURITY);
            int resourceId = sharedResource.getResources().getIdentifier("app_string_resource","string","com.example.sendmessage");
            String app1Resource = sharedResource.getResources().getString(resourceId).toString();
            displayResource.setText(app1Resource);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}