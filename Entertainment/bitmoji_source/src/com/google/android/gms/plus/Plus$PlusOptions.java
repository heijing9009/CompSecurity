// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus;

import com.google.android.gms.internal.er;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus:
//            Plus

public static final class Builder
    implements com.google.android.gms.common.api.piOptions
{
    public static final class Builder
    {

        String QL;
        final Set QM = new HashSet();

        public transient Builder addActivityTypes(String as[])
        {
            er.b(as, "activityTypes may not be null.");
            for (int i = 0; i < as.length; i++)
            {
                QM.add(as[i]);
            }

            return this;
        }

        public Plus.PlusOptions build()
        {
            return new Plus.PlusOptions(this, null);
        }

        public Builder setServerClientId(String s)
        {
            QL = s;
            return this;
        }

        public Builder()
        {
        }
    }


    final String QL;
    final Set QM;

    public static Builder builder()
    {
        return new Builder();
    }

    private Builder()
    {
        QL = null;
        QM = new HashSet();
    }

    QM(QM qm)
    {
        this();
    }

    private Builder(Builder builder1)
    {
        QL = builder1.QL;
        QM = builder1.QM;
    }

    Builder(Builder builder1, Builder builder2)
    {
        this(builder1);
    }
}
