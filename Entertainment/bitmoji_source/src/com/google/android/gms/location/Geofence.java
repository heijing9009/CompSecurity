// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.hj;

public interface Geofence
{
    public static final class Builder
    {

        private String Hh;
        private int KU;
        private long KV;
        private short KW;
        private double KX;
        private double KY;
        private float KZ;
        private int La;
        private int Lb;

        public Geofence build()
        {
            if (Hh == null)
            {
                throw new IllegalArgumentException("Request ID not set.");
            }
            if (KU == 0)
            {
                throw new IllegalArgumentException("Transitions types not set.");
            }
            if ((KU & 4) != 0 && Lb < 0)
            {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            }
            if (KV == 0x8000000000000000L)
            {
                throw new IllegalArgumentException("Expiration not set.");
            }
            if (KW == -1)
            {
                throw new IllegalArgumentException("Geofence region not set.");
            }
            if (La < 0)
            {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            } else
            {
                return new hj(Hh, KU, (short)1, KX, KY, KZ, KV, La, Lb);
            }
        }

        public Builder setCircularRegion(double d, double d1, float f)
        {
            KW = 1;
            KX = d;
            KY = d1;
            KZ = f;
            return this;
        }

        public Builder setExpirationDuration(long l)
        {
            if (l < 0L)
            {
                KV = -1L;
                return this;
            } else
            {
                KV = SystemClock.elapsedRealtime() + l;
                return this;
            }
        }

        public Builder setLoiteringDelay(int i)
        {
            Lb = i;
            return this;
        }

        public Builder setNotificationResponsiveness(int i)
        {
            La = i;
            return this;
        }

        public Builder setRequestId(String s)
        {
            Hh = s;
            return this;
        }

        public Builder setTransitionTypes(int i)
        {
            KU = i;
            return this;
        }

        public Builder()
        {
            Hh = null;
            KU = 0;
            KV = 0x8000000000000000L;
            KW = -1;
            La = 0;
            Lb = -1;
        }
    }


    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1L;

    public abstract String getRequestId();
}
