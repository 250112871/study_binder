package com.lb.study.binder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_local_binder).setOnClickListener(this);
        findViewById(R.id.bt_remote_binder).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_local_binder) {
            Intent intent = new Intent(this, LocalBinderServerActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.bt_remote_binder){
            Intent intent = new Intent(this, RemoteBinderServerActivity.class);
            startActivity(intent);
        }
    }
}