// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.whatsapp;

import java.util.Arrays;

public class zi
{

    private static final String z[];
    public byte a[];
    public int b;
    public byte c[];

    public zi(int i, byte abyte0[], byte abyte1[])
    {
        b = i;
        a = abyte0;
        c = abyte1;
    }

    public String toString()
    {
        return (new StringBuilder()).append(z[1]).append(b).append(z[2]).append(Arrays.toString(a)).append(z[0]).append(Arrays.toString(c)).append("]").toString();
    }

    static 
    {
        Object obj;
        String as[];
        byte byte1;
        int i;
        as = new String[3];
        obj = "\036<H{G]iGllSoA%";
        byte1 = -1;
        i = 0;
_L2:
        String as1[];
        int j;
        int k;
        as1 = as;
        obj = ((String) (obj)).toCharArray();
        k = obj.length;
        j = 0;
_L8:
label0:
        {
            if (k > j)
            {
                break label0;
            }
            obj = (new String(((char []) (obj)))).intern();
            switch (byte1)
            {
            default:
                as1[i] = ((String) (obj));
                obj = "uy][MBtLjoWe{}WGp]8\177QsM}\031";
                i = 1;
                byte1 = 0;
                break;

            case 0: // '\0'
                as1[i] = ((String) (obj));
                i = 2;
                obj = "\036<B}]\017";
                byte1 = 1;
                break;

            case 1: // '\001'
                as1[i] = ((String) (obj));
                z = as;
                return;
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        char c1 = obj[j];
        j % 5;
        JVM INSTR tableswitch 0 3: default 156
    //                   0 177
    //                   1 183
    //                   2 189
    //                   3 195;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_195;
_L3:
        byte byte0 = 36;
_L9:
        obj[j] = (char)(byte0 ^ c1);
        j++;
          goto _L8
_L4:
        byte0 = 50;
          goto _L9
_L5:
        byte0 = 28;
          goto _L9
_L6:
        byte0 = 41;
          goto _L9
        byte0 = 24;
          goto _L9
    }
}
