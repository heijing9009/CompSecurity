// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.j256.ormlite.logger:
//            Log, LoggerFactory

public class LocalLog
    implements Log
{
    private static class PatternLevel
    {

        Log.Level level;
        Pattern pattern;

        public PatternLevel(Pattern pattern1, Log.Level level1)
        {
            pattern = pattern1;
            level = level1;
        }
    }


    private static final Log.Level DEFAULT_LEVEL;
    private static final List classLevels = readLevelResourceFile(com/j256/ormlite/logger/LocalLog.getResourceAsStream("/ormliteLocalLog.properties"));
    private static final ThreadLocal dateFormatThreadLocal = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected DateFormat initialValue()
        {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        }

    };
    private static PrintStream printStream;
    private final String className;
    private final Log.Level level;

    public LocalLog(String s)
    {
        className = LoggerFactory.getSimpleClassName(s);
        Object obj = null;
        Log.Level level1 = null;
        if (classLevels != null)
        {
            Iterator iterator = classLevels.iterator();
            do
            {
                obj = level1;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (PatternLevel)iterator.next();
                if (((PatternLevel) (obj)).pattern.matcher(s).matches() && (level1 == null || ((PatternLevel) (obj)).level.ordinal() < level1.ordinal()))
                {
                    level1 = ((PatternLevel) (obj)).level;
                }
            } while (true);
        }
        s = ((String) (obj));
        if (obj == null)
        {
            String s1 = System.getProperty("com.j256.ormlite.logger.level");
            if (s1 == null)
            {
                s = DEFAULT_LEVEL;
            } else
            {
                try
                {
                    s = Log.Level.valueOf(s1.toUpperCase());
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Level '").append(s1).append("' was not found").toString(), s);
                }
            }
        }
        level = s;
    }

    private static List configureClassLevels(InputStream inputstream)
        throws IOException
    {
        ArrayList arraylist;
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
        arraylist = new ArrayList();
_L2:
        String as[];
        Object obj;
        do
        {
            obj = inputstream.readLine();
            if (obj == null)
            {
                return arraylist;
            }
        } while (((String) (obj)).length() == 0 || ((String) (obj)).charAt(0) == '#');
        as = ((String) (obj)).split("=");
        if (as.length != 2)
        {
            System.err.println((new StringBuilder()).append("Line is not in the format of 'pattern = level': ").append(((String) (obj))).toString());
            continue; /* Loop/switch isn't completed */
        }
        obj = Pattern.compile(as[0].trim());
        Log.Level level1 = Log.Level.valueOf(as[1].trim());
        arraylist.add(new PatternLevel(((Pattern) (obj)), level1));
        continue; /* Loop/switch isn't completed */
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        System.err.println((new StringBuilder()).append("Level '").append(as[1]).append("' was not found").toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void openLogFile(String s)
    {
        if (s == null)
        {
            printStream = System.out;
            return;
        }
        try
        {
            printStream = new PrintStream(new File(s));
            return;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Log file ").append(s).append(" was not found").toString(), filenotfoundexception);
        }
    }

    private void printMessage(Log.Level level1, String s, Throwable throwable)
    {
        if (isLevelEnabled(level1))
        {
            StringBuilder stringbuilder = new StringBuilder(128);
            stringbuilder.append(((DateFormat)dateFormatThreadLocal.get()).format(new Date()));
            stringbuilder.append(" [").append(level1.name()).append("] ");
            stringbuilder.append(className).append(' ');
            stringbuilder.append(s);
            printStream.println(stringbuilder.toString());
            if (throwable != null)
            {
                throwable.printStackTrace(printStream);
                return;
            }
        }
    }

    static List readLevelResourceFile(InputStream inputstream)
    {
        Object obj;
        obj = null;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        obj = configureClassLevels(inputstream);
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return ((List) (obj));
        }
        return ((List) (obj));
        obj;
        System.err.println((new StringBuilder()).append("IO exception reading the log properties file '/ormliteLocalLog.properties': ").append(obj).toString());
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return null;
        }
        return null;
        obj;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream) { }
        throw obj;
    }

    public boolean isLevelEnabled(Log.Level level1)
    {
        return level.isEnabled(level1);
    }

    public void log(Log.Level level1, String s)
    {
        printMessage(level1, s, null);
    }

    public void log(Log.Level level1, String s, Throwable throwable)
    {
        printMessage(level1, s, throwable);
    }

    static 
    {
        DEFAULT_LEVEL = Log.Level.DEBUG;
        openLogFile(System.getProperty("com.j256.ormlite.logger.file"));
    }
}
