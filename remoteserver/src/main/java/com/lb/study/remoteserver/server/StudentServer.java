package com.lb.study.remoteserver.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class StudentServer extends Service {
    private final BinderStub stub = new BinderStub() {
        @Override
        public String getStudentName(int position) {
            Log.i("remoteServer","StudentServer getStudentName position:"+position);
            if (position == 0) {
                return "0号学生 远程服务返回";
            } else {
                return position + "号学生 远程服务返回";
            }
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
}
