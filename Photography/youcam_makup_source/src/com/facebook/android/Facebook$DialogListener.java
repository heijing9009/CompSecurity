// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.android;

import android.os.Bundle;

// Referenced classes of package com.facebook.android:
//            DialogError, FacebookError

public interface 
{

    public abstract void onCancel();

    public abstract void onComplete(Bundle bundle);

    public abstract void onError(DialogError dialogerror);

    public abstract void onFacebookError(FacebookError facebookerror);
}
