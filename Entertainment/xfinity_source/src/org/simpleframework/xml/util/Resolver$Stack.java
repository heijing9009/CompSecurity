// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.util;

import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package org.simpleframework.xml.util:
//            Resolver, Match

private class <init> extends LinkedList
{
    private class Sequence
        implements Iterator
    {

        private int cursor;
        final Resolver.Stack this$1;

        public boolean hasNext()
        {
            return cursor > 0;
        }

        public volatile Object next()
        {
            return next();
        }

        public Match next()
        {
            if (hasNext())
            {
                Resolver.Stack stack = Resolver.Stack.this;
                int i = cursor - 1;
                cursor = i;
                return (Match)stack.get(i);
            } else
            {
                return null;
            }
        }

        public void remove()
        {
            purge(cursor);
        }

        public Sequence()
        {
            this$1 = Resolver.Stack.this;
            super();
            cursor = size();
        }
    }


    final Resolver this$0;

    public void purge(int i)
    {
        cache.clear();
        remove(i);
    }

    public void push(Match match)
    {
        cache.clear();
        addFirst(match);
    }

    public Iterator sequence()
    {
        return new Sequence();
    }

    private size()
    {
        this$0 = Resolver.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
