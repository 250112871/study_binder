package com.lb.study.remoteserver.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 远程服务测试
 */
public abstract class BinderStub extends Binder implements IStudentManager {

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
        Log.i("remoteServer", "BinderStub onTransact code:" + code);
        switch (code) {
            case 0:
                if (reply != null) {
                    reply.writeInterfaceToken(DESCRIPTION);
                }
                return true;
            case MONTH_GET_STUDENT_NAME:
                data.enforceInterface(DESCRIPTION); //进行签名比对 只有匹配上 后续的参数才能正确匹配
                int i = data.readInt();
                Log.i("remoteServer", "onTransact params:" + i);
                String studentName = getStudentName(i);
                if (reply != null) {
                    reply.writeString(studentName);
                }
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
