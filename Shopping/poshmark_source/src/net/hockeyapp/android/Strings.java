// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;


// Referenced classes of package net.hockeyapp.android:
//            StringListener

public class Strings
{

    public static final int CRASH_DIALOG_MESSAGE_ID = 1;
    public static final int CRASH_DIALOG_NEGATIVE_BUTTON_ID = 2;
    public static final int CRASH_DIALOG_POSITIVE_BUTTON_ID = 3;
    public static final int CRASH_DIALOG_TITLE_ID = 0;
    public static final int DOWNLOAD_FAILED_DIALOG_MESSAGE_ID = 5;
    public static final int DOWNLOAD_FAILED_DIALOG_NEGATIVE_BUTTON_ID = 6;
    public static final int DOWNLOAD_FAILED_DIALOG_POSITIVE_BUTTON_ID = 7;
    public static final int DOWNLOAD_FAILED_DIALOG_TITLE_ID = 4;
    public static final String ENGLISH[] = {
        "Crash Data", "The app found information about previous crashes. Would you like to send this data to the developer?", "Dismiss", "Send", "Download Failed", "The update could not be downloaded. Would you like to try again?", "Cancel", "Retry", "Please install the latest version to continue to use this app.", "Update Available", 
        "Show information about the new update?", "Dismiss", "Show", "Build Expired", "This has build has expired. Please check HockeyApp for any updates.", "Feedback Failed", "Would you like to send your feedback again?"
    };
    public static final int EXPIRY_INFO_TEXT_ID = 14;
    public static final int EXPIRY_INFO_TITLE_ID = 13;
    public static final int FEEDBACK_FAILED_TEXT_ID = 16;
    public static final int FEEDBACK_FAILED_TITLE_ID = 15;
    public static final int UPDATE_DIALOG_MESSAGE_ID = 10;
    public static final int UPDATE_DIALOG_NEGATIVE_BUTTON_ID = 11;
    public static final int UPDATE_DIALOG_POSITIVE_BUTTON_ID = 12;
    public static final int UPDATE_DIALOG_TITLE_ID = 9;
    public static final int UPDATE_MANDATORY_TOAST_ID = 8;

    public Strings()
    {
    }

    public static String get(int i)
    {
        return get(null, i);
    }

    public static String get(StringListener stringlistener, int i)
    {
        String s = null;
        if (stringlistener != null)
        {
            s = stringlistener.getStringForResource(i);
        }
        stringlistener = s;
        if (s == null)
        {
            stringlistener = s;
            if (i >= 0)
            {
                stringlistener = s;
                if (i <= ENGLISH.length)
                {
                    stringlistener = ENGLISH[i];
                }
            }
        }
        return stringlistener;
    }

}
