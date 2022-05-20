package com.lb.study.binder.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 为BookServerByBinder服务 客户端不能通过此Binder对象转成IBookManager
 */
public abstract class BinderStub extends Binder implements IBookManager {

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case 0:
                if (reply != null) {
                    reply.writeInterfaceToken(DESCRIPTION);
                }
                return true;
            case MONTH_GET_BOOK_NAME:
                int i = data.readInt();
                String bookName = getBookName(i);
                if (reply != null) {
                    reply.writeString(bookName);
                }
                return true;
            default:
                return super.onTransact(code, data, reply, flags);
        }
    }
}
