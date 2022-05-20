package com.lb.study.binder;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lb.study.binder.remoteServer.IStudentManager;
import com.lb.study.binder.remoteServer.StudentManager;

/**
 * 需要先安装远程服务 reniteserver
 * 远程服务测试
 */
public class RemoteBinderServerActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvContent;
    private IStudentManager studentManager;
    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            tvContent.setText("链接成功");
            studentManager = new StudentManager(service);//如果是同一个进程绑定 service对象就是binder类型对象

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            tvContent.setText("链接断开");
            studentManager = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remote_binder_server_activity);
        tvContent = findViewById(R.id.tv_content);
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button) {
            Intent intent = new Intent();
            intent.setPackage("com.lb.study.remoteserver");
            intent.setAction("com.lb.study.StudentServer");
            boolean b = bindService(intent, connection, BIND_AUTO_CREATE);
            tvContent.setText(String.format("绑定服务 state:%b", b));
        } else if (id == R.id.button2) {
            unbindService(connection);
            tvContent.setText("解除绑定");
        } else if(id == R.id.button4){
            if(studentManager != null){
                try {
                    String studentName = studentManager.getStudentName(0);
                    tvContent.setText(studentName);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    tvContent.setText(e.getMessage());
                }
            }else{
                tvContent.setText("服务没有绑定");
            }
        }
    }
}