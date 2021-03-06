// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

// Referenced classes of package com.google.android.gms.maps:
//            StreetViewPanorama, StreetViewPanoramaOptions, OnStreetViewPanoramaReadyCallback

public class StreetViewPanoramaView extends FrameLayout
{

    private StreetViewPanorama zzaJj;
    private final zzb zzaJv;

    public StreetViewPanoramaView(Context context)
    {
        super(context);
        zzaJv = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        zzaJv = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        zzaJv = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetviewpanoramaoptions)
    {
        super(context);
        zzaJv = new zzb(this, context, streetviewpanoramaoptions);
    }

    public final StreetViewPanorama getStreetViewPanorama()
    {
        if (zzaJj != null)
        {
            return zzaJj;
        }
        zzaJv.zzxL();
        if (zzaJv.zzrZ() == null)
        {
            return null;
        }
        try
        {
            zzaJj = new StreetViewPanorama(((zza)zzaJv.zzrZ()).zzxS().getStreetViewPanorama());
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return zzaJj;
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
    {
        zzx.zzci("getStreetViewPanoramaAsync() must be called on the main thread");
        zzaJv.getStreetViewPanoramaAsync(onstreetviewpanoramareadycallback);
    }

    public final void onCreate(Bundle bundle)
    {
        zzaJv.onCreate(bundle);
        if (zzaJv.zzrZ() == null)
        {
            com.google.android.gms.dynamic.zza.zzb(this);
        }
    }

    public final void onDestroy()
    {
        zzaJv.onDestroy();
    }

    public final void onLowMemory()
    {
        zzaJv.onLowMemory();
    }

    public final void onPause()
    {
        zzaJv.onPause();
    }

    public final void onResume()
    {
        zzaJv.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        zzaJv.onSaveInstanceState(bundle);
    }

    private class zzb extends com.google.android.gms.dynamic.zza
    {

        private final Context mContext;
        protected zzf zzaIS;
        private final ViewGroup zzaIZ;
        private final List zzaJn = new ArrayList();
        private final StreetViewPanoramaOptions zzaJz;

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
        {
            if (zzrZ() != null)
            {
                ((zza)zzrZ()).getStreetViewPanoramaAsync(onstreetviewpanoramareadycallback);
                return;
            } else
            {
                zzaJn.add(onstreetviewpanoramareadycallback);
                return;
            }
        }

        protected void zza(zzf zzf1)
        {
            zzaIS = zzf1;
            zzxL();
        }

        public void zzxL()
        {
            if (zzaIS == null || zzrZ() != null)
            {
                break MISSING_BLOCK_LABEL_121;
            }
            try
            {
                IStreetViewPanoramaViewDelegate istreetviewpanoramaviewdelegate = zzy.zzaG(mContext).zza(zze.zzy(mContext), zzaJz);
                zzaIS.zza(new zza(zzaIZ, istreetviewpanoramaviewdelegate));
                OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback;
                for (Iterator iterator = zzaJn.iterator(); iterator.hasNext(); ((zza)zzrZ()).getStreetViewPanoramaAsync(onstreetviewpanoramareadycallback))
                {
                    onstreetviewpanoramareadycallback = (OnStreetViewPanoramaReadyCallback)iterator.next();
                }

            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
            catch (GooglePlayServicesNotAvailableException googleplayservicesnotavailableexception)
            {
                return;
            }
            zzaJn.clear();
        }

        zzb(ViewGroup viewgroup, Context context, StreetViewPanoramaOptions streetviewpanoramaoptions)
        {
            zzaIZ = viewgroup;
            mContext = context;
            zzaJz = streetviewpanoramaoptions;
        }
    }


    private class zza
        implements StreetViewLifecycleDelegate
    {

        private final ViewGroup zzaIV;
        private final IStreetViewPanoramaViewDelegate zzaJw;
        private View zzaJx;

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
        {
            try
            {
                class _cls1 extends com.google.android.gms.maps.internal.zzv.zza
                {

                    final OnStreetViewPanoramaReadyCallback zzaJl;
                    final zza zzaJy;

                    public void zza(IStreetViewPanoramaDelegate istreetviewpanoramadelegate)
                    {
                        zzaJl.onStreetViewPanoramaReady(new StreetViewPanorama(istreetviewpanoramadelegate));
                    }

                _cls1(OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
                {
                    zzaJy = zza.this;
                    zzaJl = onstreetviewpanoramareadycallback;
                    super();
                }
                }

                zzaJw.getStreetViewPanoramaAsync(new _cls1(onstreetviewpanoramareadycallback));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
            {
                throw new RuntimeRemoteException(onstreetviewpanoramareadycallback);
            }
        }

        public void onCreate(Bundle bundle)
        {
            try
            {
                zzaJw.onCreate(bundle);
                zzaJx = (View)zze.zzp(zzaJw.getView());
                zzaIV.removeAllViews();
                zzaIV.addView(zzaJx);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new RuntimeRemoteException(bundle);
            }
        }

        public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
        {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy()
        {
            try
            {
                zzaJw.onDestroy();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onDestroyView()
        {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onInflate(Activity activity, Bundle bundle, Bundle bundle1)
        {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onLowMemory()
        {
            try
            {
                zzaJw.onLowMemory();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onPause()
        {
            try
            {
                zzaJw.onPause();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onResume()
        {
            try
            {
                zzaJw.onResume();
                return;
            }
            catch (RemoteException remoteexception)
            {
                throw new RuntimeRemoteException(remoteexception);
            }
        }

        public void onSaveInstanceState(Bundle bundle)
        {
            try
            {
                zzaJw.onSaveInstanceState(bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                throw new RuntimeRemoteException(bundle);
            }
        }

        public void onStart()
        {
        }

        public void onStop()
        {
        }

        public IStreetViewPanoramaViewDelegate zzxS()
        {
            return zzaJw;
        }

        public zza(ViewGroup viewgroup, IStreetViewPanoramaViewDelegate istreetviewpanoramaviewdelegate)
        {
            zzaJw = (IStreetViewPanoramaViewDelegate)zzx.zzw(istreetviewpanoramaviewdelegate);
            zzaIV = (ViewGroup)zzx.zzw(viewgroup);
        }
    }

}
