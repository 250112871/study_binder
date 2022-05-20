package com.lb.study.remoteserver.server;

import static android.os.IBinder.FIRST_CALL_TRANSACTION;

import android.os.IInterface;
import android.os.RemoteException;

/**
 * binder通信接口需要实现IInterface这个通用接口
 */
public interface IStudentManager extends IInterface {
    String DESCRIPTION = "com.lb.study.StudentManager";
    int MONTH_GET_STUDENT_NAME = FIRST_CALL_TRANSACTION + 1;

    String getStudentName(int position) throws RemoteException;
}
