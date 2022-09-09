package com.example.uninstall;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String app_pkg_name = "com.example.senddata";
    int UNINSTALL_REQUEST_CODE = 1;
    ListView listView;
    List<MainData> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        PackageManager manager = getPackageManager();
        List<ApplicationInfo> infoList = manager.getInstalledApplications(
                PackageManager.GET_META_DATA
        );
        for(ApplicationInfo info: infoList){
            if(!((info.flags & ApplicationInfo.FLAG_SYSTEM ) != 0)){
                if(!(info.packageName.equals("com.example.uninstall"))){
                    MainData data = new MainData();
                    data.setName(info.loadLabel(manager).toString());
                    data.setPackageName(info.packageName);
                    data.setLogo(info.loadIcon(manager));
                    dataList.add(data);
                }
            }
        }

        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return dataList.size();
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View adapterView = getLayoutInflater().inflate(R.layout.list_row_item,null);
                MainData data = dataList.get(i);
                // Initialize and assign variable
                ImageView ivAppLogo =adapterView.findViewById(R.id.iv_app_logo);
                TextView tvAppName = adapterView.findViewById(R.id.tv_app_name);
                Button btUninstall = adapterView.findViewById(R.id.bt_uninstall);
                ivAppLogo.setImageDrawable(data.getLogo());
                tvAppName.setText(data.getName());
                btUninstall.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MainData mainData = dataList.get(i);
                        Intent intent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE);
                        intent.setData(Uri.parse("package:"+mainData.getPackageName()));
                        intent.putExtra(Intent.EXTRA_RETURN_RESULT,true);
                        startActivityForResult(intent,100);
                    }
                });
                return adapterView;
            }
        });


//        Button uninstall = (Button) findViewById(R.id.deleteApplication);
//        uninstall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
//
////
////                Intent intent = new Intent(Intent.ACTION_UNINSTALL_PACKAGE);
////                intent.setData(Uri.parse("package:" + app_pkg_name));
////                intent.putExtra(Intent.EXTRA_RETURN_RESULT, true);
////                startActivity(intent);
////                startActivityForResult(intent, UNINSTALL_REQUEST_CODE);
//
//                Intent intent = new Intent(Intent.ACTION_DELETE);
//                intent.setData(Uri.parse("package:"+app_pkg_name));
//                startActivity(intent);
//            }
//        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        recreate();
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
//            if (resultCode == RESULT_OK) {
//                Log.e("Uninstall", "onActivityResult: user accepted the (un)install");
//            } else if (resultCode == RESULT_CANCELED) {
//                Log.e("Uninstall", "onActivityResult: user canceled the (un)install");
//            } else if (resultCode == RESULT_FIRST_USER) {
//                Log.e("Uninstall", "onActivityResult: failed to (un)install");
//            }
            Toast.makeText(getApplicationContext(), "Application Uninstalled", Toast.LENGTH_SHORT).show();
            recreate();
        }else{
            Toast.makeText(getApplicationContext(), "Unable to Uninstall", Toast.LENGTH_SHORT).show();
        }
    }
}