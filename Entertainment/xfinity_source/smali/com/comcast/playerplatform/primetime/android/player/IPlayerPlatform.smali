.class public interface abstract Lcom/comcast/playerplatform/primetime/android/player/IPlayerPlatform;
.super Ljava/lang/Object;
.source "IPlayerPlatform.java"


# virtual methods
.method public abstract getAutoPlay()Z
.end method

.method public abstract getAvailableAudioLanguages()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getAvailableBitrates()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getAvailableClosedCaptionTracks()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getAvailableProfiles()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/primetime/PlayerProfile;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getBitrateRange()Lcom/comcast/playerplatform/util/android/Range;
.end method

.method public abstract getClosedCaptionsStatus()Z
.end method

.method public abstract getCurrentAd()Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;
.end method

.method public abstract getCurrentAdBreak()Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;
.end method

.method public abstract getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
.end method

.method public abstract getCurrentBitrate()I
.end method

.method public abstract getCurrentChannel()Lcom/comcast/playerplatform/primetime/android/asset/Asset;
.end method

.method public abstract getCurrentClosedCaptionTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;
.end method

.method public abstract getCurrentPlaybackSpeed()D
.end method

.method public abstract getCurrentPosition()J
.end method

.method public abstract getDuration()J
.end method

.method public abstract getEndPosition()J
.end method

.method public abstract getInitialBitrate()I
.end method

.method public abstract getLogger()Lcom/comcast/playerplatform/primetime/android/util/PlayerLogger;
.end method

.method public abstract getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
.end method

.method public abstract getStartPosition()J
.end method

.method public abstract getSupportedClosedCaptionsOptions()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getSupportedPlaybackSpeeds()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Float;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
.end method

.method public abstract getVersion()Ljava/lang/String;
.end method

.method public abstract getVideoHeight()J
.end method

.method public abstract getVideoType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
.end method

.method public abstract getVideoWidth()J
.end method

.method public abstract getView()Landroid/view/View;
.end method

.method public abstract isAdPlaying()Z
.end method

.method public abstract pause()V
.end method

.method public abstract play()V
.end method

.method public abstract seekToLive()V
.end method

.method public abstract setAutoPlay(Ljava/lang/Boolean;)V
.end method

.method public abstract setBitrateParameters(Lcom/comcast/playerplatform/util/android/BitrateParameters;)V
.end method

.method public abstract setBitrateRange(Lcom/comcast/playerplatform/util/android/Range;)V
.end method

.method public abstract setBlock(Z)V
.end method

.method public abstract setClosedCaptionsEnabled(Z)V
.end method

.method public abstract setClosedCaptionsOptions(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;)V
.end method

.method public abstract setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V
.end method

.method public abstract setCurrentTimeUpdateInterval(I)V
.end method

.method public abstract setInitialBitrate(I)V
.end method

.method public abstract setLogger(Lcom/comcast/playerplatform/primetime/android/util/LogFactory;)V
.end method

.method public abstract setLoggingVerbosity(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V
.end method

.method public abstract setPlayerAdBreakPolicies(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;)V
.end method

.method public abstract setPositionRelative(J)V
.end method

.method public abstract setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V
.end method

.method public abstract setPreferredZoomSetting(Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;)V
.end method

.method public abstract setVolume(I)V
.end method
