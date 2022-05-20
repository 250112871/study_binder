package com.lb.study.binder.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class BookServer extends Service {
    private final BinderStub stub = new BinderStub() {
        @Override
        public String getBookName(int position) {
            if (position == 0) {
                return "binder原理分析 本地服务";
            } else {
                return "binder案例分析 本地服务";
            }
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }
}
