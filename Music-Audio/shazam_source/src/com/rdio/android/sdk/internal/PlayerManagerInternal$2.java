// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import android.os.Handler;
import android.util.Log;
import com.google.a.d.e;
import com.rdio.android.audioplayer.RdioAudioPlayer;
import com.rdio.android.audioplayer.interfaces.AudioError;
import com.rdio.android.audioplayer.interfaces.AudioInfo;
import com.rdio.android.audioplayer.interfaces.AudioPlayerListener;
import com.rdio.android.core.events.playback.PlaybackCompletedEvent;
import com.rdio.android.core.events.playback.ReportPlaybackEvent;
import com.rdio.android.core.events.playback.ReportPlaybackEventInfo;
import com.rdio.android.core.events.playback.ReportPlaybackEventType;
import com.rdio.android.sdk.PlayerListener;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.rdio.android.sdk.internal:
//            PlayerManagerInternal, OnlineMediaSource, PlayTrackKeyEvent

class this._cls0
    implements AudioPlayerListener
{

    final PlayerManagerInternal this$0;

    public void onComplete()
    {
        PlayerManagerInternal.access$000(PlayerManagerInternal.this).release();
        ReportPlaybackEventInfo reportplaybackeventinfo = new ReportPlaybackEventInfo();
        reportplaybackeventinfo.trackKey = PlayerManagerInternal.access$100(PlayerManagerInternal.this);
        PlayerManagerInternal.access$200(PlayerManagerInternal.this).post(new ReportPlaybackEvent(ReportPlaybackEventType.TrackEnded, reportplaybackeventinfo));
        updateCurrentState(t.State.Stopped);
        final PlayerListener listener;
        for (Iterator iterator = PlayerManagerInternal.access$300(PlayerManagerInternal.this).iterator(); iterator.hasNext(); PlayerManagerInternal.access$400(PlayerManagerInternal.this).post(new Runnable() {

        final PlayerManagerInternal._cls2 this$1;
        final PlayerListener val$listener;

        public void run()
        {
            listener.onComplete();
        }

            
            {
                this$1 = PlayerManagerInternal._cls2.this;
                listener = playerlistener;
                super();
            }
    }))
        {
            listener = (PlayerListener)iterator.next();
        }

        PlayerManagerInternal.access$200(PlayerManagerInternal.this).post(new PlaybackCompletedEvent());
    }

    public void onError(final AudioError error)
    {
        Log.e("rdio", (new StringBuilder("AudioError encountered : ")).append(error).append(" : ").append(error.getDescription()).toString());
        stop(false);
        updateCurrentState(t.State.Error);
        final PlayerListener listener;
        for (Iterator iterator = PlayerManagerInternal.access$300(PlayerManagerInternal.this).iterator(); iterator.hasNext(); PlayerManagerInternal.access$400(PlayerManagerInternal.this).post(new Runnable() {

        final PlayerManagerInternal._cls2 this$1;
        final AudioError val$error;
        final PlayerListener val$listener;

        public void run()
        {
            listener.onError(error);
        }

            
            {
                this$1 = PlayerManagerInternal._cls2.this;
                listener = playerlistener;
                error = audioerror;
                super();
            }
    }))
        {
            listener = (PlayerListener)iterator.next();
        }

    }

    public void onInfo(AudioInfo audioinfo)
    {
        if (audioinfo.getDetail() == com.rdio.android.audioplayer.interfaces.l.BufferingEnd)
        {
            final PlayerListener listener;
            for (audioinfo = PlayerManagerInternal.access$300(PlayerManagerInternal.this).iterator(); audioinfo.hasNext(); PlayerManagerInternal.access$400(PlayerManagerInternal.this).post(new Runnable() {

        final PlayerManagerInternal._cls2 this$1;
        final PlayerListener val$listener;

        public void run()
        {
            listener.onBufferingEnded();
        }

            
            {
                this$1 = PlayerManagerInternal._cls2.this;
                listener = playerlistener;
                super();
            }
    }))
            {
                listener = (PlayerListener)audioinfo.next();
            }

        } else
        if (audioinfo.getDetail() == com.rdio.android.audioplayer.interfaces.l.BufferingStart)
        {
            final PlayerListener listener;
            for (audioinfo = PlayerManagerInternal.access$300(PlayerManagerInternal.this).iterator(); audioinfo.hasNext(); PlayerManagerInternal.access$400(PlayerManagerInternal.this).post(new Runnable() {

        final PlayerManagerInternal._cls2 this$1;
        final PlayerListener val$listener;

        public void run()
        {
            listener.onBufferingStarted();
        }

            
            {
                this$1 = PlayerManagerInternal._cls2.this;
                listener = playerlistener;
                super();
            }
    }))
            {
                listener = (PlayerListener)audioinfo.next();
            }

        } else
        if (audioinfo.getDetail() == com.rdio.android.audioplayer.interfaces.l.AudioStart && PlayerManagerInternal.access$700(PlayerManagerInternal.this) > 0)
        {
            seekTo(PlayerManagerInternal.access$700(PlayerManagerInternal.this));
        }
    }

    public void onPrepared()
    {
        ReportPlaybackEventInfo reportplaybackeventinfo = new ReportPlaybackEventInfo();
        PlayerManagerInternal.access$802(PlayerManagerInternal.this, PlayerManagerInternal.access$900(PlayerManagerInternal.this).getTrack());
        reportplaybackeventinfo.trackKey = PlayerManagerInternal.access$100(PlayerManagerInternal.this);
        reportplaybackeventinfo.parentKey = PlayerManagerInternal.access$600(PlayerManagerInternal.this);
        PlayerManagerInternal.access$200(PlayerManagerInternal.this).post(new ReportPlaybackEvent(ReportPlaybackEventType.TrackStarted, reportplaybackeventinfo));
        play();
        final PlayerListener listener;
        for (Iterator iterator = PlayerManagerInternal.access$300(PlayerManagerInternal.this).iterator(); iterator.hasNext(); PlayerManagerInternal.access$400(PlayerManagerInternal.this).post(new Runnable() {

        final PlayerManagerInternal._cls2 this$1;
        final PlayerListener val$listener;

        public void run()
        {
            listener.onPrepared();
        }

            
            {
                this$1 = PlayerManagerInternal._cls2.this;
                listener = playerlistener;
                super();
            }
    }))
        {
            listener = (PlayerListener)iterator.next();
        }

    }

    public void onResetComplete()
    {
        if (PlayerManagerInternal.access$500(PlayerManagerInternal.this))
        {
            PlayerManagerInternal.access$502(PlayerManagerInternal.this, false);
            onPlayAudio(new PlayTrackKeyEvent(PlayerManagerInternal.access$100(PlayerManagerInternal.this), PlayerManagerInternal.access$600(PlayerManagerInternal.this), true, PlayerManagerInternal.access$700(PlayerManagerInternal.this)));
            return;
        } else
        {
            updateCurrentState(t.State.Stopped);
            return;
        }
    }

    public void onSeekCompleted()
    {
        final PlayerListener listener;
        for (Iterator iterator = PlayerManagerInternal.access$300(PlayerManagerInternal.this).iterator(); iterator.hasNext(); PlayerManagerInternal.access$400(PlayerManagerInternal.this).post(new Runnable() {

        final PlayerManagerInternal._cls2 this$1;
        final PlayerListener val$listener;

        public void run()
        {
            listener.onSeekCompleted();
        }

            
            {
                this$1 = PlayerManagerInternal._cls2.this;
                listener = playerlistener;
                super();
            }
    }))
        {
            listener = (PlayerListener)iterator.next();
        }

    }

    public void onSeekStarted()
    {
        final PlayerListener listener;
        for (Iterator iterator = PlayerManagerInternal.access$300(PlayerManagerInternal.this).iterator(); iterator.hasNext(); PlayerManagerInternal.access$400(PlayerManagerInternal.this).post(new Runnable() {

        final PlayerManagerInternal._cls2 this$1;
        final PlayerListener val$listener;

        public void run()
        {
            listener.onSeekStarted();
        }

            
            {
                this$1 = PlayerManagerInternal._cls2.this;
                listener = playerlistener;
                super();
            }
    }))
        {
            listener = (PlayerListener)iterator.next();
        }

    }

    _cls7.val.error()
    {
        this$0 = PlayerManagerInternal.this;
        super();
    }
}
