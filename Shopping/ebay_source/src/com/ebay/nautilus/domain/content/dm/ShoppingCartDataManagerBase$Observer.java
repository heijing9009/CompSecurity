// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShoppingCartDataManagerBase

public static interface 
{

    public abstract void onCheckoutSessionComplete(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, Content content);

    public abstract void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase,  , Content content);

    public abstract void onShoppingCartLoading(ShoppingCartDataManagerBase shoppingcartdatamanagerbase,  );
}
