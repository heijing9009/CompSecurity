// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.content.DialogInterface;
import com.ebay.common.model.cart.Cart;

// Referenced classes of package com.ebay.mobile.checkout:
//            CheckoutActivity

class this._cls0
    implements android.content.lickListener
{

    final CheckoutActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        enableProgressDialog(true, false);
        apiRefreshCart(cart.cartId);
    }

    ner()
    {
        this$0 = CheckoutActivity.this;
        super();
    }
}
