package com.lb.study.binder.remoteServer;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

/**
 * 适应跨进程绑定服务
 * 因为实现的是客户端的IBookManager对象同服务端的IBookManager并不是同一个对象 所以需要通过IBinder的transact()方法同服务端通信
 */
public class StudentManager implements IStudentManager {
    IBinder mBinder;

    public StudentManager(IBinder binder) {
        mBinder = binder;
    }

    @Override
    public String getStudentName(int position) throws RemoteException {
        Parcel in = Parcel.obtain();
        Parcel out = Parcel.obtain();
        in.writeInterfaceToken(DESCRIPTION);
        in.writeInt(position);
        Log.i("remoteServer","getStudentName position:"+position);
        mBinder.transact(MONTH_GET_STUDENT_NAME, in, out, 0/*FLAG_ONEWAY */);//0阻塞线程  FLAG_ONEWAY 异步调用
        String bookName = out.readString();
        Log.i("remoteServer"," client getStudentName:"+bookName);
        in.recycle();
        out.recycle();
        return bookName;
    }

    @Override
    public IBinder asBinder() {
        return mBinder;
    }
}
