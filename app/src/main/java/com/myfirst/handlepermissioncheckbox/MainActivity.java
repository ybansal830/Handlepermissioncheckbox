package com.myfirst.handlepermissioncheckbox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int REQUEST_CODE = 1;
    private Button mBtOne;
    private int requestCode;
    private String[] permissions;
    private int[] grantResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtOne = findViewById(R.id.btOne);
        mBtOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permission = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this,permission,REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            Toast.makeText(MainActivity.this,"Camera Permission Granted",Toast.LENGTH_SHORT).show();
        else{
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,permissions[0]))
                Toast.makeText(MainActivity.this,"Permission Denied",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this,"Permission denied\n" +
                        "by clicking Dont show\n" +
                        "again , please go to\n" +
                        " settings and enable\n" +
                        "the permission",Toast.LENGTH_SHORT).show();
        }
    }
}