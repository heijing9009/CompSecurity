// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl
    implements Invitations
{
    private static abstract class LoadInvitationsImpl extends com.google.android.gms.games.Games.BaseGamesApiMethodImpl
    {

        public com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult T(Status status)
        {
            return new com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult(this, status) {

                final Status DS;
                final LoadInvitationsImpl aaD;

                public InvitationBuffer getInvitations()
                {
                    return new InvitationBuffer(DataHolder.av(14));
                }

                public Status getStatus()
                {
                    return DS;
                }

                public void release()
                {
                }

            
            {
                aaD = loadinvitationsimpl;
                DS = status;
                super();
            }
            };
        }

        public Result c(Status status)
        {
            return T(status);
        }

        private LoadInvitationsImpl(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public InvitationsImpl()
    {
    }

    public Intent getInvitationInboxIntent(GoogleApiClient googleapiclient)
    {
        return Games.d(googleapiclient).lo();
    }

    public PendingResult loadInvitations(GoogleApiClient googleapiclient)
    {
        return loadInvitations(googleapiclient, 0);
    }

    public PendingResult loadInvitations(GoogleApiClient googleapiclient, int i)
    {
        return googleapiclient.a(new LoadInvitationsImpl(googleapiclient, i) {

            final int aaA;
            final InvitationsImpl aaB;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((GamesClientImpl)a1);
            }

            protected void a(GamesClientImpl gamesclientimpl)
            {
                gamesclientimpl.c(this, aaA);
            }

            
            {
                aaB = InvitationsImpl.this;
                aaA = i;
                super(googleapiclient);
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient googleapiclient, OnInvitationReceivedListener oninvitationreceivedlistener)
    {
        oninvitationreceivedlistener = googleapiclient.d(oninvitationreceivedlistener);
        Games.d(googleapiclient).a(oninvitationreceivedlistener);
    }

    public void unregisterInvitationListener(GoogleApiClient googleapiclient)
    {
        Games.d(googleapiclient).lp();
    }

    // Unreferenced inner class com/google/android/gms/games/internal/api/InvitationsImpl$2

/* anonymous class */
    class _cls2 extends LoadInvitationsImpl
    {

        final String ZZ;
        final int aaA;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            throws RemoteException
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.e(this, ZZ, aaA);
        }
    }


    // Unreferenced inner class com/google/android/gms/games/internal/api/InvitationsImpl$3

/* anonymous class */
    class _cls3 extends LoadInvitationsImpl
    {

        final String aaC;

        protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            throws RemoteException
        {
            a((GamesClientImpl)a1);
        }

        protected void a(GamesClientImpl gamesclientimpl)
        {
            gamesclientimpl.n(this, aaC);
        }
    }

}
