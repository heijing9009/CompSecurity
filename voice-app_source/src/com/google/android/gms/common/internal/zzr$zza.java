// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzr

public static abstract class zza.zznF extends Binder
    implements zzr
{
    private static class zza
        implements zzr
    {

        private IBinder zznF;

        public IBinder asBinder()
        {
            return zznF;
        }

        public zzd zza(zzd zzd1, int i, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
            if (zzd1 == null)
            {
                break MISSING_BLOCK_LABEL_88;
            }
            zzd1 = zzd1.asBinder();
_L1:
            parcel.writeStrongBinder(zzd1);
            parcel.writeInt(i);
            parcel.writeInt(j);
            zznF.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            zzd1 = com.google.android.gms.dynamic.zzd.zza.zzbg(parcel1.readStrongBinder());
            parcel1.recycle();
            parcel.recycle();
            return zzd1;
            zzd1 = null;
              goto _L1
            zzd1;
            parcel1.recycle();
            parcel.recycle();
            throw zzd1;
        }

        zza(IBinder ibinder)
        {
            zznF = ibinder;
        }
    }


    public static zzr zzaI(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (iinterface != null && (iinterface instanceof zzr))
        {
            return (zzr)iinterface;
        } else
        {
            return new zza(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            parcel = zza(com.google.android.gms.dynamic.zzbg(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            break;
        }
        if (parcel != null)
        {
            parcel = parcel.asBinder();
        } else
        {
            parcel = null;
        }
        parcel1.writeStrongBinder(parcel);
        return true;
    }
}
