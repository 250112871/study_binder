package com.lb.study.binder.remoteServer;

import static android.os.IBinder.FIRST_CALL_TRANSACTION;

import android.os.IInterface;
import android.os.RemoteException;

/**
 * 远程服务提供的接口
 * packageName:com.lb.study.remoteserver
 * action:com.lb.study.StudentServer
 */
public interface IStudentManager extends IInterface {
    String DESCRIPTION = "com.lb.study.StudentManager";
    int MONTH_GET_STUDENT_NAME = FIRST_CALL_TRANSACTION + 1;

    String getStudentName(int position) throws RemoteException;
}
