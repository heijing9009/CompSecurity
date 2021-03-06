// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import c.a.a.a.a.b.l;
import c.a.a.a.a.b.s;
import c.a.a.a.a.b.x;
import c.a.a.a.a.g.m;
import c.a.a.a.e;
import c.a.a.a.q;
import com.crashlytics.android.core.internal.models.SessionEventData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsCore, LogFileManager, ClsFileOutputStream, CLSUUID, 
//            CodedOutputStream, ExceptionUtils, UserMetaData, MetaDataStore, 
//            CrashlyticsListener, CrashlyticsExecutorServiceWrapper, Utils, SessionDataWriter, 
//            NativeCrashWriter

class CrashlyticsUncaughtExceptionHandler
    implements Thread.UncaughtExceptionHandler
{

    private static final int ANALYZER_VERSION = 1;
    static final FilenameFilter ANY_SESSION_FILENAME_FILTER = new _cls4();
    static final String CLS_CRASH_MARKER_FILE_NAME = "crash_marker";
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    static final String INVALID_CLS_CACHE_DIR = "invalidClsFiles";
    static final Comparator LARGEST_FILE_NAME_FIRST = new _cls2();
    private static final int MAX_COMPLETE_SESSIONS_COUNT = 4;
    private static final int MAX_LOCAL_LOGGED_EXCEPTIONS = 64;
    static final int MAX_OPEN_SESSIONS = 8;
    private static final Map SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
    static final String SESSION_APP_TAG = "SessionApp";
    static final String SESSION_BEGIN_TAG = "BeginSession";
    static final String SESSION_DEVICE_TAG = "SessionDevice";
    static final String SESSION_FATAL_TAG = "SessionCrash";
    static final FilenameFilter SESSION_FILE_FILTER = new _cls1();
    private static final Pattern SESSION_FILE_PATTERN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    private static final int SESSION_ID_LENGTH = 35;
    static final String SESSION_NON_FATAL_TAG = "SessionEvent";
    static final String SESSION_OS_TAG = "SessionOS";
    static final String SESSION_USER_TAG = "SessionUser";
    static final Comparator SMALLEST_FILE_NAME_FIRST = new _cls3();
    private final CrashlyticsCore crashlyticsCore;
    private final Thread.UncaughtExceptionHandler defaultHandler;
    private final AtomicInteger eventCounter = new AtomicInteger(0);
    private final CrashlyticsExecutorServiceWrapper executorServiceWrapper;
    private final File filesDir;
    private final x idManager;
    private final AtomicBoolean isHandlingException = new AtomicBoolean(false);
    private final LogFileManager logFileManager;
    private boolean powerConnected;
    private final BroadcastReceiver powerConnectedReceiver = new _cls5();
    private final BroadcastReceiver powerDisconnectedReceiver = new _cls6();
    private final AtomicBoolean receiversRegistered = new AtomicBoolean(false);
    private final SessionDataWriter sessionDataWriter;

    CrashlyticsUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtexceptionhandler, CrashlyticsListener crashlyticslistener, CrashlyticsExecutorServiceWrapper crashlyticsexecutorservicewrapper, x x1, SessionDataWriter sessiondatawriter, CrashlyticsCore crashlyticscore)
    {
        defaultHandler = uncaughtexceptionhandler;
        executorServiceWrapper = crashlyticsexecutorservicewrapper;
        idManager = x1;
        crashlyticsCore = crashlyticscore;
        sessionDataWriter = sessiondatawriter;
        filesDir = crashlyticscore.getSdkDirectory();
        logFileManager = new LogFileManager(crashlyticscore.getContext(), filesDir);
        notifyCrashlyticsListenerOfPreviousCrash(crashlyticslistener);
        uncaughtexceptionhandler = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        crashlyticslistener = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
        crashlyticsexecutorservicewrapper = crashlyticscore.getContext();
        crashlyticsexecutorservicewrapper.registerReceiver(powerConnectedReceiver, uncaughtexceptionhandler);
        crashlyticsexecutorservicewrapper.registerReceiver(powerDisconnectedReceiver, crashlyticslistener);
        receiversRegistered.set(true);
    }

    private void closeWithoutRenamingOrLog(ClsFileOutputStream clsfileoutputstream)
    {
        if (clsfileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        clsfileoutputstream.closeInProgressStream();
        return;
        clsfileoutputstream;
        e.d().c("CrashlyticsCore", "Error closing session file stream in the presence of an exception", clsfileoutputstream);
        return;
    }

    private void deleteLegacyInvalidCacheDir()
    {
        File file = new File(crashlyticsCore.getSdkDirectory(), "invalidClsFiles");
        if (file.exists())
        {
            if (file.isDirectory())
            {
                File afile[] = file.listFiles();
                int j = afile.length;
                for (int i = 0; i < j; i++)
                {
                    afile[i].delete();
                }

            }
            file.delete();
        }
    }

    private void deleteSessionPartFilesFor(String s1)
    {
        s1 = listSessionPartFilesFor(s1);
        int j = s1.length;
        for (int i = 0; i < j; i++)
        {
            s1[i].delete();
        }

    }

    private void doCloseSessions(boolean flag)
    {
        File afile[];
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        trimOpenSessions(i + 8);
        afile = listSessionBeginFiles();
        Arrays.sort(afile, LARGEST_FILE_NAME_FIRST);
        if (afile.length > i)
        {
            writeSessionUser(getSessionIdFromSessionFile(afile[i]));
            m m1 = crashlyticsCore.getSessionSettingsData();
            if (m1 != null)
            {
                int j = m1.a;
                e.d().a("CrashlyticsCore", "Closing open sessions.");
                for (; i < afile.length; i++)
                {
                    File file = afile[i];
                    String s1 = getSessionIdFromSessionFile(file);
                    e.d().a("CrashlyticsCore", (new StringBuilder("Closing session: ")).append(s1).toString());
                    writeSessionPartsToSessionFile(file, s1, j);
                }

            } else
            {
                e.d().a("CrashlyticsCore", "Unable to close session. Settings are not loaded.");
            }
            return;
        } else
        {
            e.d().a("CrashlyticsCore", "No open sessions to be closed.");
            return;
        }
    }

    private void doOpenSession()
    {
        Date date = new Date();
        String s1 = (new CLSUUID(idManager)).toString();
        e.d().a("CrashlyticsCore", (new StringBuilder("Opening an new session with ID ")).append(s1).toString());
        writeBeginSession(s1, date);
        writeSessionApp(s1);
        writeSessionOS(s1);
        writeSessionDevice(s1);
        logFileManager.setCurrentSession(s1);
    }

    private void doWriteNonFatal(Date date, Thread thread, Throwable throwable)
    {
        CodedOutputStream codedoutputstream;
        CodedOutputStream codedoutputstream1;
        CodedOutputStream codedoutputstream2;
        Object obj1;
        String s1;
        codedoutputstream = null;
        obj1 = null;
        codedoutputstream2 = null;
        codedoutputstream1 = null;
        s1 = getCurrentSessionId();
        if (s1 == null) goto _L2; else goto _L1
_L1:
        CrashlyticsCore.recordLoggedExceptionEvent(s1);
        Object obj;
        e.d().a("CrashlyticsCore", (new StringBuilder("Crashlytics is logging non-fatal exception \"")).append(throwable).append("\" from thread ").append(thread.getName()).toString());
        obj = l.a(eventCounter.getAndIncrement());
        obj = (new StringBuilder()).append(s1).append("SessionEvent").append(((String) (obj))).toString();
        obj = new ClsFileOutputStream(filesDir, ((String) (obj)));
        codedoutputstream = obj1;
        codedoutputstream1 = codedoutputstream2;
        codedoutputstream2 = CodedOutputStream.newInstance(((java.io.OutputStream) (obj)));
        codedoutputstream = codedoutputstream2;
        codedoutputstream1 = codedoutputstream2;
        writeSessionEvent(codedoutputstream2, date, thread, throwable, "error", false);
        l.a(codedoutputstream2, "Failed to flush to non-fatal file.");
        l.a(((java.io.Closeable) (obj)), "Failed to close non-fatal file output stream.");
        break MISSING_BLOCK_LABEL_172;
        thread;
        date = null;
_L6:
        e.d().c("CrashlyticsCore", "An error occurred in the non-fatal exception logger", thread);
        ExceptionUtils.writeStackTraceIfNotNull(thread, date);
        l.a(codedoutputstream1, "Failed to flush to non-fatal file.");
        l.a(date, "Failed to close non-fatal file output stream.");
          goto _L3
        thread;
        date = null;
_L5:
        l.a(codedoutputstream, "Failed to flush to non-fatal file.");
        l.a(date, "Failed to close non-fatal file output stream.");
        throw thread;
_L3:
        try
        {
            trimSessionEventFiles(s1, 64);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Date date)
        {
            e.d().c("CrashlyticsCore", "An error occurred when trimming non-fatal files.", date);
        }
        return;
_L2:
        e.d().c("CrashlyticsCore", "Tried to write a non-fatal exception while no session was open.", null);
        return;
        thread;
        date = ((Date) (obj));
        continue; /* Loop/switch isn't completed */
        thread;
        codedoutputstream = codedoutputstream1;
        if (true) goto _L5; else goto _L4
_L4:
        thread;
        date = ((Date) (obj));
          goto _L6
    }

    private File[] ensureFileArrayNotNull(File afile[])
    {
        File afile1[] = afile;
        if (afile == null)
        {
            afile1 = new File[0];
        }
        return afile1;
    }

    private String getCurrentSessionId()
    {
        File afile[] = listSessionBeginFiles();
        Arrays.sort(afile, LARGEST_FILE_NAME_FIRST);
        if (afile.length > 0)
        {
            return getSessionIdFromSessionFile(afile[0]);
        } else
        {
            return null;
        }
    }

    private String getPreviousSessionId()
    {
        File afile[] = listSessionBeginFiles();
        Arrays.sort(afile, LARGEST_FILE_NAME_FIRST);
        if (afile.length > 1)
        {
            return getSessionIdFromSessionFile(afile[1]);
        } else
        {
            return null;
        }
    }

    private String getSessionIdFromSessionFile(File file)
    {
        return file.getName().substring(0, 35);
    }

    private UserMetaData getUserMetaData(String s1)
    {
        if (isHandlingException())
        {
            return new UserMetaData(crashlyticsCore.getUserIdentifier(), crashlyticsCore.getUserName(), crashlyticsCore.getUserEmail());
        } else
        {
            return (new MetaDataStore(filesDir)).readUserData(s1);
        }
    }

    private void handleUncaughtException(Date date, Thread thread, Throwable throwable)
    {
        writeFatal(date, thread, throwable);
        doCloseSessions();
        doOpenSession();
        trimSessionFiles();
        if (!crashlyticsCore.shouldPromptUserBeforeSendingCrashReports())
        {
            sendSessionReports();
        }
    }

    private File[] listCompleteSessionFiles()
    {
        return listFilesMatching(SESSION_FILE_FILTER);
    }

    private File[] listFilesMatching(FilenameFilter filenamefilter)
    {
        return ensureFileArrayNotNull(filesDir.listFiles(filenamefilter));
    }

    private File[] listSessionPartFilesFor(String s1)
    {
        return listFilesMatching(new SessionPartFileFilter(s1));
    }

    private void notifyCrashlyticsListenerOfPreviousCrash(CrashlyticsListener crashlyticslistener)
    {
        e.d().a("CrashlyticsCore", "Checking for previous crash marker.");
        File file = new File(crashlyticsCore.getSdkDirectory(), "crash_marker");
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_51;
        }
        file.delete();
        if (crashlyticslistener == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        crashlyticslistener.crashlyticsDidDetectCrashDuringPreviousExecution();
        return;
        crashlyticslistener;
        e.d().c("CrashlyticsCore", "Exception thrown by CrashlyticsListener while notifying of previous crash.", crashlyticslistener);
        return;
    }

    private void sendSessionReports()
    {
        File afile[] = listCompleteSessionFiles();
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            final File toSend = afile[i];
            executorServiceWrapper.executeAsync(new _cls16());
        }

    }

    private void trimOpenSessions(int i)
    {
        boolean flag = false;
        HashSet hashset = new HashSet();
        File afile[] = listSessionBeginFiles();
        Arrays.sort(afile, LARGEST_FILE_NAME_FIRST);
        int j = Math.min(i, afile.length);
        for (i = 0; i < j; i++)
        {
            hashset.add(getSessionIdFromSessionFile(afile[i]));
        }

        logFileManager.discardOldLogFiles(hashset);
        afile = listFilesMatching(new AnySessionPartFileFilter(null));
        j = afile.length;
        for (i = ((flag) ? 1 : 0); i < j; i++)
        {
            File file = afile[i];
            String s1 = file.getName();
            Matcher matcher = SESSION_FILE_PATTERN.matcher(s1);
            matcher.matches();
            if (!hashset.contains(matcher.group(1)))
            {
                e.d().a("CrashlyticsCore", (new StringBuilder("Trimming open session file: ")).append(s1).toString());
                file.delete();
            }
        }

    }

    private void trimSessionEventFiles(String s1, int i)
    {
        Utils.capFileCount(filesDir, new FileNameContainsFilter((new StringBuilder()).append(s1).append("SessionEvent").toString()), i, SMALLEST_FILE_NAME_FIRST);
    }

    private void writeBeginSession(String s1, Date date)
    {
        CodedOutputStream codedoutputstream;
        CodedOutputStream codedoutputstream1;
        CodedOutputStream codedoutputstream2;
        String s2;
        codedoutputstream = null;
        s2 = null;
        codedoutputstream2 = null;
        codedoutputstream1 = null;
        Object obj = new ClsFileOutputStream(filesDir, (new StringBuilder()).append(s1).append("BeginSession").toString());
        codedoutputstream = s2;
        codedoutputstream1 = codedoutputstream2;
        codedoutputstream2 = CodedOutputStream.newInstance(((java.io.OutputStream) (obj)));
        codedoutputstream = codedoutputstream2;
        codedoutputstream1 = codedoutputstream2;
        s2 = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[] {
            crashlyticsCore.getVersion()
        });
        codedoutputstream = codedoutputstream2;
        codedoutputstream1 = codedoutputstream2;
        long l1 = date.getTime() / 1000L;
        codedoutputstream = codedoutputstream2;
        codedoutputstream1 = codedoutputstream2;
        sessionDataWriter.writeBeginSession(codedoutputstream2, s1, s2, l1);
        l.a(codedoutputstream2, "Failed to flush to session begin file.");
        l.a(((java.io.Closeable) (obj)), "Failed to close begin session file.");
        return;
        date;
        s1 = null;
