package com.lb.study.binder.server;

import static android.os.IBinder.FIRST_CALL_TRANSACTION;

import android.os.IInterface;
import android.os.RemoteException;

/**
 * binder通信接口需要实现IInterface这个通用接口
 */
public interface IBookManager extends IInterface {
    String DESCRIPTION = "com.lb.study.BookManager";
    int MONTH_GET_BOOK_NAME = FIRST_CALL_TRANSACTION + 1;

    String getBookName(int position) throws RemoteException;
}
