// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;


// Referenced classes of package dagger.internal:
//            Binding, Linker

final class BuiltInBinding extends Binding
{

    private Binding _flddelegate;
    private final String delegateKey;

    public BuiltInBinding(String s, Object obj, String s1)
    {
        super(s, null, false, obj);
        delegateKey = s1;
    }

    public void attach(Linker linker)
    {
        _flddelegate = linker.requestBinding(delegateKey, requiredBy);
    }

    public Object get()
    {
        return _flddelegate;
    }

    public void injectMembers(Object obj)
    {
        throw new UnsupportedOperationException();
    }
}
