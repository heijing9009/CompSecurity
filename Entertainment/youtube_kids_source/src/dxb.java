// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dxb extends eul
{

    public static final dxb a[] = new dxb[0];
    private int b;
    private dor c[];

    public dxb()
    {
        b = 0;
        c = dor.a;
    }

    public final int a()
    {
        int j = 0;
        int i;
        int k;
        if (b != 0)
        {
            i = euj.c(1, b) + 0;
        } else
        {
            i = 0;
        }
        k = i;
        if (c != null)
        {
            dor ador[] = c;
            int l = ador.length;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                dor dor1 = ador[j];
                k = i;
                if (dor1 != null)
                {
                    k = i + euj.b(2, dor1);
                }
                j++;
                i = k;
            } while (true);
        }
        i = k + eup.a(O);
        P = i;
        return i;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int i = eui1.a();
            switch (i)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                int j = eui1.d();
                if (j == 0 || j == 1 || j == 2 || j == 3 || j == 4 || j == 5 || j == 6)
                {
                    b = j;
                } else
                {
                    b = 0;
                }
                break;

            case 18: // '\022'
                int l = eup.a(eui1, 18);
                dor ador[];
                int k;
                if (c == null)
                {
                    k = 0;
                } else
                {
                    k = c.length;
                }
                ador = new dor[l + k];
                if (c != null)
                {
                    System.arraycopy(c, 0, ador, 0, k);
                }
                for (c = ador; k < c.length - 1; k++)
                {
                    c[k] = new dor();
                    eui1.a(c[k]);
                    eui1.a();
                }

                c[k] = new dor();
                eui1.a(c[k]);
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (b != 0)
        {
            euj1.a(1, b);
        }
        if (c != null)
        {
            dor ador[] = c;
            int j = ador.length;
            for (int i = 0; i < j; i++)
            {
                dor dor1 = ador[i];
                if (dor1 != null)
                {
                    euj1.a(2, dor1);
                }
            }

        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dxb))
        {
            return false;
        }
        obj = (dxb)obj;
        if (b != ((dxb) (obj)).b || !Arrays.equals(c, ((dxb) (obj)).c))
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dxb) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dxb) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i;
        boolean flag;
        flag = false;
        i = (getClass().getName().hashCode() + 527) * 31 + b;
        if (c != null) goto _L2; else goto _L1
_L1:
        int k = i * 31;
_L4:
        int j;
        if (O == null)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = O.hashCode();
        }
        return k * 31 + i;
_L2:
        j = 0;
_L5:
        k = i;
        if (j >= c.length) goto _L4; else goto _L3
_L3:
        if (c[j] == null)
        {
            k = 0;
        } else
        {
            k = c[j].hashCode();
        }
        i = k + i * 31;
        j++;
          goto _L5
    }

}
