// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import android.content.res.Configuration;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.view.KeyEvent;

// Referenced classes of package com.google.android.youtube.player.internal:
//            d, e, h, g, 
//            f, u

public abstract class a extends Binder
    implements d
{

    public static d a(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
        class a
            implements d
        {

            private IBinder a;

            public final void a()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(8, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void a(int i1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeInt(i1);
                a.transact(17, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void a(Configuration configuration)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                if (configuration == null)
                {
                    break MISSING_BLOCK_LABEL_57;
                }
                parcel.writeInt(1);
                configuration.writeToParcel(parcel, 0);
_L1:
                a.transact(32, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                parcel.writeInt(0);
                  goto _L1
                configuration;
                parcel1.recycle();
                parcel.recycle();
                throw configuration;
            }

            public final void a(e e1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                if (e1 == null)
                {
                    break MISSING_BLOCK_LABEL_58;
                }
                e1 = e1.asBinder();
_L1:
                parcel.writeStrongBinder(e1);
                a.transact(26, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                e1 = null;
                  goto _L1
                e1;
                parcel1.recycle();
                parcel.recycle();
                throw e1;
            }

            public final void a(f f1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                if (f1 == null)
                {
                    break MISSING_BLOCK_LABEL_58;
                }
                f1 = f1.asBinder();
_L1:
                parcel.writeStrongBinder(f1);
                a.transact(29, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                f1 = null;
                  goto _L1
                f1;
                parcel1.recycle();
                parcel.recycle();
                throw f1;
            }

            public final void a(g g1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                if (g1 == null)
                {
                    break MISSING_BLOCK_LABEL_58;
                }
                g1 = g1.asBinder();
_L1:
                parcel.writeStrongBinder(g1);
                a.transact(28, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                g1 = null;
                  goto _L1
                g1;
                parcel1.recycle();
                parcel.recycle();
                throw g1;
            }

            public final void a(h h1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                if (h1 == null)
                {
                    break MISSING_BLOCK_LABEL_58;
                }
                h1 = h1.asBinder();
_L1:
                parcel.writeStrongBinder(h1);
                a.transact(27, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                h1 = null;
                  goto _L1
                h1;
                parcel1.recycle();
                parcel.recycle();
                throw h1;
            }

            public final void a(String s1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeString(s1);
                a.transact(23, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                s1;
                parcel1.recycle();
                parcel.recycle();
                throw s1;
            }

            public final void a(String s1, int i1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeString(s1);
                parcel.writeInt(i1);
                a.transact(2, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                s1;
                parcel1.recycle();
                parcel.recycle();
                throw s1;
            }

            public final void a(String s1, int i1, int j1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeString(s1);
                parcel.writeInt(i1);
                parcel.writeInt(j1);
                a.transact(4, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                s1;
                parcel1.recycle();
                parcel.recycle();
                throw s1;
            }

            public final void a(List list, int i1, int j1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeStringList(list);
                parcel.writeInt(i1);
                parcel.writeInt(j1);
                a.transact(6, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                list;
                parcel1.recycle();
                parcel.recycle();
                throw list;
            }

            public final void a(boolean flag)
            {
                Parcel parcel;
                Parcel parcel1;
                int i1;
                i1 = 1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                if (!flag)
                {
                    i1 = 0;
                }
                parcel.writeInt(i1);
                a.transact(1, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final boolean a(int i1, KeyEvent keyevent)
            {
                Parcel parcel;
                Parcel parcel1;
                boolean flag;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeInt(i1);
                if (keyevent == null)
                {
                    break MISSING_BLOCK_LABEL_81;
                }
                parcel.writeInt(1);
                keyevent.writeToParcel(parcel, 0);
_L1:
                a.transact(41, parcel, parcel1, 0);
                parcel1.readException();
                i1 = parcel1.readInt();
                if (i1 == 0)
                {
                    flag = false;
                }
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                keyevent;
                parcel1.recycle();
                parcel.recycle();
                throw keyevent;
            }

            public final boolean a(Bundle bundle)
            {
                Parcel parcel;
                Parcel parcel1;
                boolean flag;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                if (bundle == null)
                {
                    break MISSING_BLOCK_LABEL_73;
                }
                parcel.writeInt(1);
                bundle.writeToParcel(parcel, 0);
_L1:
                int i1;
                a.transact(40, parcel, parcel1, 0);
                parcel1.readException();
                i1 = parcel1.readInt();
                if (i1 == 0)
                {
                    flag = false;
                }
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                bundle;
                parcel1.recycle();
                parcel.recycle();
                throw bundle;
            }

            public final IBinder asBinder()
            {
                return a;
            }

            public final void b()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(9, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void b(int i1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeInt(i1);
                a.transact(18, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void b(String s1, int i1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeString(s1);
                parcel.writeInt(i1);
                a.transact(3, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                s1;
                parcel1.recycle();
                parcel.recycle();
                throw s1;
            }

            public final void b(String s1, int i1, int j1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeString(s1);
                parcel.writeInt(i1);
                parcel.writeInt(j1);
                a.transact(5, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                s1;
                parcel1.recycle();
                parcel.recycle();
                throw s1;
            }

            public final void b(List list, int i1, int j1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeStringList(list);
                parcel.writeInt(i1);
                parcel.writeInt(j1);
                a.transact(7, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                list;
                parcel1.recycle();
                parcel.recycle();
                throw list;
            }

            public final void b(boolean flag)
            {
                Parcel parcel;
                Parcel parcel1;
                int i1;
                i1 = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                if (flag)
                {
                    i1 = 1;
                }
                parcel.writeInt(i1);
                a.transact(19, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final boolean b(int i1, KeyEvent keyevent)
            {
                Parcel parcel;
                Parcel parcel1;
                boolean flag;
                flag = true;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeInt(i1);
                if (keyevent == null)
                {
                    break MISSING_BLOCK_LABEL_81;
                }
                parcel.writeInt(1);
                keyevent.writeToParcel(parcel, 0);
_L1:
                a.transact(42, parcel, parcel1, 0);
                parcel1.readException();
                i1 = parcel1.readInt();
                if (i1 == 0)
                {
                    flag = false;
                }
                parcel1.recycle();
                parcel.recycle();
                return flag;
                parcel.writeInt(0);
                  goto _L1
                keyevent;
                parcel1.recycle();
                parcel.recycle();
                throw keyevent;
            }

            public final void c(int i1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeInt(i1);
                a.transact(20, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void c(boolean flag)
            {
                Parcel parcel;
                Parcel parcel1;
                int i1;
                i1 = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                if (flag)
                {
                    i1 = 1;
                }
                parcel.writeInt(i1);
                a.transact(24, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final boolean c()
            {
                Parcel parcel;
                Parcel parcel1;
                boolean flag;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i1;
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(10, parcel, parcel1, 0);
                parcel1.readException();
                i1 = parcel1.readInt();
                if (i1 != 0)
                {
                    flag = true;
                }
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void d(int i1)
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                parcel.writeInt(i1);
                a.transact(22, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void d(boolean flag)
            {
                Parcel parcel;
                Parcel parcel1;
                int i1;
                i1 = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                if (flag)
                {
                    i1 = 1;
                }
                parcel.writeInt(i1);
                a.transact(25, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final boolean d()
            {
                Parcel parcel;
                Parcel parcel1;
                boolean flag;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i1;
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(11, parcel, parcel1, 0);
                parcel1.readException();
                i1 = parcel1.readInt();
                if (i1 != 0)
                {
                    flag = true;
                }
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void e(boolean flag)
            {
                Parcel parcel;
                Parcel parcel1;
                int i1;
                i1 = 0;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                if (flag)
                {
                    i1 = 1;
                }
                parcel.writeInt(i1);
                a.transact(37, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final boolean e()
            {
                Parcel parcel;
                Parcel parcel1;
                boolean flag;
                flag = false;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i1;
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(12, parcel, parcel1, 0);
                parcel1.readException();
                i1 = parcel1.readInt();
                if (i1 != 0)
                {
                    flag = true;
                }
                parcel1.recycle();
                parcel.recycle();
                return flag;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void f()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(13, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void g()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(14, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final int h()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i1;
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(15, parcel, parcel1, 0);
                parcel1.readException();
                i1 = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final int i()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i1;
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(16, parcel, parcel1, 0);
                parcel1.readException();
                i1 = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final int j()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                int i1;
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(21, parcel, parcel1, 0);
                parcel1.readException();
                i1 = parcel1.readInt();
                parcel1.recycle();
                parcel.recycle();
                return i1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void k()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(30, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void l()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(31, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void m()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(33, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void n()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(34, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void o()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(35, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void p()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(36, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final void q()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(38, parcel, parcel1, 0);
                parcel1.readException();
                parcel1.recycle();
                parcel.recycle();
                return;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final Bundle r()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(39, parcel, parcel1, 0);
                parcel1.readException();
                if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
                Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L4:
                parcel1.recycle();
                parcel.recycle();
                return bundle;
_L2:
                bundle = null;
                if (true) goto _L4; else goto _L3
_L3:
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            public final u s()
            {
                Parcel parcel;
                Parcel parcel1;
                parcel = Parcel.obtain();
                parcel1 = Parcel.obtain();
                u u1;
                parcel.writeInterfaceToken("com.google.android.youtube.player.internal.IEmbeddedPlayer");
                a.transact(43, parcel, parcel1, 0);
                parcel1.readException();
                u1 = u.a.a(parcel1.readStrongBinder());
                parcel1.recycle();
                parcel.recycle();
                return u1;
                Exception exception;
                exception;
                parcel1.recycle();
                parcel.recycle();
                throw exception;
            }

            a(IBinder ibinder)
            {
                a = ibinder;
            }
        }

        if (iinterface != null && (iinterface instanceof d))
        {
            return (d)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        Object obj1 = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj5 = null;
        Object obj6 = null;
        Object obj7 = null;
        Object obj8 = null;
        Object obj4 = null;
        Object obj = null;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag6 = false;
        boolean flag13 = false;
        boolean flag14 = false;
        boolean flag15 = false;
        boolean flag5 = false;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            if (parcel.readInt() != 0)
            {
                flag6 = true;
            } else
            {
                flag6 = false;
            }
            a(flag6);
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            a(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            b(parcel.readString(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            a(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            b(parcel.readString(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            a(parcel.createStringArrayList(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            b(parcel.createStringArrayList(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 8: // '\b'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            a();
            parcel1.writeNoException();
            return true;

        case 9: // '\t'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            b();
            parcel1.writeNoException();
            return true;

        case 10: // '\n'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            flag6 = c();
            parcel1.writeNoException();
            i = ((flag2) ? 1 : 0);
            if (flag6)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 11: // '\013'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            flag6 = d();
            parcel1.writeNoException();
            i = ((flag3) ? 1 : 0);
            if (flag6)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 12: // '\f'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            flag6 = e();
            parcel1.writeNoException();
            i = ((flag4) ? 1 : 0);
            if (flag6)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 13: // '\r'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            f();
            parcel1.writeNoException();
            return true;

        case 14: // '\016'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            g();
            parcel1.writeNoException();
            return true;

        case 15: // '\017'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            i = h();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 16: // '\020'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            i = i();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 17: // '\021'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            a(parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 18: // '\022'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            b(parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 19: // '\023'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            if (parcel.readInt() != 0)
            {
                flag6 = true;
            }
            b(flag6);
            parcel1.writeNoException();
            return true;

        case 20: // '\024'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            c(parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 21: // '\025'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            i = j();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 22: // '\026'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            d(parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 23: // '\027'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            a(parcel.readString());
            parcel1.writeNoException();
            return true;

        case 24: // '\030'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            boolean flag7 = flag13;
            if (parcel.readInt() != 0)
            {
                flag7 = true;
            }
            c(flag7);
            parcel1.writeNoException();
            return true;

        case 25: // '\031'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            boolean flag8 = flag14;
            if (parcel.readInt() != 0)
            {
                flag8 = true;
            }
            d(flag8);
            parcel1.writeNoException();
            return true;

        case 26: // '\032'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            parcel = parcel.readStrongBinder();
            if (parcel == null)
            {
                parcel = ((Parcel) (obj));
            } else
            {
                obj = parcel.queryLocalInterface("com.google.android.youtube.player.internal.IOnFullscreenListener");
                if (obj != null && (obj instanceof e))
                {
                    parcel = (e)obj;
                } else
                {
                    parcel = new a(parcel);
                }
            }
            a(parcel);
            parcel1.writeNoException();
            return true;

        case 27: // '\033'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            parcel = parcel.readStrongBinder();
            if (parcel == null)
            {
                parcel = obj1;
            } else
            {
                obj = parcel.queryLocalInterface("com.google.android.youtube.player.internal.IPlaylistEventListener");
                if (obj != null && (obj instanceof h))
                {
                    parcel = (h)obj;
                } else
                {
                    parcel = new a(parcel);
                }
            }
            a(parcel);
            parcel1.writeNoException();
            return true;

        case 28: // '\034'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            parcel = parcel.readStrongBinder();
            if (parcel == null)
            {
                parcel = obj2;
            } else
            {
                obj = parcel.queryLocalInterface("com.google.android.youtube.player.internal.IPlayerStateChangeListener");
                if (obj != null && (obj instanceof g))
                {
                    parcel = (g)obj;
                } else
                {
                    parcel = new a(parcel);
                }
            }
            a(parcel);
            parcel1.writeNoException();
            return true;

        case 29: // '\035'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            parcel = parcel.readStrongBinder();
            if (parcel == null)
            {
                parcel = obj3;
            } else
            {
                obj = parcel.queryLocalInterface("com.google.android.youtube.player.internal.IPlaybackEventListener");
                if (obj != null && (obj instanceof f))
                {
                    parcel = (f)obj;
                } else
                {
                    parcel = new a(parcel);
                }
            }
            a(parcel);
            parcel1.writeNoException();
            return true;

        case 30: // '\036'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            k();
            parcel1.writeNoException();
            return true;

        case 31: // '\037'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            l();
            parcel1.writeNoException();
            return true;

        case 32: // ' '
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            obj = obj5;
            if (parcel.readInt() != 0)
            {
                obj = (Configuration)Configuration.CREATOR.createFromParcel(parcel);
            }
            a(((Configuration) (obj)));
            parcel1.writeNoException();
            return true;

        case 33: // '!'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            m();
            parcel1.writeNoException();
            return true;

        case 34: // '"'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            n();
            parcel1.writeNoException();
            return true;

        case 35: // '#'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            o();
            parcel1.writeNoException();
            return true;

        case 36: // '$'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            p();
            parcel1.writeNoException();
            return true;

        case 37: // '%'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            boolean flag9 = flag15;
            if (parcel.readInt() != 0)
            {
                flag9 = true;
            }
            e(flag9);
            parcel1.writeNoException();
            return true;

        case 38: // '&'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            q();
            parcel1.writeNoException();
            return true;

        case 39: // '\''
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            parcel = r();
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
                return true;
            } else
            {
                parcel1.writeInt(0);
                return true;
            }

        case 40: // '('
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            obj = obj6;
            if (parcel.readInt() != 0)
            {
                obj = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            }
            boolean flag10 = a(((Bundle) (obj)));
            parcel1.writeNoException();
            i = ((flag5) ? 1 : 0);
            if (flag10)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 41: // ')'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            i = parcel.readInt();
            obj = obj7;
            if (parcel.readInt() != 0)
            {
                obj = (KeyEvent)KeyEvent.CREATOR.createFromParcel(parcel);
            }
            boolean flag11 = a(i, ((KeyEvent) (obj)));
            parcel1.writeNoException();
            i = ((flag) ? 1 : 0);
            if (flag11)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 42: // '*'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            i = parcel.readInt();
            obj = obj8;
            if (parcel.readInt() != 0)
            {
                obj = (KeyEvent)KeyEvent.CREATOR.createFromParcel(parcel);
            }
            boolean flag12 = b(i, ((KeyEvent) (obj)));
            parcel1.writeNoException();
            i = ((flag1) ? 1 : 0);
            if (flag12)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;

        case 43: // '+'
            parcel.enforceInterface("com.google.android.youtube.player.internal.IEmbeddedPlayer");
            obj = s();
            parcel1.writeNoException();
            parcel = obj4;
            break;
        }
        if (obj != null)
        {
            parcel = ((u) (obj)).asBinder();
        }
        parcel1.writeStrongBinder(parcel);
        return true;
    }
}
