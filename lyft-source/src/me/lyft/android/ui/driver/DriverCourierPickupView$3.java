// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.ui.driver;

import android.view.View;
import me.lyft.android.domain.ride.Passenger;

// Referenced classes of package me.lyft.android.ui.driver:
//            DriverCourierPickupView

class this._cls0
    implements android.view.PickupView._cls3
{

    final DriverCourierPickupView this$0;

    public void onClick(View view)
    {
        DriverCourierPickupView.access$200(DriverCourierPickupView.this, Integer.valueOf(DriverCourierPickupView.access$000(DriverCourierPickupView.this).getPartySize()));
    }

    _cls9()
    {
        this$0 = DriverCourierPickupView.this;
        super();
    }
}
