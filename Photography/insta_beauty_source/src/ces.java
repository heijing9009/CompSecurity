// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ces
{

    private ExecutorService a;
    private final Handler b = new Handler();

    public ces()
    {
        a = Executors.newFixedThreadPool(5);
    }

    static Handler a(ces ces1)
    {
        return ces1.b;
    }

    public byte[] a(String s)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        s = (new URL(s)).openStream();
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[4096];
_L1:
        int i = s.read(abyte0);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new RuntimeException(s);
            }
        }
          goto _L1
        abyte0 = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.close();
        s.close();
        return abyte0;
    }

    public byte[] a(String s, cew cew)
    {
        a.submit(new cet(this, s, cew));
        return null;
    }
}
