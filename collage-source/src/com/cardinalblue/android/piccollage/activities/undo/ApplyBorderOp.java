// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cardinalblue.android.piccollage.activities.undo;

import android.os.Parcel;
import com.cardinalblue.android.piccollage.activities.undo.a.a;
import com.cardinalblue.android.piccollage.controller.d;
import com.squareup.a.b;

public class ApplyBorderOp extends com.cardinalblue.android.piccollage.UndoManager.UndoOperation
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ApplyBorderOp a(Parcel parcel)
        {
            return new ApplyBorderOp(parcel);
        }

        public ApplyBorderOp[] a(int i)
        {
            return new ApplyBorderOp[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private final long a;
    private final int b;
    private final int c;

    public ApplyBorderOp(long l, int i, int j)
    {
        a = l;
        b = i;
        c = j;
    }

    protected ApplyBorderOp(Parcel parcel)
    {
        a = parcel.readLong();
        b = parcel.readInt();
        c = parcel.readInt();
    }

    public void b()
    {
    }

    public void c()
    {
        com.cardinalblue.android.piccollage.controller.d.a().c(new a(a, b));
    }

    public void d()
    {
        com.cardinalblue.android.piccollage.controller.d.a().c(new a(a, c));
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(a);
        parcel.writeInt(b);
        parcel.writeInt(c);
    }

}
