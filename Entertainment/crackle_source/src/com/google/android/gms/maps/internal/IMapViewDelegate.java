// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

// Referenced classes of package com.google.android.gms.maps.internal:
//            IGoogleMapDelegate

public interface IMapViewDelegate
    extends IInterface
{
    public static abstract class a extends Binder
        implements IMapViewDelegate
    {

        public static IMapViewDelegate V(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            if (iinterface != null && (iinterface instanceof IMapViewDelegate))
            {
                return (IMapViewDelegate)iinterface;
            } else
            {
                return new a(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            Object obj1 = null;
            Object obj2 = null;
            IGoogleMapDelegate igooglemapdelegate = null;
            Object obj = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.maps.internal.IMapViewDelegate");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                igooglemapdelegate = getMap();
                parcel1.writeNoException();
                parcel = ((Parcel) (obj));
                if (igooglemapdelegate != null)
                {
                    parcel = igooglemapdelegate.asBinder();
                }
                parcel1.writeStrongBinder(parcel);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                obj = obj1;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                onCreate(((Bundle) (obj)));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                onResume();
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                onPause();
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                onDestroy();
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                onLowMemory();
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                obj = obj2;
                if (parcel.readInt() != 0)
                {
                    obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                onSaveInstanceState(((Bundle) (obj)));
                parcel1.writeNoException();
                if (obj != null)
                {
                    parcel1.writeInt(1);
                    ((Bundle) (obj)).writeToParcel(parcel1, 1);
                } else
                {
                    parcel1.writeInt(0);
                }
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
                obj = getView();
                parcel1.writeNoException();
                parcel = igooglemapdelegate;
                break;
            }
            if (obj != null)
            {
                parcel = ((b) (obj)).asBinder();
            }
            parcel1.writeStrongBinder(parcel);
            return true;
        }
    }

    private static class a.a
        implements IMapViewDelegate
    {

        private IBinder dU;

        public IBinder asBinder()
        {
            return dU;
        }

        public IGoogleMapDelegate getMap()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            IGoogleMapDelegate igooglemapdelegate;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            dU.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            igooglemapdelegate = IGoogleMapDelegate.a.R(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return igooglemapdelegate;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public b getView()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            b b;
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            dU.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            b = com.google.android.gms.dynamic.b.a.E(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return b;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void onCreate(Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L1:
            dU.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            bundle;
            parcel1.recycle();
            parcel.recycle();
            throw bundle;
        }

        public void onDestroy()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            dU.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void onLowMemory()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            dU.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void onPause()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            dU.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void onResume()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            dU.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public void onSaveInstanceState(Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L1:
            dU.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            if (parcel1.readInt() != 0)
            {
                bundle.readFromParcel(parcel1);
            }
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            bundle;
            parcel1.recycle();
            parcel.recycle();
            throw bundle;
        }

        a.a(IBinder ibinder)
        {
            dU = ibinder;
        }
    }


    public abstract IGoogleMapDelegate getMap()
        throws RemoteException;

    public abstract b getView()
        throws RemoteException;

    public abstract void onCreate(Bundle bundle)
        throws RemoteException;

    public abstract void onDestroy()
        throws RemoteException;

    public abstract void onLowMemory()
        throws RemoteException;

    public abstract void onPause()
        throws RemoteException;

    public abstract void onResume()
        throws RemoteException;

    public abstract void onSaveInstanceState(Bundle bundle)
        throws RemoteException;
}