_L4:
        ExceptionUtils.writeStackTraceIfNotNull(date, s1);
        throw date;
        obj;
        date = s1;
        codedoutputstream = codedoutputstream1;
        s1 = ((String) (obj));
_L2:
        l.a(codedoutputstream, "Failed to flush to session begin file.");
        l.a(date, "Failed to close begin session file.");
        throw s1;
        s1;
        date = null;
        continue; /* Loop/switch isn't completed */
        s1;
        date = ((Date) (obj));
        if (true) goto _L2; else goto _L1
_L1:
        date;
        s1 = ((String) (obj));
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void writeExternalCrashEvent(SessionEventData sessioneventdata)
    {
        Object obj1 = null;
        String s1 = getPreviousSessionId();
        if (s1 == null) goto _L2; else goto _L1
_L1:
        Object obj;
        CrashlyticsCore.recordFatalExceptionEvent(s1);
        obj = new ClsFileOutputStream(filesDir, (new StringBuilder()).append(s1).append("SessionCrash").toString());
        Map map;
        try
        {
            obj1 = CodedOutputStream.newInstance(((java.io.OutputStream) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (SessionEventData sessioneventdata)
        {
            obj1 = obj;
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj1 = obj;
            obj = null;
        }
        map = (new MetaDataStore(filesDir)).readKeyData(s1);
        NativeCrashWriter.writeNativeCrash(sessioneventdata, new LogFileManager(crashlyticsCore.getContext(), filesDir, s1), map, ((CodedOutputStream) (obj1)));
_L4:
        l.a(((java.io.Flushable) (obj1)), "Failed to flush to session begin file.");
        l.a(((java.io.Closeable) (obj)), "Failed to close fatal exception file output stream.");
        return;
_L2:
        e.d().c("CrashlyticsCore", "Tried to write a native crash while no session was open.", null);
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        sessioneventdata;
        obj1 = null;
        obj = null;
_L8:
        e.d().c("CrashlyticsCore", "An error occurred in the native crash logger", sessioneventdata);
        ExceptionUtils.writeStackTraceIfNotNull(sessioneventdata, ((java.io.OutputStream) (obj1)));
        l.a(((java.io.Flushable) (obj)), "Failed to flush to session begin file.");
        l.a(((java.io.Closeable) (obj1)), "Failed to close fatal exception file output stream.");
        return;
        sessioneventdata;
        obj1 = null;
        obj = null;
_L6:
        l.a(((java.io.Flushable) (obj)), "Failed to flush to session begin file.");
        l.a(((java.io.Closeable) (obj1)), "Failed to close fatal exception file output stream.");
        throw sessioneventdata;
        sessioneventdata;
        Object obj2 = obj;
        obj = obj1;
        obj1 = obj2;
        continue; /* Loop/switch isn't completed */
        sessioneventdata;
        if (true) goto _L6; else goto _L5
_L5:
        sessioneventdata;
        ClsFileOutputStream clsfileoutputstream = ((ClsFileOutputStream) (obj));
        obj = obj1;
        obj1 = clsfileoutputstream;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void writeFatal(Date date, Thread thread, Throwable throwable)
    {
        CodedOutputStream codedoutputstream;
        ClsFileOutputStream clsfileoutputstream;
        CodedOutputStream codedoutputstream1;
        Object obj1;
        Object obj2;
        codedoutputstream1 = null;
        codedoutputstream = null;
        obj2 = null;
        obj1 = null;
        clsfileoutputstream = null;
        Object obj;
        (new File(filesDir, "crash_marker")).createNewFile();
        obj = getCurrentSessionId();
        if (obj == null) goto _L2; else goto _L1
_L1:
        CrashlyticsCore.recordFatalExceptionEvent(((String) (obj)));
        obj = new ClsFileOutputStream(filesDir, (new StringBuilder()).append(((String) (obj))).append("SessionCrash").toString());
        codedoutputstream = obj2;
        clsfileoutputstream = ((ClsFileOutputStream) (obj));
        codedoutputstream1 = ((CodedOutputStream) (obj1));
        obj1 = CodedOutputStream.newInstance(((java.io.OutputStream) (obj)));
        codedoutputstream = ((CodedOutputStream) (obj1));
        clsfileoutputstream = ((ClsFileOutputStream) (obj));
        codedoutputstream1 = ((CodedOutputStream) (obj1));
        writeSessionEvent(((CodedOutputStream) (obj1)), date, thread, throwable, "crash", true);
_L4:
        l.a(((java.io.Flushable) (obj1)), "Failed to flush to session begin file.");
        l.a(((java.io.Closeable) (obj)), "Failed to close fatal exception file output stream.");
        return;
_L2:
        e.d().c("CrashlyticsCore", "Tried to write a fatal exception while no session was open.", null);
        obj = null;
        obj1 = clsfileoutputstream;
        if (true) goto _L4; else goto _L3
_L3:
        date;
        obj = null;
_L8:
        codedoutputstream = codedoutputstream1;
        clsfileoutputstream = ((ClsFileOutputStream) (obj));
        e.d().c("CrashlyticsCore", "An error occurred in the fatal exception logger", date);
        codedoutputstream = codedoutputstream1;
        clsfileoutputstream = ((ClsFileOutputStream) (obj));
        ExceptionUtils.writeStackTraceIfNotNull(date, ((java.io.OutputStream) (obj)));
        l.a(codedoutputstream1, "Failed to flush to session begin file.");
        l.a(((java.io.Closeable) (obj)), "Failed to close fatal exception file output stream.");
        return;
        date;
        clsfileoutputstream = null;
_L6:
        l.a(codedoutputstream, "Failed to flush to session begin file.");
        l.a(clsfileoutputstream, "Failed to close fatal exception file output stream.");
        throw date;
        date;
        if (true) goto _L6; else goto _L5
_L5:
        date;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void writeInitialPartsTo(CodedOutputStream codedoutputstream, String s1)
    {
        int i = 0;
        while (i < 4) 
        {
            String s2 = (new String[] {
                "SessionUser", "SessionApp", "SessionOS", "SessionDevice"
            })[i];
            File afile[] = listFilesMatching(new FileNameContainsFilter((new StringBuilder()).append(s1).append(s2).toString()));
            if (afile.length == 0)
            {
                e.d().c("CrashlyticsCore", (new StringBuilder("Can't find ")).append(s2).append(" data for session ID ").append(s1).toString(), null);
            } else
            {
                e.d().a("CrashlyticsCore", (new StringBuilder("Collecting ")).append(s2).append(" data for session ID ").append(s1).toString());
                writeToCosFromFile(codedoutputstream, afile[0]);
            }
            i++;
        }
    }

    private void writeNonFatalEventsTo(CodedOutputStream codedoutputstream, File afile[], String s1)
    {
        Arrays.sort(afile, l.a);
        int j = afile.length;
        int i = 0;
        while (i < j) 
        {
            File file = afile[i];
            try
            {
                e.d().a("CrashlyticsCore", String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[] {
                    s1, file.getName()
                }));
                writeToCosFromFile(codedoutputstream, file);
            }
            catch (Exception exception)
            {
                e.d().c("CrashlyticsCore", "Error writting non-fatal to session.", exception);
            }
            i++;
        }
    }

    private void writeSessionApp(String s1)
    {
        Object obj;
        Object obj3;
        String s2;
        String s3;
        obj3 = null;
        s3 = null;
        s2 = null;
        obj = null;
        Object obj2 = new ClsFileOutputStream(filesDir, (new StringBuilder()).append(s1).append("SessionApp").toString());
        s1 = s3;
        obj = s2;
        obj3 = CodedOutputStream.newInstance(((java.io.OutputStream) (obj2)));
        s1 = ((String) (obj3));
        obj = obj3;
        s2 = crashlyticsCore.getPackageName();
        s1 = ((String) (obj3));
        obj = obj3;
        s3 = crashlyticsCore.getVersionCode();
        s1 = ((String) (obj3));
        obj = obj3;
        String s4 = crashlyticsCore.getVersionName();
        s1 = ((String) (obj3));
        obj = obj3;
        String s5 = idManager.b();
        s1 = ((String) (obj3));
        obj = obj3;
        int i = s.a(crashlyticsCore.getInstallerPackageName()).a();
        s1 = ((String) (obj3));
        obj = obj3;
        sessionDataWriter.writeSessionApp(((CodedOutputStream) (obj3)), s2, s3, s4, s5, i);
        l.a(((java.io.Flushable) (obj3)), "Failed to flush to session app file.");
        l.a(((java.io.Closeable) (obj2)), "Failed to close session app file.");
        return;
        obj2;
        s1 = null;
_L4:
        ExceptionUtils.writeStackTraceIfNotNull(((Throwable) (obj2)), s1);
        throw obj2;
        obj3;
        Object obj1;
        obj2 = s1;
        s1 = ((String) (obj));
        obj1 = obj3;
_L2:
        l.a(s1, "Failed to flush to session app file.");
        l.a(((java.io.Closeable) (obj2)), "Failed to close session app file.");
        throw obj1;
        obj1;
        obj2 = null;
        s1 = ((String) (obj3));
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        s1 = ((String) (obj2));
        obj2 = exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void writeSessionDevice(String s1)
    {
        Object obj;
        Object obj3;
        Context context;
        String s2;
        Object obj4;
        context = null;
        obj3 = null;
        obj4 = null;
        s2 = null;
        obj = null;
        Object obj2 = new ClsFileOutputStream(filesDir, (new StringBuilder()).append(s1).append("SessionDevice").toString());
        s1 = ((String) (obj4));
        obj = s2;
        obj3 = CodedOutputStream.newInstance(((java.io.OutputStream) (obj2)));
        s1 = ((String) (obj3));
        obj = obj3;
        context = crashlyticsCore.getContext();
        s1 = ((String) (obj3));
        obj = obj3;
        obj4 = new StatFs(Environment.getDataDirectory().getPath());
        s1 = ((String) (obj3));
        obj = obj3;
        s2 = idManager.f();
        s1 = ((String) (obj3));
        obj = obj3;
        int i = l.a();
        s1 = ((String) (obj3));
        obj = obj3;
        int j = Runtime.getRuntime().availableProcessors();
        s1 = ((String) (obj3));
        obj = obj3;
        long l1 = l.b();
        s1 = ((String) (obj3));
        obj = obj3;
        long l2 = ((StatFs) (obj4)).getBlockCount();
        s1 = ((String) (obj3));
        obj = obj3;
        long l3 = ((StatFs) (obj4)).getBlockSize();
        s1 = ((String) (obj3));
        obj = obj3;
        boolean flag = l.e(context);
        s1 = ((String) (obj3));
        obj = obj3;
        obj4 = idManager.g();
        s1 = ((String) (obj3));
        obj = obj3;
        int k = l.g(context);
        s1 = ((String) (obj3));
        obj = obj3;
        sessionDataWriter.writeSessionDevice(((CodedOutputStream) (obj3)), s2, i, Build.MODEL, j, l1, l2 * l3, flag, ((Map) (obj4)), k, Build.MANUFACTURER, Build.PRODUCT);
        l.a(((java.io.Flushable) (obj3)), "Failed to flush session device info.");
        l.a(((java.io.Closeable) (obj2)), "Failed to close session device file.");
        return;
        obj2;
        s1 = context;
_L4:
        ExceptionUtils.writeStackTraceIfNotNull(((Throwable) (obj2)), s1);
        throw obj2;
        obj3;
        Object obj1;
        obj2 = s1;
        s1 = ((String) (obj));
        obj1 = obj3;
_L2:
        l.a(s1, "Failed to flush session device info.");
        l.a(((java.io.Closeable) (obj2)), "Failed to close session device file.");
        throw obj1;
        obj1;
        obj2 = null;
        s1 = ((String) (obj3));
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        s1 = ((String) (obj2));
        obj2 = exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void writeSessionEvent(CodedOutputStream codedoutputstream, Date date, Thread thread, Throwable throwable, String s1, boolean flag)
    {
        float f;
        Thread athread[];
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
        LinkedList linkedlist;
        StackTraceElement astacktraceelement[];
        Context context;
        int j;
        int k;
        long l1;
        long l2;
        long l3;
        long l4;
        boolean flag1;
        context = crashlyticsCore.getContext();
        l1 = date.getTime() / 1000L;
        f = l.c(context);
        j = l.a(context, powerConnected);
        flag1 = l.d(context);
        k = context.getResources().getConfiguration().orientation;
        l2 = l.b();
        l3 = l.b(context);
        l4 = l.b(Environment.getDataDirectory().getPath());
        runningappprocessinfo = l.a(context.getPackageName(), context);
        linkedlist = new LinkedList();
        astacktraceelement = throwable.getStackTrace();
        if (flag)
        {
            Map map = Thread.getAllStackTraces();
            date = new Thread[map.size()];
            Iterator iterator = map.entrySet().iterator();
            int i = 0;
            do
            {
                athread = date;
                if (!iterator.hasNext())
                {
                    break;
                }
                athread = (java.util.Map.Entry)iterator.next();
                date[i] = (Thread)athread.getKey();
                linkedlist.add(athread.getValue());
                i++;
            } while (true);
        } else
        {
            athread = new Thread[0];
        }
        if (l.a(context, "com.crashlytics.CollectCustomKeys", true)) goto _L2; else goto _L1
_L1:
        date = new TreeMap();
_L4:
        sessionDataWriter.writeSessionEvent(codedoutputstream, l1, thread, throwable, s1, athread, f, j, flag1, k, l2 - l3, l4, runningappprocessinfo, linkedlist, astacktraceelement, logFileManager, date);
        return;
_L2:
        date = crashlyticsCore.getAttributes();
        if (date != null && date.size() > 1)
        {
            date = new TreeMap(date);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void writeSessionOS(String s1)
    {
        Object obj;
        Object obj1;
        CodedOutputStream codedoutputstream;
        Object obj2;
        obj2 = null;
        obj = null;
        codedoutputstream = null;
        obj1 = null;
        ClsFileOutputStream clsfileoutputstream = new ClsFileOutputStream(filesDir, (new StringBuilder()).append(s1).append("SessionOS").toString());
        s1 = obj2;
        obj = clsfileoutputstream;
        obj1 = codedoutputstream;
        codedoutputstream = CodedOutputStream.newInstance(clsfileoutputstream);
        s1 = codedoutputstream;
        obj = clsfileoutputstream;
        obj1 = codedoutputstream;
        boolean flag = l.f(crashlyticsCore.getContext());
        s1 = codedoutputstream;
        obj = clsfileoutputstream;
        obj1 = codedoutputstream;
        sessionDataWriter.writeSessionOS(codedoutputstream, flag);
        l.a(codedoutputstream, "Failed to flush to session OS file.");
        l.a(clsfileoutputstream, "Failed to close session OS file.");
        return;
        Exception exception1;
        exception1;
        clsfileoutputstream = null;
_L4:
        s1 = ((String) (obj1));
        obj = clsfileoutputstream;
        ExceptionUtils.writeStackTraceIfNotNull(exception1, clsfileoutputstream);
        s1 = ((String) (obj1));
        obj = clsfileoutputstream;
        throw exception1;
        Exception exception;
        exception;
        obj1 = obj;
        obj = s1;
        s1 = exception;
_L2:
        l.a(((java.io.Flushable) (obj)), "Failed to flush to session OS file.");
        l.a(((java.io.Closeable) (obj1)), "Failed to close session OS file.");
        throw s1;
        s1;
        obj1 = null;
        if (true) goto _L2; else goto _L1
_L1:
        exception1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void writeSessionPartsToSessionFile(File file, String s1, int i)
    {
        Object obj;
        CodedOutputStream codedoutputstream;
        Object obj1;
        codedoutputstream = null;
        e.d().a("CrashlyticsCore", (new StringBuilder("Collecting session parts for ID ")).append(s1).toString());
        File afile[] = listFilesMatching(new FileNameContainsFilter((new StringBuilder()).append(s1).append("SessionCrash").toString()));
        boolean flag;
        boolean flag1;
        if (afile != null && afile.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e.d().a("CrashlyticsCore", String.format(Locale.US, "Session %s has fatal exception: %s", new Object[] {
            s1, Boolean.valueOf(flag)
        }));
        obj1 = listFilesMatching(new FileNameContainsFilter((new StringBuilder()).append(s1).append("SessionEvent").toString()));
        if (obj1 != null && obj1.length > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        e.d().a("CrashlyticsCore", String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[] {
            s1, Boolean.valueOf(flag1)
        }));
        if (!flag && !flag1) goto _L2; else goto _L1
_L1:
        obj = new ClsFileOutputStream(filesDir, s1);
        codedoutputstream = CodedOutputStream.newInstance(((java.io.OutputStream) (obj)));
        e.d().a("CrashlyticsCore", (new StringBuilder("Collecting SessionStart data for session ID ")).append(s1).toString());
        writeToCosFromFile(codedoutputstream, file);
        codedoutputstream.writeUInt64(4, (new Date()).getTime() / 1000L);
        codedoutputstream.writeBool(5, flag);
        writeInitialPartsTo(codedoutputstream, s1);
        if (!flag1) goto _L4; else goto _L3
_L3:
        if (obj1.length <= i)
        {
            break MISSING_BLOCK_LABEL_608;
        }
        e.d().a("CrashlyticsCore", String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[] {
            Integer.valueOf(i)
        }));
        trimSessionEventFiles(s1, i);
        file = listFilesMatching(new FileNameContainsFilter((new StringBuilder()).append(s1).append("SessionEvent").toString()));
_L8:
        writeNonFatalEventsTo(codedoutputstream, file, s1);
_L4:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_389;
        }
        writeToCosFromFile(codedoutputstream, afile[0]);
        codedoutputstream.writeUInt32(11, 1);
        codedoutputstream.writeEnum(12, 3);
        l.a(codedoutputstream, "Error flushing session file stream");
        l.a(((java.io.Closeable) (obj)), "Failed to close CLS file");
_L5:
        e.d().a("CrashlyticsCore", (new StringBuilder("Removing session part files for ID ")).append(s1).toString());
        deleteSessionPartFilesFor(s1);
        return;
        obj1;
        file = null;
        obj = codedoutputstream;
_L7:
        e.d().c("CrashlyticsCore", (new StringBuilder("Failed to write session file for session ID: ")).append(s1).toString(), ((Throwable) (obj1)));
        ExceptionUtils.writeStackTraceIfNotNull(((Throwable) (obj1)), ((java.io.OutputStream) (obj)));
        l.a(file, "Error flushing session file stream");
        closeWithoutRenamingOrLog(((ClsFileOutputStream) (obj)));
          goto _L5
        s1;
        file = null;
        obj = null;
_L6:
        l.a(file, "Error flushing session file stream");
        l.a(((java.io.Closeable) (obj)), "Failed to close CLS file");
        throw s1;
_L2:
        e.d().a("CrashlyticsCore", (new StringBuilder("No events present for session ID ")).append(s1).toString());
          goto _L5
        s1;
        file = null;
          goto _L6
        s1;
        file = codedoutputstream;
          goto _L6
        s1;
          goto _L6
        obj1;
        file = null;
          goto _L7
        obj1;
        file = codedoutputstream;
          goto _L7
        file = ((File) (obj1));
          goto _L8
    }

    private void writeSessionUser(String s1)
    {
        CodedOutputStream codedoutputstream;
        Object obj;
        CodedOutputStream codedoutputstream1;
        CodedOutputStream codedoutputstream2;
        obj = null;
        codedoutputstream = null;
        codedoutputstream2 = null;
        codedoutputstream1 = null;
        ClsFileOutputStream clsfileoutputstream = new ClsFileOutputStream(filesDir, (new StringBuilder()).append(s1).append("SessionUser").toString());
        codedoutputstream = ((CodedOutputStream) (obj));
        obj = clsfileoutputstream;
        codedoutputstream1 = codedoutputstream2;
        codedoutputstream2 = CodedOutputStream.newInstance(clsfileoutputstream);
        codedoutputstream = codedoutputstream2;
        obj = clsfileoutputstream;
        codedoutputstream1 = codedoutputstream2;
        s1 = getUserMetaData(s1);
        codedoutputstream = codedoutputstream2;
        obj = clsfileoutputstream;
        codedoutputstream1 = codedoutputstream2;
        boolean flag = s1.isEmpty();
        if (flag)
        {
            l.a(codedoutputstream2, "Failed to flush session user file.");
            l.a(clsfileoutputstream, "Failed to close session user file.");
            return;
        }
        codedoutputstream = codedoutputstream2;
        obj = clsfileoutputstream;
        codedoutputstream1 = codedoutputstream2;
        sessionDataWriter.writeSessionUser(codedoutputstream2, ((UserMetaData) (s1)).id, ((UserMetaData) (s1)).name, ((UserMetaData) (s1)).email);
        l.a(codedoutputstream2, "Failed to flush session user file.");
        l.a(clsfileoutputstream, "Failed to close session user file.");
        return;
        Exception exception;
        exception;
        s1 = null;
_L4:
        codedoutputstream = codedoutputstream1;
        obj = s1;
        ExceptionUtils.writeStackTraceIfNotNull(exception, s1);
        codedoutputstream = codedoutputstream1;
        obj = s1;
        throw exception;
        s1;
_L2:
        l.a(codedoutputstream, "Failed to flush session user file.");
        l.a(((java.io.Closeable) (obj)), "Failed to close session user file.");
        throw s1;
        s1;
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        s1 = clsfileoutputstream;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void writeToCosFromFile(CodedOutputStream codedoutputstream, File file)
    {
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        byte abyte0[] = new byte[(int)file.length()];
        file = new FileInputStream(file);
        int i = 0;
_L4:
        int j;
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        j = file.read(abyte0, i, abyte0.length - i);
        if (j < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i += j;
        if (true) goto _L4; else goto _L3
_L3:
        l.a(file, "Failed to close file input stream.");
        codedoutputstream.writeRawBytes(abyte0);
        return;
        codedoutputstream;
        file = null;
_L6:
        l.a(file, "Failed to close file input stream.");
        throw codedoutputstream;
_L2:
        e.d().c("CrashlyticsCore", (new StringBuilder("Tried to include a file that doesn't exist: ")).append(file.getName()).toString(), null);
        return;
        codedoutputstream;
        if (true) goto _L6; else goto _L5
_L5:
    }

    void cacheKeyData(final Map keyData)
    {
        executorServiceWrapper.executeAsync(new _cls11());
    }

    void cacheUserData(final String userId, final String userName, final String userEmail)
    {
        executorServiceWrapper.executeAsync(new _cls10());
    }

    void cleanInvalidTempFiles()
    {
        executorServiceWrapper.executeAsync(new _cls14());
    }

    void doCleanInvalidTempFiles(File afile[])
    {
        deleteLegacyInvalidCacheDir();
        int k = afile.length;
        for (int i = 0; i < k; i++)
        {
            final String sessionId = afile[i];
            e.d().a("CrashlyticsCore", (new StringBuilder("Found invalid session part file: ")).append(sessionId).toString());
            sessionId = getSessionIdFromSessionFile(sessionId);
            _cls15 _lcls15 = new _cls15();
            e.d().a("CrashlyticsCore", (new StringBuilder("Deleting all part files for invalid session: ")).append(sessionId).toString());
            File afile1[] = listFilesMatching(_lcls15);
            int i1 = afile1.length;
            for (int j = 0; j < i1; j++)
            {
                File file = afile1[j];
                e.d().a("CrashlyticsCore", (new StringBuilder("Deleting session file: ")).append(file).toString());
                file.delete();
            }

        }

    }

    void doCloseSessions()
    {
        doCloseSessions(false);
    }

    boolean finalizeSessions()
    {
        return ((Boolean)executorServiceWrapper.executeSyncLoggingException(new _cls13())).booleanValue();
    }

    boolean hasOpenSession()
    {
        return listSessionBeginFiles().length > 0;
    }

    boolean isHandlingException()
    {
        return isHandlingException.get();
    }

    File[] listSessionBeginFiles()
    {
        return listFilesMatching(new FileNameContainsFilter("BeginSession"));
    }

    void openSession()
    {
        executorServiceWrapper.executeAsync(new _cls12());
    }

    void trimSessionFiles()
    {
        Utils.capFileCount(filesDir, SESSION_FILE_FILTER, 4, SMALLEST_FILE_NAME_FIRST);
    }

    public void uncaughtException(final Thread thread, final Throwable ex)
    {
        this;
        JVM INSTR monitorenter ;
        isHandlingException.set(true);
        e.d().a("CrashlyticsCore", (new StringBuilder("Crashlytics is handling uncaught exception \"")).append(ex).append("\" from thread ").append(thread.getName()).toString());
        if (!receiversRegistered.getAndSet(true))
        {
            e.d().a("CrashlyticsCore", "Unregistering power receivers.");
            Context context = crashlyticsCore.getContext();
            context.unregisterReceiver(powerConnectedReceiver);
            context.unregisterReceiver(powerDisconnectedReceiver);
        }
        final Date now = new Date();
        executorServiceWrapper.executeSyncLoggingException(new _cls7());
        e.d().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
        defaultHandler.uncaughtException(thread, ex);
        isHandlingException.set(false);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        e.d().c("CrashlyticsCore", "An error occurred in the uncaught exception handler", ((Throwable) (obj)));
        e.d().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
        defaultHandler.uncaughtException(thread, ex);
        isHandlingException.set(false);
        if (true) goto _L2; else goto _L1
_L1:
        thread;
        throw thread;
        obj;
        e.d().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
        defaultHandler.uncaughtException(thread, ex);
        isHandlingException.set(false);
        throw obj;
    }

    void writeNonFatalException(final Thread thread, final Throwable ex)
    {
        final Date now = new Date();
        executorServiceWrapper.executeAsync(new _cls9());
    }

    void writeToLog(final long timestamp, final String msg)
    {
        executorServiceWrapper.executeAsync(new _cls8());
    }





/*
    static boolean access$102(CrashlyticsUncaughtExceptionHandler crashlyticsuncaughtexceptionhandler, boolean flag)
    {
        crashlyticsuncaughtexceptionhandler.powerConnected = flag;
        return flag;
    }

*/












    private class _cls5 extends BroadcastReceiver
    {

        final CrashlyticsUncaughtExceptionHandler this$0;

        public void onReceive(Context context, Intent intent)
        {
            powerConnected = true;
        }

        _cls5()
        {
            this$0 = CrashlyticsUncaughtExceptionHandler.this;
            super();
        }
    }


    private class _cls6 extends BroadcastReceiver
    {

        final CrashlyticsUncaughtExceptionHandler this$0;

        public void onReceive(Context context, Intent intent)
        {
            powerConnected = false;
        }

        _cls6()
        {
            this$0 = CrashlyticsUncaughtExceptionHandler.this;
            super();
        }
    }


    private class SessionPartFileFilter
        implements FilenameFilter
    {

        private final String sessionId;

        public boolean accept(File file, String s1)
        {
            while (s1.equals((new StringBuilder()).append(sessionId).append(".cls").toString()) || !s1.contains(sessionId) || s1.endsWith(".cls_temp")) 
            {
                return false;
            }
            return true;
        }

        public SessionPartFileFilter(String s1)
        {
            sessionId = s1;
        }
    }


    private class _cls16
        implements Runnable
    {

        final CrashlyticsUncaughtExceptionHandler this$0;
        final File val$toSend;

        public void run()
        {
            if (l.l(crashlyticsCore.getContext()))
            {
                e.d().a("CrashlyticsCore", "Attempting to send crash report at time of crash...");
                Object obj = n.a().b();
                obj = crashlyticsCore.getCreateReportSpiCall(((c.a.a.a.a.g.s) (obj)));
                if (obj != null)
                {
                    (new ReportUploader(((CreateReportSpiCall) (obj)))).forceUpload(new SessionReport(toSend, CrashlyticsUncaughtExceptionHandler.SEND_AT_CRASHTIME_HEADER));
                }
            }
        }

        _cls16()
        {
            this$0 = CrashlyticsUncaughtExceptionHandler.this;
            toSend = file;
            super();
        }
    }


    private class AnySessionPartFileFilter
        implements FilenameFilter
    {

        public boolean accept(File file, String s1)
        {
            return !CrashlyticsUncaughtExceptionHandler.SESSION_FILE_FILTER.accept(file, s1) && CrashlyticsUncaughtExceptionHandler.SESSION_FILE_PATTERN.matcher(s1).matches();
        }

        private AnySessionPartFileFilter()
        {
        }

        AnySessionPartFileFilter(_cls1 _pcls1)
        {
            this();
        }
    }


    private class FileNameContainsFilter
        implements FilenameFilter
    {

        private final String string;

        public boolean accept(File file, String s1)
        {
            return s1.contains(string) && !s1.endsWith(".cls_temp");
        }

        public FileNameContainsFilter(String s1)
        {
            string = s1;
        }
    }


    private class _cls11
        implements Callable
    {

        final CrashlyticsUncaughtExceptionHandler this$0;
        final Map val$keyData;

        public volatile Object call()
        {
            return call();
        }

        public Void call()
        {
            String s1 = getCurrentSessionId();
            (new MetaDataStore(filesDir)).writeKeyData(s1, keyData);
            return null;
        }

        _cls11()
        {
            this$0 = CrashlyticsUncaughtExceptionHandler.this;
            keyData = map;
            super();
        }
    }


    private class _cls10
        implements Callable
    {

        final CrashlyticsUncaughtExceptionHandler this$0;
        final String val$userEmail;
        final String val$userId;
        final String val$userName;

        public volatile Object call()
        {
            return call();
        }

        public Void call()
        {
            String s1 = getCurrentSessionId();
            (new MetaDataStore(filesDir)).writeUserData(s1, new UserMetaData(userId, userName, userEmail));
            return null;
        }

        _cls10()
        {
            this$0 = CrashlyticsUncaughtExceptionHandler.this;
            userId = s1;
            userName = s2;
            userEmail = s3;
            super();
        }
    }


    private class _cls14
        implements Runnable
    {

        final CrashlyticsUncaughtExceptionHandler this$0;

        public void run()
        {
            doCleanInvalidTempFiles(listFilesMatching(ClsFileOutputStream.TEMP_FILENAME_FILTER));
        }

        _cls14()
        {
            this$0 = CrashlyticsUncaughtExceptionHandler.this;
            super();
        }
    }


    private class _cls15
        implements FilenameFilter
    {

        final CrashlyticsUncaughtExceptionHandler this$0;
        final String val$sessionId;

        public boolean accept(File file, String s1)
        {
            return s1.startsWith(sessionId);
        }

        _cls15()
        {
            this$0 = CrashlyticsUncaughtExceptionHandler.this;
            sessionId = s1;
            super();
        }
    }


    private class _cls13
        implements Callable
    {

        final CrashlyticsUncaughtExceptionHandler this$0;

        public Boolean call()
        {
            if (!isHandlingException.get())
            {
                e.d().a("CrashlyticsCore", "Finalizing previously open sessions.");
                SessionEventData sessioneventdata = crashlyticsCore.getExternalCrashEventData();
                if (sessioneventdata != null)
                {
                    writeExternalCrashEvent(sessioneventdata);
                }
                doCloseSessions(true);
                e.d().a("CrashlyticsCore", "Closed all previously open sessions");
                return Boolean.valueOf(true);
            } else
            {
                e.d().a("CrashlyticsCore", "Skipping session finalization because a crash has already occurred.");
                return Boolean.valueOf(false);
            }
        }

        public volatile Object call()
        {
            return call();
        }

        _cls13()
        {
            this$0 = CrashlyticsUncaughtExceptionHandler.this;
            super();
        }
    }


    private class _cls12
        implements Callable
    {

        final CrashlyticsUncaughtExceptionHandler this$0;

        public volatile Object call()
        {
            return call();
        }

        public Void call()
        {
            doOpenSession();
            return null;
        }

        _cls12()
        {
            this$0 = CrashlyticsUncaughtExceptionHandler.this;
            super();
        }
    }


    private class _cls7
        implements Callable
    {

        final CrashlyticsUncaughtExceptionHandler this$0;
        final Throwable val$ex;
        final Date val$now;
        final Thread val$thread;

        public volatile Object call()
        {
            return call();
        }

        public Void call()
        {
            handleUncaughtException(now, thread, ex);
            return null;
        }

        _cls7()
        {
            this$0 = CrashlyticsUncaughtExceptionHandler.this;
            now = date;
            thread = thread1;
            ex = throwable;
            super();
        }
    }


    private class _cls9
        implements Runnable
    {

        final CrashlyticsUncaughtExceptionHandler this$0;
        final Throwable val$ex;
        final Date val$now;
        final Thread val$thread;

        public void run()
        {
            if (!isHandlingException.get())
            {
                doWriteNonFatal(now, thread, ex);
            }
        }

        _cls9()
        {
            this$0 = CrashlyticsUncaughtExceptionHandler.this;
            now = date;
            thread = thread1;
            ex = throwable;
            super();
        }
    }


    private class _cls8
        implements Callable
    {

        final CrashlyticsUncaughtExceptionHandler this$0;
        final String val$msg;
        final long val$timestamp;

        public volatile Object call()
        {
            return call();
        }

        public Void call()
        {
            if (!isHandlingException.get())
            {
                logFileManager.writeToLog(timestamp, msg);
            }
            return null;
        }

        _cls8()
        {
            this$0 = CrashlyticsUncaughtExceptionHandler.this;
            timestamp = l1;
            msg = s1;
            super();
        }
    }


    private class _cls1
        implements FilenameFilter
    {

        public final boolean accept(File file, String s1)
        {
            return s1.length() == 39 && s1.endsWith(".cls");
        }

        _cls1()
        {
        }
    }


    private class _cls2
        implements Comparator
    {

        public final int compare(File file, File file1)
        {
            return file1.getName().compareTo(file.getName());
        }

        public final volatile int compare(Object obj, Object obj1)
        {
            return compare((File)obj, (File)obj1);
        }

        _cls2()
        {
        }
    }


    private class _cls3
        implements Comparator
    {

        public final int compare(File file, File file1)
        {
            return file.getName().compareTo(file1.getName());
        }

        public final volatile int compare(Object obj, Object obj1)
        {
            return compare((File)obj, (File)obj1);
        }

        _cls3()
        {
        }
    }


    private class _cls4
        implements FilenameFilter
    {

        public final boolean accept(File file, String s1)
        {
            return CrashlyticsUncaughtExceptionHandler.SESSION_FILE_PATTERN.matcher(s1).matches();
        }

        _cls4()
        {
        }
    }

}
