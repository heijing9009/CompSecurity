// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.c;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.er;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.drive.internal:
//            s, u, DisconnectRequest, AddEventListenerRequest, 
//            ak, RemoveEventListenerRequest

public class n extends eh
{

    private DriveId DA;
    final com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks DB;
    Map DC;
    private DriveId Dz;
    private final String vi;

    public n(Context context, Looper looper, ee ee1, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, String as[])
    {
        super(context, looper, connectioncallbacks, onconnectionfailedlistener, as);
        DC = new HashMap();
        vi = (String)er.b(ee1.dR(), "Must call Api.ClientBuilder.setAccountName()");
        DB = connectioncallbacks;
    }

    protected u C(IBinder ibinder)
    {
        return u.a.D(ibinder);
    }

    PendingResult a(GoogleApiClient googleapiclient, DriveId driveid, int i, com.google.android.gms.drive.events.DriveEvent.Listener listener)
    {
        er.b(c.a(i, driveid), "id");
        er.b(listener, "listener");
        er.a(isConnected(), "Client must be connected");
        Map map1 = DC;
        map1;
        JVM INSTR monitorenter ;
        Map map = (Map)DC.get(driveid);
        Object obj;
        obj = map;
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        obj = new HashMap();
        DC.put(driveid, obj);
        if (!((Map) (obj)).containsKey(listener))
        {
            break MISSING_BLOCK_LABEL_110;
        }
        googleapiclient = new l.k(Status.zQ);
        map1;
        JVM INSTR monitorexit ;
        return googleapiclient;
        s s1 = new s(getLooper(), i, listener);
        ((Map) (obj)).put(listener, s1);
        googleapiclient = googleapiclient.b(new l.j(driveid, i, s1) {

            final DriveId DD;
            final int DE;
            final s DF;
            final n DG;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((n)a1);
            }

            protected void a(n n1)
                throws RemoteException
            {
                n1.eT().a(new AddEventListenerRequest(DD, DE), DF, null, new ak(this));
            }

            
            {
                DG = n.this;
                DD = driveid;
                DE = i;
                DF = s1;
                super();
            }
        });
        map1;
        JVM INSTR monitorexit ;
        return googleapiclient;
        googleapiclient;
        map1;
        JVM INSTR monitorexit ;
        throw googleapiclient;
    }

    protected void a(int i, IBinder ibinder, Bundle bundle)
    {
        if (bundle != null)
        {
            bundle.setClassLoader(getClass().getClassLoader());
            Dz = (DriveId)bundle.getParcelable("com.google.android.gms.drive.root_id");
            DA = (DriveId)bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.a(i, ibinder, bundle);
    }

    protected void a(en en1, com.google.android.gms.internal.eh.e e)
        throws RemoteException
    {
        String s1 = getContext().getPackageName();
        er.f(e);
        er.f(s1);
        er.f(ea());
        en1.a(e, 0x41f6b8, s1, ea(), vi, new Bundle());
    }

    protected String aF()
    {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String aG()
    {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    PendingResult b(GoogleApiClient googleapiclient, DriveId driveid, int i, com.google.android.gms.drive.events.DriveEvent.Listener listener)
    {
        er.b(c.a(i, driveid), "id");
        er.b(listener, "listener");
        er.a(isConnected(), "Client must be connected");
        Map map = DC;
        map;
        JVM INSTR monitorenter ;
        Map map1 = (Map)DC.get(driveid);
        if (map1 != null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        googleapiclient = new l.k(Status.zQ);
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
        listener = (s)map1.remove(listener);
        if (listener != null)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        googleapiclient = new l.k(Status.zQ);
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
        googleapiclient;
        map;
        JVM INSTR monitorexit ;
        throw googleapiclient;
        if (map1.isEmpty())
        {
            DC.remove(driveid);
        }
        googleapiclient = googleapiclient.b(new l.j(driveid, i, listener) {

            final DriveId DD;
            final int DE;
            final s DF;
            final n DG;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((n)a1);
            }

            protected void a(n n1)
                throws RemoteException
            {
                n1.eT().a(new RemoveEventListenerRequest(DD, DE), DF, null, new ak(this));
            }

            
            {
                DG = n.this;
                DD = driveid;
                DE = i;
                DF = s1;
                super();
            }
        });
        map;
        JVM INSTR monitorexit ;
        return googleapiclient;
    }

    public void disconnect()
    {
        u u1 = (u)eb();
        if (u1 != null)
        {
            try
            {
                u1.a(new DisconnectRequest());
            }
            catch (RemoteException remoteexception) { }
        }
        super.disconnect();
        DC.clear();
    }

    public u eT()
    {
        return (u)eb();
    }

    public DriveId eU()
    {
        return Dz;
    }

    public DriveId eV()
    {
        return DA;
    }

    protected IInterface p(IBinder ibinder)
    {
        return C(ibinder);
    }
}
