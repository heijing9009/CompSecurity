// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.feedback;

import android.app.ApplicationErrorReport;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.ByteArrayOutputStream;

// Referenced classes of package com.google.android.gms.feedback:
//            a, FileTeleporter

public class ErrorReport
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new a();
    public static final int TYPE_USER_INITIATED_BUG_REPORT = 11;
    public String account;
    public String anrStackTraces;
    public ApplicationErrorReport applicationErrorReport;
    public BitmapTeleporter bitmapTeleporter;
    public String board;
    public String brand;
    public String buildFingerprint;
    public String buildId;
    public String buildType;
    public String categoryTag;
    public String codename;
    public String color;
    public String description;
    public String device;
    public String eventLog[];
    public String exceptionClassName;
    public String exceptionMessage;
    public boolean excludePii;
    public FileTeleporter fileTeleporterList[];
    public String incremental;
    public boolean isCtlAllowed;
    public boolean isSilentSend;
    public String launcher;
    public String localeString;
    public String model;
    public int networkMcc;
    public int networkMnc;
    public String networkName;
    public int networkType;
    public int packageVersion;
    public String packageVersionName;
    public int phoneType;
    public String product;
    public Bundle psdBundle;
    public String psdFilePaths[];
    public String release;
    public String runningApplications[];
    public String screenshot;
    public byte screenshotBytes[];
    public int screenshotHeight;
    public String screenshotPath;
    public int screenshotWidth;
    public int sdk_int;
    public String stackTrace;
    public String submittingPackageName;
    public String systemLog[];
    public String throwClassName;
    public String throwFileName;
    public int throwLineNumber;
    public String throwMethodName;
    public final int versionCode;

    public ErrorReport()
    {
        applicationErrorReport = new ApplicationErrorReport();
        versionCode = 5;
    }

    ErrorReport(int i, ApplicationErrorReport applicationerrorreport, String s, int j, String s1, String s2, String s3, 
            String s4, String s5, String s6, String s7, int k, String s8, String s9, 
            String s10, String s11, String s12, String as[], String as1[], String as2[], String s13, 
            String s14, byte abyte0[], int l, int i1, int j1, int k1, String s15, 
            String s16, String s17, Bundle bundle, boolean flag, int l1, int i2, boolean flag1, 
            String s18, String s19, int j2, String s20, String s21, String s22, String s23, 
            String s24, String s25, String s26, BitmapTeleporter bitmapteleporter, String s27, FileTeleporter afileteleporter[], String as3[], 
            boolean flag2, String s28)
    {
        applicationErrorReport = new ApplicationErrorReport();
        versionCode = i;
        applicationErrorReport = applicationerrorreport;
        description = s;
        packageVersion = j;
        packageVersionName = s1;
        device = s2;
        buildId = s3;
        buildType = s4;
        model = s5;
        product = s6;
        buildFingerprint = s7;
        sdk_int = k;
        release = s8;
        incremental = s9;
        codename = s10;
        board = s11;
        brand = s12;
        runningApplications = as;
        systemLog = as1;
        eventLog = as2;
        anrStackTraces = s13;
        screenshot = s14;
        screenshotBytes = abyte0;
        screenshotHeight = l;
        screenshotWidth = i1;
        phoneType = j1;
        networkType = k1;
        networkName = s15;
        account = s16;
        localeString = s17;
        psdBundle = bundle;
        isSilentSend = flag;
        networkMcc = l1;
        networkMnc = i2;
        isCtlAllowed = flag1;
        exceptionClassName = s18;
        throwFileName = s19;
        throwLineNumber = j2;
        throwClassName = s20;
        throwMethodName = s21;
        stackTrace = s22;
        exceptionMessage = s23;
        categoryTag = s24;
        color = s25;
        submittingPackageName = s26;
        bitmapTeleporter = bitmapteleporter;
        screenshotPath = s27;
        fileTeleporterList = afileteleporter;
        psdFilePaths = as3;
        excludePii = flag2;
        launcher = s28;
    }

    private static Bitmap a(Bitmap bitmap, int i, int j)
    {
        return Bitmap.createScaledBitmap(bitmap, i, j, true);
    }

    public int describeContents()
    {
        return 0;
    }

    public final void setScreenshot(Bitmap bitmap)
    {
        if (bitmap == null || bitmap.isRecycled())
        {
            Log.e("ErrorReport", "Bitmap is null or recycled. Cant compress. We will not attach screenshot");
        } else
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 70, bytearrayoutputstream);
            screenshot = Base64.encodeToString(bytearrayoutputstream.toByteArray(), 0);
            screenshotWidth = bitmap.getWidth();
            screenshotHeight = bitmap.getHeight();
            if (screenshot.getBytes().length > 0x40000)
            {
                Log.d("ErrorReport", (new StringBuilder("Encountered large screenshot, size: ")).append(screenshot.getBytes().length).append(",  compressing further.").toString());
                setScreenshot(a(bitmap, screenshotWidth >> 1, screenshotHeight >> 1));
                return;
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.feedback.a.a(this, parcel, i);
    }

}
