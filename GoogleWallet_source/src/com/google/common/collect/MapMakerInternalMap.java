// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.common.collect:
//            MapMaker, CollectPreconditions, AbstractSequentialIterator, AbstractMapEntry, 
//            Iterators

class MapMakerInternalMap extends AbstractMap
    implements Serializable, ConcurrentMap
{
    static abstract class AbstractReferenceEntry
        implements ReferenceEntry
    {

        public long getExpirationTime()
        {
            throw new UnsupportedOperationException();
        }

        public final int getHash()
        {
            throw new UnsupportedOperationException();
        }

        public final Object getKey()
        {
            throw new UnsupportedOperationException();
        }

        public final ReferenceEntry getNext()
        {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getNextEvictable()
        {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getNextExpirable()
        {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getPreviousEvictable()
        {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getPreviousExpirable()
        {
            throw new UnsupportedOperationException();
        }

        public final ValueReference getValueReference()
        {
            throw new UnsupportedOperationException();
        }

        public void setExpirationTime(long l)
        {
            throw new UnsupportedOperationException();
        }

        public void setNextEvictable(ReferenceEntry referenceentry)
        {
            throw new UnsupportedOperationException();
        }

        public void setNextExpirable(ReferenceEntry referenceentry)
        {
            throw new UnsupportedOperationException();
        }

        public void setPreviousEvictable(ReferenceEntry referenceentry)
        {
            throw new UnsupportedOperationException();
        }

        public void setPreviousExpirable(ReferenceEntry referenceentry)
        {
            throw new UnsupportedOperationException();
        }

        public final void setValueReference(ValueReference valuereference)
        {
            throw new UnsupportedOperationException();
        }

        AbstractReferenceEntry()
        {
        }
    }

    static abstract class EntryFactory extends Enum
    {

        private static final EntryFactory $VALUES[];
        public static final EntryFactory STRONG;
        public static final EntryFactory STRONG_EVICTABLE;
        public static final EntryFactory STRONG_EXPIRABLE;
        public static final EntryFactory STRONG_EXPIRABLE_EVICTABLE;
        public static final EntryFactory WEAK;
        public static final EntryFactory WEAK_EVICTABLE;
        public static final EntryFactory WEAK_EXPIRABLE;
        public static final EntryFactory WEAK_EXPIRABLE_EVICTABLE;
        static final EntryFactory factories[][];

        static void copyEvictableEntry(ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
        {
            MapMakerInternalMap.connectEvictables(referenceentry.getPreviousEvictable(), referenceentry1);
            MapMakerInternalMap.connectEvictables(referenceentry1, referenceentry.getNextEvictable());
            MapMakerInternalMap.nullifyEvictable(referenceentry);
        }

        static void copyExpirableEntry(ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
        {
            referenceentry1.setExpirationTime(referenceentry.getExpirationTime());
            MapMakerInternalMap.connectExpirables(referenceentry.getPreviousExpirable(), referenceentry1);
            MapMakerInternalMap.connectExpirables(referenceentry1, referenceentry.getNextExpirable());
            MapMakerInternalMap.nullifyExpirable(referenceentry);
        }

        static EntryFactory getFactory(Strength strength, boolean flag, boolean flag1)
        {
            byte byte0 = 0;
            boolean flag2;
            if (flag)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag1)
            {
                byte0 = 2;
            }
            return factories[strength.ordinal()][flag2 | byte0];
        }

        public static EntryFactory valueOf(String s)
        {
            return (EntryFactory)Enum.valueOf(com/google/common/collect/MapMakerInternalMap$EntryFactory, s);
        }

        public static EntryFactory[] values()
        {
            return (EntryFactory[])$VALUES.clone();
        }

        ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
        {
            return newEntry(segment, referenceentry.getKey(), referenceentry.getHash(), referenceentry1);
        }

        abstract ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceentry);

        static 
        {
            STRONG = new EntryFactory("STRONG", 0) {

                final ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceentry)
                {
                    return new StrongEntry(obj, i, referenceentry);
                }

            };
            STRONG_EXPIRABLE = new EntryFactory("STRONG_EXPIRABLE", 1) {

                final ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
                {
                    segment = super.copyEntry(segment, referenceentry, referenceentry1);
                    copyExpirableEntry(referenceentry, segment);
                    return segment;
                }

                final ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceentry)
                {
                    return new StrongExpirableEntry(obj, i, referenceentry);
                }

            };
            STRONG_EVICTABLE = new EntryFactory("STRONG_EVICTABLE", 2) {

                final ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
                {
                    segment = super.copyEntry(segment, referenceentry, referenceentry1);
                    copyEvictableEntry(referenceentry, segment);
                    return segment;
                }

                final ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceentry)
                {
                    return new StrongEvictableEntry(obj, i, referenceentry);
                }

            };
            STRONG_EXPIRABLE_EVICTABLE = new EntryFactory("STRONG_EXPIRABLE_EVICTABLE", 3) {

                final ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
                {
                    segment = super.copyEntry(segment, referenceentry, referenceentry1);
                    copyExpirableEntry(referenceentry, segment);
                    copyEvictableEntry(referenceentry, segment);
                    return segment;
                }

                final ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceentry)
                {
                    return new StrongExpirableEvictableEntry(obj, i, referenceentry);
                }

            };
            WEAK = new EntryFactory("WEAK", 4) {

                final ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceentry)
                {
                    return new WeakEntry(segment.keyReferenceQueue, obj, i, referenceentry);
                }

            };
            WEAK_EXPIRABLE = new EntryFactory("WEAK_EXPIRABLE", 5) {

                final ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
                {
                    segment = super.copyEntry(segment, referenceentry, referenceentry1);
                    copyExpirableEntry(referenceentry, segment);
                    return segment;
                }

                final ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceentry)
                {
                    return new WeakExpirableEntry(segment.keyReferenceQueue, obj, i, referenceentry);
                }

            };
            WEAK_EVICTABLE = new EntryFactory("WEAK_EVICTABLE", 6) {

                final ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
                {
                    segment = super.copyEntry(segment, referenceentry, referenceentry1);
                    copyEvictableEntry(referenceentry, segment);
                    return segment;
                }

                final ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceentry)
                {
                    return new WeakEvictableEntry(segment.keyReferenceQueue, obj, i, referenceentry);
                }

            };
            WEAK_EXPIRABLE_EVICTABLE = new EntryFactory("WEAK_EXPIRABLE_EVICTABLE", 7) {

                final ReferenceEntry copyEntry(Segment segment, ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
                {
                    segment = super.copyEntry(segment, referenceentry, referenceentry1);
                    copyExpirableEntry(referenceentry, segment);
                    copyEvictableEntry(referenceentry, segment);
                    return segment;
                }

                final ReferenceEntry newEntry(Segment segment, Object obj, int i, ReferenceEntry referenceentry)
                {
                    return new WeakExpirableEvictableEntry(segment.keyReferenceQueue, obj, i, referenceentry);
                }

            };
            $VALUES = (new EntryFactory[] {
                STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE, WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE
            });
            EntryFactory entryfactory = STRONG;
            EntryFactory entryfactory1 = STRONG_EXPIRABLE;
            EntryFactory entryfactory2 = STRONG_EVICTABLE;
            EntryFactory entryfactory3 = STRONG_EXPIRABLE_EVICTABLE;
            EntryFactory entryfactory4 = WEAK;
            EntryFactory entryfactory5 = WEAK_EXPIRABLE;
            EntryFactory entryfactory6 = WEAK_EVICTABLE;
            EntryFactory entryfactory7 = WEAK_EXPIRABLE_EVICTABLE;
            factories = (new EntryFactory[][] {
                new EntryFactory[] {
                    entryfactory, entryfactory1, entryfactory2, entryfactory3
                }, new EntryFactory[0], new EntryFactory[] {
                    entryfactory4, entryfactory5, entryfactory6, entryfactory7
                }
            });
        }

        private EntryFactory(String s, int i)
        {
            super(s, i);
        }

    }

    final class EntryIterator extends HashIterator
    {

        final MapMakerInternalMap this$0;

        private java.util.Map.Entry next()
        {
            return nextEntry();
        }

        public final volatile Object next()
        {
            return next();
        }

        EntryIterator()
        {
            this$0 = MapMakerInternalMap.this;
            super();
        }
    }

    final class EntrySet extends AbstractSet
    {

        final MapMakerInternalMap this$0;

        public final void clear()
        {
            MapMakerInternalMap.this.clear();
        }

        public final boolean contains(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                obj = (java.util.Map.Entry)obj;
                Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
                if (obj1 != null)
                {
                    obj1 = get(obj1);
                    if (obj1 != null && valueEquivalence.equivalent(((java.util.Map.Entry) (obj)).getValue(), obj1))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        public final boolean isEmpty()
        {
            return MapMakerInternalMap.this.isEmpty();
        }

        public final Iterator iterator()
        {
            return new EntryIterator();
        }

        public final boolean remove(Object obj)
        {
            if (obj instanceof java.util.Map.Entry)
            {
                obj = (java.util.Map.Entry)obj;
                Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
                if (obj1 != null && MapMakerInternalMap.this.remove(obj1, ((java.util.Map.Entry) (obj)).getValue()))
                {
                    return true;
                }
            }
            return false;
        }

        public final int size()
        {
            return MapMakerInternalMap.this.size();
        }

        EntrySet()
        {
            this$0 = MapMakerInternalMap.this;
            super();
        }
    }

    static final class EvictionQueue extends AbstractQueue
    {

        final ReferenceEntry head = new _cls1();

        private boolean offer(ReferenceEntry referenceentry)
        {
            MapMakerInternalMap.connectEvictables(referenceentry.getPreviousEvictable(), referenceentry.getNextEvictable());
            MapMakerInternalMap.connectEvictables(head.getPreviousEvictable(), referenceentry);
            MapMakerInternalMap.connectEvictables(referenceentry, head);
            return true;
        }

        private ReferenceEntry peek()
        {
            ReferenceEntry referenceentry1 = head.getNextEvictable();
            ReferenceEntry referenceentry = referenceentry1;
            if (referenceentry1 == head)
            {
                referenceentry = null;
            }
            return referenceentry;
        }

        private ReferenceEntry poll()
        {
            ReferenceEntry referenceentry = head.getNextEvictable();
            if (referenceentry == head)
            {
                return null;
            } else
            {
                remove(referenceentry);
                return referenceentry;
            }
        }

        public final void clear()
        {
            ReferenceEntry referenceentry1;
            for (ReferenceEntry referenceentry = head.getNextEvictable(); referenceentry != head; referenceentry = referenceentry1)
            {
                referenceentry1 = referenceentry.getNextEvictable();
                MapMakerInternalMap.nullifyEvictable(referenceentry);
            }

            head.setNextEvictable(head);
            head.setPreviousEvictable(head);
        }

        public final boolean contains(Object obj)
        {
            return ((ReferenceEntry)obj).getNextEvictable() != NullEntry.INSTANCE;
        }

        public final boolean isEmpty()
        {
            return head.getNextEvictable() == head;
        }

        public final Iterator iterator()
        {
            return new AbstractSequentialIterator(peek()) {

                final EvictionQueue this$0;

                private ReferenceEntry computeNext(ReferenceEntry referenceentry)
                {
                    ReferenceEntry referenceentry1 = referenceentry.getNextEvictable();
                    referenceentry = referenceentry1;
                    if (referenceentry1 == head)
                    {
                        referenceentry = null;
                    }
                    return referenceentry;
                }

                protected final volatile Object computeNext(Object obj)
                {
                    return computeNext((ReferenceEntry)obj);
                }

            
            {
                this$0 = EvictionQueue.this;
                super(referenceentry);
            }
            };
        }

        public final volatile boolean offer(Object obj)
        {
            return offer((ReferenceEntry)obj);
        }

        public final volatile Object peek()
        {
            return peek();
        }

        public final volatile Object poll()
        {
            return poll();
        }

        public final boolean remove(Object obj)
        {
            obj = (ReferenceEntry)obj;
            ReferenceEntry referenceentry = ((ReferenceEntry) (obj)).getPreviousEvictable();
            ReferenceEntry referenceentry1 = ((ReferenceEntry) (obj)).getNextEvictable();
            MapMakerInternalMap.connectEvictables(referenceentry, referenceentry1);
            MapMakerInternalMap.nullifyEvictable(((ReferenceEntry) (obj)));
            return referenceentry1 != NullEntry.INSTANCE;
        }

        public final int size()
        {
            int i = 0;
            for (ReferenceEntry referenceentry = head.getNextEvictable(); referenceentry != head; referenceentry = referenceentry.getNextEvictable())
            {
                i++;
            }

            return i;
        }

        EvictionQueue()
        {
        }
    }

    static final class ExpirationQueue extends AbstractQueue
    {

        final ReferenceEntry head = new _cls1();

        private boolean offer(ReferenceEntry referenceentry)
        {
            MapMakerInternalMap.connectExpirables(referenceentry.getPreviousExpirable(), referenceentry.getNextExpirable());
            MapMakerInternalMap.connectExpirables(head.getPreviousExpirable(), referenceentry);
            MapMakerInternalMap.connectExpirables(referenceentry, head);
            return true;
        }

        private ReferenceEntry peek()
        {
            ReferenceEntry referenceentry1 = head.getNextExpirable();
            ReferenceEntry referenceentry = referenceentry1;
            if (referenceentry1 == head)
            {
                referenceentry = null;
            }
            return referenceentry;
        }

        private ReferenceEntry poll()
        {
            ReferenceEntry referenceentry = head.getNextExpirable();
            if (referenceentry == head)
            {
                return null;
            } else
            {
                remove(referenceentry);
                return referenceentry;
            }
        }

        public final void clear()
        {
            ReferenceEntry referenceentry1;
            for (ReferenceEntry referenceentry = head.getNextExpirable(); referenceentry != head; referenceentry = referenceentry1)
            {
                referenceentry1 = referenceentry.getNextExpirable();
                MapMakerInternalMap.nullifyExpirable(referenceentry);
            }

            head.setNextExpirable(head);
            head.setPreviousExpirable(head);
        }

        public final boolean contains(Object obj)
        {
            return ((ReferenceEntry)obj).getNextExpirable() != NullEntry.INSTANCE;
        }

        public final boolean isEmpty()
        {
            return head.getNextExpirable() == head;
        }

        public final Iterator iterator()
        {
            return new AbstractSequentialIterator(peek()) {

                final ExpirationQueue this$0;

                private ReferenceEntry computeNext(ReferenceEntry referenceentry)
                {
                    ReferenceEntry referenceentry1 = referenceentry.getNextExpirable();
                    referenceentry = referenceentry1;
                    if (referenceentry1 == head)
                    {
                        referenceentry = null;
                    }
                    return referenceentry;
                }

                protected final volatile Object computeNext(Object obj)
                {
                    return computeNext((ReferenceEntry)obj);
                }

            
            {
                this$0 = ExpirationQueue.this;
                super(referenceentry);
            }
            };
        }

        public final volatile boolean offer(Object obj)
        {
            return offer((ReferenceEntry)obj);
        }

        public final volatile Object peek()
        {
            return peek();
        }

        public final volatile Object poll()
        {
            return poll();
        }

        public final boolean remove(Object obj)
        {
            obj = (ReferenceEntry)obj;
            ReferenceEntry referenceentry = ((ReferenceEntry) (obj)).getPreviousExpirable();
            ReferenceEntry referenceentry1 = ((ReferenceEntry) (obj)).getNextExpirable();
            MapMakerInternalMap.connectExpirables(referenceentry, referenceentry1);
            MapMakerInternalMap.nullifyExpirable(((ReferenceEntry) (obj)));
            return referenceentry1 != NullEntry.INSTANCE;
        }

        public final int size()
        {
            int i = 0;
            for (ReferenceEntry referenceentry = head.getNextExpirable(); referenceentry != head; referenceentry = referenceentry.getNextExpirable())
            {
                i++;
            }

            return i;
        }

        ExpirationQueue()
        {
        }
    }

    abstract class HashIterator
        implements Iterator
    {

        Segment currentSegment;
        AtomicReferenceArray currentTable;
        WriteThroughEntry lastReturned;
        ReferenceEntry nextEntry;
        WriteThroughEntry nextExternal;
        int nextSegmentIndex;
        int nextTableIndex;
        final MapMakerInternalMap this$0;

        private void advance()
        {
            nextExternal = null;
            break MISSING_BLOCK_LABEL_5;
            if (!nextInChain() && !nextInTable())
            {
                while (nextSegmentIndex >= 0) 
                {
                    Segment asegment[] = segments;
                    int i = nextSegmentIndex;
                    nextSegmentIndex = i - 1;
                    currentSegment = asegment[i];
                    if (currentSegment.count != 0)
                    {
                        currentTable = currentSegment.table;
                        nextTableIndex = currentTable.length() - 1;
                        if (nextInTable())
                        {
                            return;
                        }
                    }
                }
            }
            return;
        }

        private boolean advanceTo(ReferenceEntry referenceentry)
        {
            Object obj;
            obj = referenceentry.getKey();
            referenceentry = ((ReferenceEntry) (getLiveValue(referenceentry)));
            if (referenceentry == null)
            {
                break MISSING_BLOCK_LABEL_46;
            }
            nextExternal = new WriteThroughEntry(obj, referenceentry);
            currentSegment.postReadCleanup();
            return true;
            currentSegment.postReadCleanup();
            return false;
            referenceentry;
            currentSegment.postReadCleanup();
            throw referenceentry;
        }

        private boolean nextInChain()
        {
            if (nextEntry != null)
            {
                for (nextEntry = nextEntry.getNext(); nextEntry != null; nextEntry = nextEntry.getNext())
                {
                    if (advanceTo(nextEntry))
                    {
                        return true;
                    }
                }

            }
            return false;
        }

        private boolean nextInTable()
        {
            while (nextTableIndex >= 0) 
            {
                Object obj = currentTable;
                int i = nextTableIndex;
                nextTableIndex = i - 1;
                obj = (ReferenceEntry)((AtomicReferenceArray) (obj)).get(i);
                nextEntry = ((ReferenceEntry) (obj));
                if (obj != null && (advanceTo(nextEntry) || nextInChain()))
                {
                    return true;
                }
            }
            return false;
        }

        public boolean hasNext()
        {
            return nextExternal != null;
        }

        final WriteThroughEntry nextEntry()
        {
            if (nextExternal == null)
            {
                throw new NoSuchElementException();
            } else
            {
                lastReturned = nextExternal;
                advance();
                return lastReturned;
            }
        }

        public void remove()
        {
            boolean flag;
            if (lastReturned != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            CollectPreconditions.checkRemove(flag);
            MapMakerInternalMap.this.remove(lastReturned.getKey());
            lastReturned = null;
        }

        HashIterator()
        {
            this$0 = MapMakerInternalMap.this;
            super();
            nextSegmentIndex = segments.length - 1;
            nextTableIndex = -1;
            advance();
        }
    }

    final class KeyIterator extends HashIterator
    {

        final MapMakerInternalMap this$0;

        public final Object next()
        {
            return nextEntry().getKey();
        }

        KeyIterator()
        {
            this$0 = MapMakerInternalMap.this;
            super();
        }
    }

    final class KeySet extends AbstractSet
    {

        final MapMakerInternalMap this$0;

        public final void clear()
        {
            MapMakerInternalMap.this.clear();
        }

        public final boolean contains(Object obj)
        {
            return containsKey(obj);
        }

        public final boolean isEmpty()
        {
            return MapMakerInternalMap.this.isEmpty();
        }

        public final Iterator iterator()
        {
            return new KeyIterator();
        }

        public final boolean remove(Object obj)
        {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        public final int size()
        {
            return MapMakerInternalMap.this.size();
        }

        KeySet()
        {
            this$0 = MapMakerInternalMap.this;
            super();
        }
    }

    static final class NullEntry extends Enum
        implements ReferenceEntry
    {

        private static final NullEntry $VALUES[];
        public static final NullEntry INSTANCE;

        public static NullEntry valueOf(String s)
        {
            return (NullEntry)Enum.valueOf(com/google/common/collect/MapMakerInternalMap$NullEntry, s);
        }

        public static NullEntry[] values()
        {
            return (NullEntry[])$VALUES.clone();
        }

        public final long getExpirationTime()
        {
            return 0L;
        }

        public final int getHash()
        {
            return 0;
        }

        public final Object getKey()
        {
            return null;
        }

        public final ReferenceEntry getNext()
        {
            return null;
        }

        public final ReferenceEntry getNextEvictable()
        {
            return this;
        }

        public final ReferenceEntry getNextExpirable()
        {
            return this;
        }

        public final ReferenceEntry getPreviousEvictable()
        {
            return this;
        }

        public final ReferenceEntry getPreviousExpirable()
        {
            return this;
        }

        public final ValueReference getValueReference()
        {
            return null;
        }

        public final void setExpirationTime(long l)
        {
        }

        public final void setNextEvictable(ReferenceEntry referenceentry)
        {
        }

        public final void setNextExpirable(ReferenceEntry referenceentry)
        {
        }

        public final void setPreviousEvictable(ReferenceEntry referenceentry)
        {
        }

        public final void setPreviousExpirable(ReferenceEntry referenceentry)
        {
        }

        public final void setValueReference(ValueReference valuereference)
        {
        }

        static 
        {
            INSTANCE = new NullEntry("INSTANCE", 0);
            $VALUES = (new NullEntry[] {
                INSTANCE
            });
        }

        private NullEntry(String s, int i)
        {
            super(s, i);
        }
    }

    static interface ReferenceEntry
    {

        public abstract long getExpirationTime();

        public abstract int getHash();

        public abstract Object getKey();

        public abstract ReferenceEntry getNext();

        public abstract ReferenceEntry getNextEvictable();

        public abstract ReferenceEntry getNextExpirable();

        public abstract ReferenceEntry getPreviousEvictable();

        public abstract ReferenceEntry getPreviousExpirable();

        public abstract ValueReference getValueReference();

        public abstract void setExpirationTime(long l);

        public abstract void setNextEvictable(ReferenceEntry referenceentry);

        public abstract void setNextExpirable(ReferenceEntry referenceentry);

        public abstract void setPreviousEvictable(ReferenceEntry referenceentry);

        public abstract void setPreviousExpirable(ReferenceEntry referenceentry);

        public abstract void setValueReference(ValueReference valuereference);
    }

    static final class Segment extends ReentrantLock
    {

        volatile int count;
        final Queue evictionQueue;
        final Queue expirationQueue;
        final ReferenceQueue keyReferenceQueue;
        final MapMakerInternalMap map;
        final int maxSegmentSize;
        int modCount;
        final AtomicInteger readCount = new AtomicInteger();
        final Queue recencyQueue;
        volatile AtomicReferenceArray table;
        int threshold;
        final ReferenceQueue valueReferenceQueue;

        private void clearKeyReferenceQueue()
        {
            while (keyReferenceQueue.poll() != null) ;
        }

        private void clearReferenceQueues()
        {
            if (map.usesKeyReferences())
            {
                clearKeyReferenceQueue();
            }
            if (map.usesValueReferences())
            {
                clearValueReferenceQueue();
            }
        }

        private void clearValueReferenceQueue()
        {
            while (valueReferenceQueue.poll() != null) ;
        }

        private ReferenceEntry copyEntry(ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
        {
            if (referenceentry.getKey() != null)
            {
                ValueReference valuereference = referenceentry.getValueReference();
                Object obj = valuereference.get();
                if (obj != null || valuereference.isComputingReference())
                {
                    referenceentry = map.entryFactory.copyEntry(this, referenceentry, referenceentry1);
                    referenceentry.setValueReference(valuereference.copyFor(valueReferenceQueue, obj, referenceentry));
                    return referenceentry;
                }
            }
            return null;
        }

        private void drainKeyReferenceQueue()
        {
            int i = 0;
            int j;
            do
            {
                Object obj = keyReferenceQueue.poll();
                if (obj == null)
                {
                    break;
                }
                obj = (ReferenceEntry)obj;
                map.reclaimKey(((ReferenceEntry) (obj)));
                j = i + 1;
                i = j;
            } while (j != 16);
        }

        private void drainRecencyQueue()
        {
            do
            {
                ReferenceEntry referenceentry = (ReferenceEntry)recencyQueue.poll();
                if (referenceentry == null)
                {
                    break;
                }
                if (evictionQueue.contains(referenceentry))
                {
                    evictionQueue.add(referenceentry);
                }
                if (map.expiresAfterAccess() && expirationQueue.contains(referenceentry))
                {
                    expirationQueue.add(referenceentry);
                }
            } while (true);
        }

        private void drainReferenceQueues()
        {
            if (map.usesKeyReferences())
            {
                drainKeyReferenceQueue();
            }
            if (map.usesValueReferences())
            {
                drainValueReferenceQueue();
            }
        }

        private void drainValueReferenceQueue()
        {
            int i = 0;
            int j;
            do
            {
                Object obj = valueReferenceQueue.poll();
                if (obj == null)
                {
                    break;
                }
                obj = (ValueReference)obj;
                map.reclaimValue(((ValueReference) (obj)));
                j = i + 1;
                i = j;
            } while (j != 16);
        }

        private void enqueueNotification(ReferenceEntry referenceentry, MapMaker.RemovalCause removalcause)
        {
            enqueueNotification(referenceentry.getKey(), referenceentry.getHash(), referenceentry.getValueReference().get(), removalcause);
        }

        private void enqueueNotification(Object obj, int i, Object obj1, MapMaker.RemovalCause removalcause)
        {
            if (map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE)
            {
                obj = new MapMaker.RemovalNotification(obj, obj1, removalcause);
                map.removalNotificationQueue.offer(obj);
            }
        }

        private boolean evictEntries()
        {
            if (map.evictsBySize() && count >= maxSegmentSize)
            {
                drainRecencyQueue();
                ReferenceEntry referenceentry = (ReferenceEntry)evictionQueue.remove();
                if (!removeEntry(referenceentry, referenceentry.getHash(), MapMaker.RemovalCause.SIZE))
                {
                    throw new AssertionError();
                } else
                {
                    return true;
                }
            } else
            {
                return false;
            }
        }

        private void expand()
        {
            AtomicReferenceArray atomicreferencearray;
            AtomicReferenceArray atomicreferencearray1;
            int i;
            int j;
            int k1;
            int l1;
            atomicreferencearray = table;
            k1 = atomicreferencearray.length();
            if (k1 >= 0x40000000)
            {
                return;
            }
            i = count;
            atomicreferencearray1 = newEntryArray(k1 << 1);
            threshold = (atomicreferencearray1.length() * 3) / 4;
            l1 = atomicreferencearray1.length() - 1;
            j = 0;
_L2:
            ReferenceEntry referenceentry;
            ReferenceEntry referenceentry1;
            int k;
            if (j >= k1)
            {
                break MISSING_BLOCK_LABEL_264;
            }
            referenceentry1 = (ReferenceEntry)atomicreferencearray.get(j);
            k = i;
            if (referenceentry1 != null)
            {
                referenceentry = referenceentry1.getNext();
                k = referenceentry1.getHash() & l1;
                if (referenceentry != null)
                {
                    break; /* Loop/switch isn't completed */
                }
                atomicreferencearray1.set(k, referenceentry1);
                k = i;
            }
_L4:
            j++;
            i = k;
            if (true) goto _L2; else goto _L1
_L1:
            ReferenceEntry referenceentry3;
            referenceentry3 = referenceentry1;
            while (referenceentry != null) 
            {
                int j1 = referenceentry.getHash() & l1;
                int i1 = k;
                if (j1 != k)
                {
                    i1 = j1;
                    referenceentry3 = referenceentry;
                }
                referenceentry = referenceentry.getNext();
                k = i1;
            }
            atomicreferencearray1.set(k, referenceentry3);
            referenceentry = referenceentry1;
_L5:
            k = i;
            if (referenceentry == referenceentry3) goto _L4; else goto _L3
_L3:
            int l = referenceentry.getHash() & l1;
            ReferenceEntry referenceentry2 = copyEntry(referenceentry, (ReferenceEntry)atomicreferencearray1.get(l));
            if (referenceentry2 != null)
            {
                atomicreferencearray1.set(l, referenceentry2);
            } else
            {
                removeCollectedEntry(referenceentry);
                i--;
            }
            referenceentry = referenceentry.getNext();
              goto _L5
              goto _L4
            table = atomicreferencearray1;
            count = i;
            return;
        }

        private void expireEntries()
        {
            drainRecencyQueue();
            if (!expirationQueue.isEmpty()) goto _L2; else goto _L1
_L1:
            return;
_L2:
            long l = map.ticker.read();
_L5:
            ReferenceEntry referenceentry = (ReferenceEntry)expirationQueue.peek();
            if (referenceentry == null) goto _L1; else goto _L3
_L3:
            MapMakerInternalMap mapmakerinternalmap = map;
            if (!MapMakerInternalMap.isExpired(referenceentry, l)) goto _L1; else goto _L4
_L4:
            if (!removeEntry(referenceentry, referenceentry.getHash(), MapMaker.RemovalCause.EXPIRED))
            {
                throw new AssertionError();
            }
              goto _L5
        }

        private ReferenceEntry getEntry(Object obj, int i)
        {
            ReferenceEntry referenceentry;
            if (count == 0)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            referenceentry = getFirst(i);
_L2:
            Object obj1;
            if (referenceentry == null)
            {
                break MISSING_BLOCK_LABEL_72;
            }
            if (referenceentry.getHash() == i)
            {
                obj1 = referenceentry.getKey();
                if (obj1 != null)
                {
                    break; /* Loop/switch isn't completed */
                }
                tryDrainReferenceQueues();
            }
_L4:
            referenceentry = referenceentry.getNext();
            if (true) goto _L2; else goto _L1
_L1:
            if (!map.keyEquivalence.equivalent(obj, obj1)) goto _L4; else goto _L3
_L3:
            return referenceentry;
            return null;
        }

        private ReferenceEntry getFirst(int i)
        {
            AtomicReferenceArray atomicreferencearray = table;
            return (ReferenceEntry)atomicreferencearray.get(atomicreferencearray.length() - 1 & i);
        }

        private ReferenceEntry getLiveEntry(Object obj, int i)
        {
            ReferenceEntry referenceentry = getEntry(obj, i);
            if (referenceentry == null)
            {
                obj = null;
            } else
            {
                obj = referenceentry;
                if (map.expires())
                {
                    obj = referenceentry;
                    if (map.isExpired(referenceentry))
                    {
                        tryExpireEntries();
                        return null;
                    }
                }
            }
            return ((ReferenceEntry) (obj));
        }

        private void initTable(AtomicReferenceArray atomicreferencearray)
        {
            threshold = (atomicreferencearray.length() * 3) / 4;
            if (threshold == maxSegmentSize)
            {
                threshold = threshold + 1;
            }
            table = atomicreferencearray;
        }

        private static boolean isCollected(ValueReference valuereference)
        {
            while (valuereference.isComputingReference() || valuereference.get() != null) 
            {
                return false;
            }
            return true;
        }

        private ReferenceEntry newEntry(Object obj, int i, ReferenceEntry referenceentry)
        {
            return map.entryFactory.newEntry(this, obj, i, referenceentry);
        }

        private static AtomicReferenceArray newEntryArray(int i)
        {
            return new AtomicReferenceArray(i);
        }

        private void postWriteCleanup()
        {
            runUnlockedCleanup();
        }

        private void preWriteCleanup()
        {
            runLockedCleanup();
        }

        private void recordExpirationTime(ReferenceEntry referenceentry, long l)
        {
            referenceentry.setExpirationTime(map.ticker.read() + l);
        }

        private void recordLockedRead(ReferenceEntry referenceentry)
        {
            evictionQueue.add(referenceentry);
            if (map.expiresAfterAccess())
            {
                recordExpirationTime(referenceentry, map.expireAfterAccessNanos);
                expirationQueue.add(referenceentry);
            }
        }

        private void recordRead(ReferenceEntry referenceentry)
        {
            if (map.expiresAfterAccess())
            {
                recordExpirationTime(referenceentry, map.expireAfterAccessNanos);
            }
            recencyQueue.add(referenceentry);
        }

        private void recordWrite(ReferenceEntry referenceentry)
        {
            drainRecencyQueue();
            evictionQueue.add(referenceentry);
            if (map.expires())
            {
                long l;
                if (map.expiresAfterAccess())
                {
                    l = map.expireAfterAccessNanos;
                } else
                {
                    l = map.expireAfterWriteNanos;
                }
                recordExpirationTime(referenceentry, l);
                expirationQueue.add(referenceentry);
            }
        }

        private void removeCollectedEntry(ReferenceEntry referenceentry)
        {
            enqueueNotification(referenceentry, MapMaker.RemovalCause.COLLECTED);
            evictionQueue.remove(referenceentry);
            expirationQueue.remove(referenceentry);
        }

        private boolean removeEntry(ReferenceEntry referenceentry, int i, MapMaker.RemovalCause removalcause)
        {
            int j = count;
            AtomicReferenceArray atomicreferencearray = table;
            j = i & atomicreferencearray.length() - 1;
            ReferenceEntry referenceentry2 = (ReferenceEntry)atomicreferencearray.get(j);
            for (ReferenceEntry referenceentry1 = referenceentry2; referenceentry1 != null; referenceentry1 = referenceentry1.getNext())
            {
                if (referenceentry1 == referenceentry)
                {
                    modCount = modCount + 1;
                    enqueueNotification(referenceentry1.getKey(), i, referenceentry1.getValueReference().get(), removalcause);
                    referenceentry = removeFromChain(referenceentry2, referenceentry1);
                    i = count;
                    atomicreferencearray.set(j, referenceentry);
                    count = i - 1;
                    return true;
                }
            }

            return false;
        }

        private ReferenceEntry removeFromChain(ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
        {
            evictionQueue.remove(referenceentry1);
            expirationQueue.remove(referenceentry1);
            int i = count;
            ReferenceEntry referenceentry2 = referenceentry1.getNext();
            while (referenceentry != referenceentry1) 
            {
                ReferenceEntry referenceentry3 = copyEntry(referenceentry, referenceentry2);
                if (referenceentry3 != null)
                {
                    referenceentry2 = referenceentry3;
                } else
                {
                    removeCollectedEntry(referenceentry);
                    i--;
                }
                referenceentry = referenceentry.getNext();
            }
            count = i;
            return referenceentry2;
        }

        private void runCleanup()
        {
            runLockedCleanup();
            runUnlockedCleanup();
        }

        private void runLockedCleanup()
        {
            if (!tryLock())
            {
                break MISSING_BLOCK_LABEL_27;
            }
            drainReferenceQueues();
            expireEntries();
            readCount.set(0);
            unlock();
            return;
            Exception exception;
            exception;
            unlock();
            throw exception;
        }

        private void runUnlockedCleanup()
        {
            if (!isHeldByCurrentThread())
            {
                map.processPendingNotifications();
            }
        }

        private void setValue(ReferenceEntry referenceentry, Object obj)
        {
            referenceentry.setValueReference(map.valueStrength.referenceValue(this, referenceentry, obj));
            recordWrite(referenceentry);
        }

        private void tryDrainReferenceQueues()
        {
            if (!tryLock())
            {
                break MISSING_BLOCK_LABEL_15;
            }
            drainReferenceQueues();
            unlock();
            return;
            Exception exception;
            exception;
            unlock();
            throw exception;
        }

        private void tryExpireEntries()
        {
            if (!tryLock())
            {
                break MISSING_BLOCK_LABEL_15;
            }
            expireEntries();
            unlock();
            return;
            Exception exception;
            exception;
            unlock();
            throw exception;
        }

        final void clear()
        {
            if (count == 0) goto _L2; else goto _L1
_L1:
            lock();
            AtomicReferenceArray atomicreferencearray;
            atomicreferencearray = table;
            if (map.removalNotificationQueue == MapMakerInternalMap.DISCARDING_QUEUE)
            {
                break MISSING_BLOCK_LABEL_177;
            }
            int i = 0;
_L7:
            ReferenceEntry referenceentry;
            if (i >= atomicreferencearray.length())
            {
                break MISSING_BLOCK_LABEL_177;
            }
            referenceentry = (ReferenceEntry)atomicreferencearray.get(i);
_L4:
            if (referenceentry == null)
            {
                break; /* Loop/switch isn't completed */
            }
            if (!referenceentry.getValueReference().isComputingReference())
            {
                enqueueNotification(referenceentry, MapMaker.RemovalCause.EXPLICIT);
            }
            referenceentry = referenceentry.getNext();
            if (true) goto _L4; else goto _L3
_L5:
            Exception exception;
            for (; i >= atomicreferencearray.length(); i = 0)
            {
                break MISSING_BLOCK_LABEL_105;
            }

            atomicreferencearray.set(i, null);
            i++;
              goto _L5
            clearReferenceQueues();
            evictionQueue.clear();
            expirationQueue.clear();
            readCount.set(0);
            modCount = modCount + 1;
            count = 0;
            unlock();
            postWriteCleanup();
_L2:
            return;
            exception;
            unlock();
            postWriteCleanup();
            throw exception;
_L3:
            i++;
            if (true) goto _L7; else goto _L6
_L6:
        }

        final boolean containsKey(Object obj, int i)
        {
            boolean flag = false;
            if (count == 0)
            {
                break MISSING_BLOCK_LABEL_50;
            }
            obj = getLiveEntry(obj, i);
            if (obj == null)
            {
                postReadCleanup();
                return false;
            }
            obj = ((ReferenceEntry) (obj)).getValueReference().get();
            if (obj != null)
            {
                flag = true;
            }
            postReadCleanup();
            return flag;
            postReadCleanup();
            return false;
            obj;
            postReadCleanup();
            throw obj;
        }

        final Object get(Object obj, int i)
        {
            obj = getLiveEntry(obj, i);
            if (obj == null)
            {
                postReadCleanup();
                return null;
            }
            Object obj1 = ((ReferenceEntry) (obj)).getValueReference().get();
            if (obj1 == null) goto _L2; else goto _L1
_L1:
            recordRead(((ReferenceEntry) (obj)));
_L4:
            postReadCleanup();
            return obj1;
_L2:
            tryDrainReferenceQueues();
            if (true) goto _L4; else goto _L3
_L3:
            obj;
            postReadCleanup();
            throw obj;
        }

        final Object getLiveValue(ReferenceEntry referenceentry)
        {
            Object obj;
            if (referenceentry.getKey() == null)
            {
                tryDrainReferenceQueues();
                obj = null;
            } else
            {
                Object obj1 = referenceentry.getValueReference().get();
                if (obj1 == null)
                {
                    tryDrainReferenceQueues();
                    return null;
                }
                obj = obj1;
                if (map.expires())
                {
                    obj = obj1;
                    if (map.isExpired(referenceentry))
                    {
                        tryExpireEntries();
                        return null;
                    }
                }
            }
            return obj;
        }

        final void postReadCleanup()
        {
            if ((readCount.incrementAndGet() & 0x3f) == 0)
            {
                runCleanup();
            }
        }

        final Object put(Object obj, int i, Object obj1, boolean flag)
        {
            lock();
            int k;
            preWriteCleanup();
            k = count + 1;
            int j = k;
            Object obj3;
            Object obj4;
            if (k > threshold)
            {
                expand();
                j = count + 1;
            }
            obj4 = table;
            k = i & ((AtomicReferenceArray) (obj4)).length() - 1;
            obj3 = (ReferenceEntry)((AtomicReferenceArray) (obj4)).get(k);
            Object obj2 = obj3;
_L5:
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_294;
            }
            Object obj5 = ((ReferenceEntry) (obj2)).getKey();
            if (((ReferenceEntry) (obj2)).getHash() != i || obj5 == null)
            {
                break MISSING_BLOCK_LABEL_282;
            }
            if (!map.keyEquivalence.equivalent(obj, obj5))
            {
                break MISSING_BLOCK_LABEL_282;
            }
            obj3 = ((ReferenceEntry) (obj2)).getValueReference();
            obj4 = ((ValueReference) (obj3)).get();
            if (obj4 != null)
            {
                break MISSING_BLOCK_LABEL_221;
            }
            modCount = modCount + 1;
            setValue(((ReferenceEntry) (obj2)), obj1);
            if (((ValueReference) (obj3)).isComputingReference()) goto _L2; else goto _L1
_L1:
            enqueueNotification(obj, i, obj4, MapMaker.RemovalCause.COLLECTED);
            j = count;
_L4:
            count = j;
            unlock();
            postWriteCleanup();
            return null;
_L2:
            if (!evictEntries()) goto _L4; else goto _L3
_L3:
            j = count + 1;
              goto _L4
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_243;
            }
            recordLockedRead(((ReferenceEntry) (obj2)));
            unlock();
            postWriteCleanup();
            return obj4;
            modCount = modCount + 1;
            enqueueNotification(obj, i, obj4, MapMaker.RemovalCause.REPLACED);
            setValue(((ReferenceEntry) (obj2)), obj1);
            unlock();
            postWriteCleanup();
            return obj4;
            obj2 = ((ReferenceEntry) (obj2)).getNext();
              goto _L5
            modCount = modCount + 1;
            obj = newEntry(obj, i, ((ReferenceEntry) (obj3)));
            setValue(((ReferenceEntry) (obj)), obj1);
            ((AtomicReferenceArray) (obj4)).set(k, obj);
            if (evictEntries())
            {
                j = count + 1;
            }
            count = j;
            unlock();
            postWriteCleanup();
            return null;
            obj;
            unlock();
            postWriteCleanup();
            throw obj;
        }

        final boolean reclaimKey(ReferenceEntry referenceentry, int i)
        {
            lock();
            ReferenceEntry referenceentry2;
            AtomicReferenceArray atomicreferencearray;
            int j;
            j = count;
            atomicreferencearray = table;
            j = i & atomicreferencearray.length() - 1;
            referenceentry2 = (ReferenceEntry)atomicreferencearray.get(j);
            ReferenceEntry referenceentry1 = referenceentry2;
_L2:
            if (referenceentry1 == null)
            {
                break; /* Loop/switch isn't completed */
            }
            if (referenceentry1 != referenceentry)
            {
                break MISSING_BLOCK_LABEL_124;
            }
            modCount = modCount + 1;
            enqueueNotification(referenceentry1.getKey(), i, referenceentry1.getValueReference().get(), MapMaker.RemovalCause.COLLECTED);
            referenceentry = removeFromChain(referenceentry2, referenceentry1);
            i = count;
            atomicreferencearray.set(j, referenceentry);
            count = i - 1;
            unlock();
            postWriteCleanup();
            return true;
            referenceentry1 = referenceentry1.getNext();
            if (true) goto _L2; else goto _L1
_L1:
            unlock();
            postWriteCleanup();
            return false;
            referenceentry;
            unlock();
            postWriteCleanup();
            throw referenceentry;
        }

        final boolean reclaimValue(Object obj, int i, ValueReference valuereference)
        {
            boolean flag;
            flag = false;
            lock();
            ReferenceEntry referenceentry1;
            AtomicReferenceArray atomicreferencearray;
            int j;
            j = count;
            atomicreferencearray = table;
            j = i & atomicreferencearray.length() - 1;
            referenceentry1 = (ReferenceEntry)atomicreferencearray.get(j);
            ReferenceEntry referenceentry = referenceentry1;
_L12:
            if (referenceentry == null) goto _L2; else goto _L1
_L1:
            Object obj1 = referenceentry.getKey();
            if (referenceentry.getHash() != i || obj1 == null) goto _L4; else goto _L3
_L3:
            if (!map.keyEquivalence.equivalent(obj, obj1)) goto _L4; else goto _L5
_L5:
            if (referenceentry.getValueReference() != valuereference) goto _L7; else goto _L6
_L6:
            modCount = modCount + 1;
            enqueueNotification(obj, i, valuereference.get(), MapMaker.RemovalCause.COLLECTED);
            obj = removeFromChain(referenceentry1, referenceentry);
            i = count;
            atomicreferencearray.set(j, obj);
            count = i - 1;
            unlock();
            if (!isHeldByCurrentThread())
            {
                postWriteCleanup();
            }
            flag = true;
_L9:
            return flag;
_L7:
            unlock();
            if (isHeldByCurrentThread()) goto _L9; else goto _L8
_L8:
            postWriteCleanup();
            return false;
_L4:
            referenceentry = referenceentry.getNext();
            continue; /* Loop/switch isn't completed */
_L2:
            unlock();
            if (isHeldByCurrentThread()) goto _L9; else goto _L10
_L10:
            postWriteCleanup();
            return false;
            obj;
            unlock();
            if (!isHeldByCurrentThread())
            {
                postWriteCleanup();
            }
            throw obj;
            if (true) goto _L12; else goto _L11
_L11:
        }

        final Object remove(Object obj, int i)
        {
            lock();
            ReferenceEntry referenceentry1;
            AtomicReferenceArray atomicreferencearray;
            int j;
            preWriteCleanup();
            j = count;
            atomicreferencearray = table;
            j = i & atomicreferencearray.length() - 1;
            referenceentry1 = (ReferenceEntry)atomicreferencearray.get(j);
            ReferenceEntry referenceentry = referenceentry1;
_L3:
            if (referenceentry == null)
            {
                break; /* Loop/switch isn't completed */
            }
            Object obj1 = referenceentry.getKey();
            if (referenceentry.getHash() != i || obj1 == null)
            {
                break MISSING_BLOCK_LABEL_196;
            }
            Object obj2;
            if (!map.keyEquivalence.equivalent(obj, obj1))
            {
                break MISSING_BLOCK_LABEL_196;
            }
            obj = referenceentry.getValueReference();
            obj2 = ((ValueReference) (obj)).get();
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_172;
            }
            obj = MapMaker.RemovalCause.EXPLICIT;
_L1:
            modCount = modCount + 1;
            enqueueNotification(obj1, i, obj2, ((MapMaker.RemovalCause) (obj)));
            obj = removeFromChain(referenceentry1, referenceentry);
            i = count;
            atomicreferencearray.set(j, obj);
            count = i - 1;
            unlock();
            postWriteCleanup();
            return obj2;
label0:
            {
                if (!isCollected(((ValueReference) (obj))))
                {
                    break label0;
                }
                obj = MapMaker.RemovalCause.COLLECTED;
            }
              goto _L1
            unlock();
            postWriteCleanup();
            return null;
            referenceentry = referenceentry.getNext();
            if (true) goto _L3; else goto _L2
_L2:
            unlock();
            postWriteCleanup();
            return null;
            obj;
            unlock();
            postWriteCleanup();
            throw obj;
        }

        final boolean remove(Object obj, int i, Object obj1)
        {
            boolean flag;
            flag = false;
            lock();
            ReferenceEntry referenceentry1;
            AtomicReferenceArray atomicreferencearray;
            int j;
            preWriteCleanup();
            j = count;
            atomicreferencearray = table;
            j = i & atomicreferencearray.length() - 1;
            referenceentry1 = (ReferenceEntry)atomicreferencearray.get(j);
            ReferenceEntry referenceentry = referenceentry1;
_L3:
            if (referenceentry == null)
            {
                break; /* Loop/switch isn't completed */
            }
            Object obj2 = referenceentry.getKey();
            if (referenceentry.getHash() != i || obj2 == null)
            {
                break MISSING_BLOCK_LABEL_228;
            }
            Object obj3;
            if (!map.keyEquivalence.equivalent(obj, obj2))
            {
                break MISSING_BLOCK_LABEL_228;
            }
            obj = referenceentry.getValueReference();
            obj3 = ((ValueReference) (obj)).get();
            if (!map.valueEquivalence.equivalent(obj1, obj3))
            {
                break MISSING_BLOCK_LABEL_204;
            }
            obj = MapMaker.RemovalCause.EXPLICIT;
_L1:
            modCount = modCount + 1;
            enqueueNotification(obj2, i, obj3, ((MapMaker.RemovalCause) (obj)));
            obj1 = removeFromChain(referenceentry1, referenceentry);
            i = count;
            atomicreferencearray.set(j, obj1);
            count = i - 1;
            obj1 = MapMaker.RemovalCause.EXPLICIT;
            if (obj == obj1)
            {
                flag = true;
            }
            unlock();
            postWriteCleanup();
            return flag;
label0:
            {
                if (!isCollected(((ValueReference) (obj))))
                {
                    break label0;
                }
                obj = MapMaker.RemovalCause.COLLECTED;
            }
              goto _L1
            unlock();
            postWriteCleanup();
            return false;
            referenceentry = referenceentry.getNext();
            if (true) goto _L3; else goto _L2
_L2:
            unlock();
            postWriteCleanup();
            return false;
            obj;
            unlock();
            postWriteCleanup();
            throw obj;
        }

        final Object replace(Object obj, int i, Object obj1)
        {
            lock();
            ReferenceEntry referenceentry1;
            AtomicReferenceArray atomicreferencearray;
            int j;
            preWriteCleanup();
            atomicreferencearray = table;
            j = i & atomicreferencearray.length() - 1;
            referenceentry1 = (ReferenceEntry)atomicreferencearray.get(j);
            ReferenceEntry referenceentry = referenceentry1;
_L2:
            if (referenceentry == null)
            {
                break; /* Loop/switch isn't completed */
            }
            Object obj2 = referenceentry.getKey();
            if (referenceentry.getHash() != i || obj2 == null)
            {
                break MISSING_BLOCK_LABEL_224;
            }
            ValueReference valuereference;
            Object obj3;
            if (!map.keyEquivalence.equivalent(obj, obj2))
            {
                break MISSING_BLOCK_LABEL_224;
            }
            valuereference = referenceentry.getValueReference();
            obj3 = valuereference.get();
            if (obj3 != null)
            {
                break MISSING_BLOCK_LABEL_185;
            }
            if (isCollected(valuereference))
            {
                int k = count;
                modCount = modCount + 1;
                enqueueNotification(obj2, i, obj3, MapMaker.RemovalCause.COLLECTED);
                obj = removeFromChain(referenceentry1, referenceentry);
                i = count;
                atomicreferencearray.set(j, obj);
                count = i - 1;
            }
            unlock();
            postWriteCleanup();
            return null;
            modCount = modCount + 1;
            enqueueNotification(obj, i, obj3, MapMaker.RemovalCause.REPLACED);
            setValue(referenceentry, obj1);
            unlock();
            postWriteCleanup();
            return obj3;
            referenceentry = referenceentry.getNext();
            if (true) goto _L2; else goto _L1
_L1:
            unlock();
            postWriteCleanup();
            return null;
            obj;
            unlock();
            postWriteCleanup();
            throw obj;
        }

        final boolean replace(Object obj, int i, Object obj1, Object obj2)
        {
            lock();
            ReferenceEntry referenceentry1;
            AtomicReferenceArray atomicreferencearray;
            int j;
            preWriteCleanup();
            atomicreferencearray = table;
            j = i & atomicreferencearray.length() - 1;
            referenceentry1 = (ReferenceEntry)atomicreferencearray.get(j);
            ReferenceEntry referenceentry = referenceentry1;
_L2:
            if (referenceentry == null)
            {
                break; /* Loop/switch isn't completed */
            }
            Object obj3 = referenceentry.getKey();
            if (referenceentry.getHash() != i || obj3 == null)
            {
                break MISSING_BLOCK_LABEL_256;
            }
            ValueReference valuereference;
            Object obj4;
            if (!map.keyEquivalence.equivalent(obj, obj3))
            {
                break MISSING_BLOCK_LABEL_256;
            }
            valuereference = referenceentry.getValueReference();
            obj4 = valuereference.get();
            if (obj4 != null)
            {
                break MISSING_BLOCK_LABEL_185;
            }
            if (isCollected(valuereference))
            {
                int k = count;
                modCount = modCount + 1;
                enqueueNotification(obj3, i, obj4, MapMaker.RemovalCause.COLLECTED);
                obj = removeFromChain(referenceentry1, referenceentry);
                i = count;
                atomicreferencearray.set(j, obj);
                count = i - 1;
            }
            unlock();
            postWriteCleanup();
            return false;
            if (!map.valueEquivalence.equivalent(obj1, obj4))
            {
                break MISSING_BLOCK_LABEL_240;
            }
            modCount = modCount + 1;
            enqueueNotification(obj, i, obj4, MapMaker.RemovalCause.REPLACED);
            setValue(referenceentry, obj2);
            unlock();
            postWriteCleanup();
            return true;
            recordLockedRead(referenceentry);
            unlock();
            postWriteCleanup();
            return false;
            referenceentry = referenceentry.getNext();
            if (true) goto _L2; else goto _L1
_L1:
            unlock();
            postWriteCleanup();
            return false;
            obj;
            unlock();
            postWriteCleanup();
            throw obj;
        }

        Segment(MapMakerInternalMap mapmakerinternalmap, int i, int j)
        {
            Object obj1 = null;
            super();
            map = mapmakerinternalmap;
            maxSegmentSize = j;
            initTable(newEntryArray(i));
            Object obj;
            if (mapmakerinternalmap.usesKeyReferences())
            {
                obj = new ReferenceQueue();
            } else
            {
                obj = null;
            }
            keyReferenceQueue = ((ReferenceQueue) (obj));
            obj = obj1;
            if (mapmakerinternalmap.usesValueReferences())
            {
                obj = new ReferenceQueue();
            }
            valueReferenceQueue = ((ReferenceQueue) (obj));
            if (mapmakerinternalmap.evictsBySize() || mapmakerinternalmap.expiresAfterAccess())
            {
                obj = new ConcurrentLinkedQueue();
            } else
            {
                obj = MapMakerInternalMap.discardingQueue();
            }
            recencyQueue = ((Queue) (obj));
            if (mapmakerinternalmap.evictsBySize())
            {
                obj = new EvictionQueue();
            } else
            {
                obj = MapMakerInternalMap.discardingQueue();
            }
            evictionQueue = ((Queue) (obj));
            if (mapmakerinternalmap.expires())
            {
                mapmakerinternalmap = new ExpirationQueue();
            } else
            {
                mapmakerinternalmap = MapMakerInternalMap.discardingQueue();
            }
            expirationQueue = mapmakerinternalmap;
        }
    }

    static final class SoftValueReference extends SoftReference
        implements ValueReference
    {

        final ReferenceEntry entry;

        public final void clear(ValueReference valuereference)
        {
            clear();
        }

        public final ValueReference copyFor(ReferenceQueue referencequeue, Object obj, ReferenceEntry referenceentry)
        {
            return new SoftValueReference(referencequeue, obj, referenceentry);
        }

        public final ReferenceEntry getEntry()
        {
            return entry;
        }

        public final boolean isComputingReference()
        {
            return false;
        }

        SoftValueReference(ReferenceQueue referencequeue, Object obj, ReferenceEntry referenceentry)
        {
            super(obj, referencequeue);
            entry = referenceentry;
        }
    }

    static abstract class Strength extends Enum
    {

        private static final Strength $VALUES[];
        public static final Strength SOFT;
        public static final Strength STRONG;
        public static final Strength WEAK;

        public static Strength valueOf(String s)
        {
            return (Strength)Enum.valueOf(com/google/common/collect/MapMakerInternalMap$Strength, s);
        }

        public static Strength[] values()
        {
            return (Strength[])$VALUES.clone();
        }

        abstract Equivalence defaultEquivalence();

        abstract ValueReference referenceValue(Segment segment, ReferenceEntry referenceentry, Object obj);

        static 
        {
            STRONG = new Strength("STRONG", 0) {

                final Equivalence defaultEquivalence()
                {
                    return Equivalence.equals();
                }

                final ValueReference referenceValue(Segment segment, ReferenceEntry referenceentry, Object obj)
                {
                    return new StrongValueReference(obj);
                }

            };
            SOFT = new Strength("SOFT", 1) {

                final Equivalence defaultEquivalence()
                {
                    return Equivalence.identity();
                }

                final ValueReference referenceValue(Segment segment, ReferenceEntry referenceentry, Object obj)
                {
                    return new SoftValueReference(segment.valueReferenceQueue, obj, referenceentry);
                }

            };
            WEAK = new Strength("WEAK", 2) {

                final Equivalence defaultEquivalence()
                {
                    return Equivalence.identity();
                }

                final ValueReference referenceValue(Segment segment, ReferenceEntry referenceentry, Object obj)
                {
                    return new WeakValueReference(segment.valueReferenceQueue, obj, referenceentry);
                }

            };
            $VALUES = (new Strength[] {
                STRONG, SOFT, WEAK
            });
        }

        private Strength(String s, int i)
        {
            super(s, i);
        }

    }

    static class StrongEntry
        implements ReferenceEntry
    {

        final int hash;
        final Object key;
        final ReferenceEntry next;
        volatile ValueReference valueReference;

        public long getExpirationTime()
        {
            throw new UnsupportedOperationException();
        }

        public final int getHash()
        {
            return hash;
        }

        public final Object getKey()
        {
            return key;
        }

        public final ReferenceEntry getNext()
        {
            return next;
        }

        public ReferenceEntry getNextEvictable()
        {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getNextExpirable()
        {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getPreviousEvictable()
        {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getPreviousExpirable()
        {
            throw new UnsupportedOperationException();
        }

        public final ValueReference getValueReference()
        {
            return valueReference;
        }

        public void setExpirationTime(long l)
        {
            throw new UnsupportedOperationException();
        }

        public void setNextEvictable(ReferenceEntry referenceentry)
        {
            throw new UnsupportedOperationException();
        }

        public void setNextExpirable(ReferenceEntry referenceentry)
        {
            throw new UnsupportedOperationException();
        }

        public void setPreviousEvictable(ReferenceEntry referenceentry)
        {
            throw new UnsupportedOperationException();
        }

        public void setPreviousExpirable(ReferenceEntry referenceentry)
        {
            throw new UnsupportedOperationException();
        }

        public final void setValueReference(ValueReference valuereference)
        {
            ValueReference valuereference1 = valueReference;
            valueReference = valuereference;
            valuereference1.clear(valuereference);
        }

        StrongEntry(Object obj, int i, ReferenceEntry referenceentry)
        {
            valueReference = MapMakerInternalMap.unset();
            key = obj;
            hash = i;
            next = referenceentry;
        }
    }

    static final class StrongEvictableEntry extends StrongEntry
        implements ReferenceEntry
    {

        ReferenceEntry nextEvictable;
        ReferenceEntry previousEvictable;

        public final ReferenceEntry getNextEvictable()
        {
            return nextEvictable;
        }

        public final ReferenceEntry getPreviousEvictable()
        {
            return previousEvictable;
        }

        public final void setNextEvictable(ReferenceEntry referenceentry)
        {
            nextEvictable = referenceentry;
        }

        public final void setPreviousEvictable(ReferenceEntry referenceentry)
        {
            previousEvictable = referenceentry;
        }

        StrongEvictableEntry(Object obj, int i, ReferenceEntry referenceentry)
        {
            super(obj, i, referenceentry);
            nextEvictable = MapMakerInternalMap.nullEntry();
            previousEvictable = MapMakerInternalMap.nullEntry();
        }
    }

    static final class StrongExpirableEntry extends StrongEntry
        implements ReferenceEntry
    {

        ReferenceEntry nextExpirable;
        ReferenceEntry previousExpirable;
        volatile long time;

        public final long getExpirationTime()
        {
            return time;
        }

        public final ReferenceEntry getNextExpirable()
        {
            return nextExpirable;
        }

        public final ReferenceEntry getPreviousExpirable()
        {
            return previousExpirable;
        }

        public final void setExpirationTime(long l)
        {
            time = l;
        }

        public final void setNextExpirable(ReferenceEntry referenceentry)
        {
            nextExpirable = referenceentry;
        }

        public final void setPreviousExpirable(ReferenceEntry referenceentry)
        {
            previousExpirable = referenceentry;
        }

        StrongExpirableEntry(Object obj, int i, ReferenceEntry referenceentry)
        {
            super(obj, i, referenceentry);
            time = 0x7fffffffffffffffL;
            nextExpirable = MapMakerInternalMap.nullEntry();
            previousExpirable = MapMakerInternalMap.nullEntry();
        }
    }

    static final class StrongExpirableEvictableEntry extends StrongEntry
        implements ReferenceEntry
    {

        ReferenceEntry nextEvictable;
        ReferenceEntry nextExpirable;
        ReferenceEntry previousEvictable;
        ReferenceEntry previousExpirable;
        volatile long time;

        public final long getExpirationTime()
        {
            return time;
        }

        public final ReferenceEntry getNextEvictable()
        {
            return nextEvictable;
        }

        public final ReferenceEntry getNextExpirable()
        {
            return nextExpirable;
        }

        public final ReferenceEntry getPreviousEvictable()
        {
            return previousEvictable;
        }

        public final ReferenceEntry getPreviousExpirable()
        {
            return previousExpirable;
        }

        public final void setExpirationTime(long l)
        {
            time = l;
        }

        public final void setNextEvictable(ReferenceEntry referenceentry)
        {
            nextEvictable = referenceentry;
        }

        public final void setNextExpirable(ReferenceEntry referenceentry)
        {
            nextExpirable = referenceentry;
        }

        public final void setPreviousEvictable(ReferenceEntry referenceentry)
        {
            previousEvictable = referenceentry;
        }

        public final void setPreviousExpirable(ReferenceEntry referenceentry)
        {
            previousExpirable = referenceentry;
        }

        StrongExpirableEvictableEntry(Object obj, int i, ReferenceEntry referenceentry)
        {
            super(obj, i, referenceentry);
            time = 0x7fffffffffffffffL;
            nextExpirable = MapMakerInternalMap.nullEntry();
            previousExpirable = MapMakerInternalMap.nullEntry();
            nextEvictable = MapMakerInternalMap.nullEntry();
            previousEvictable = MapMakerInternalMap.nullEntry();
        }
    }

    static final class StrongValueReference
        implements ValueReference
    {

        final Object referent;

        public final void clear(ValueReference valuereference)
        {
        }

        public final ValueReference copyFor(ReferenceQueue referencequeue, Object obj, ReferenceEntry referenceentry)
        {
            return this;
        }

        public final Object get()
        {
            return referent;
        }

        public final ReferenceEntry getEntry()
        {
            return null;
        }

        public final boolean isComputingReference()
        {
            return false;
        }

        StrongValueReference(Object obj)
        {
            referent = obj;
        }
    }

    final class ValueIterator extends HashIterator
    {

        final MapMakerInternalMap this$0;

        public final Object next()
        {
            return nextEntry().getValue();
        }

        ValueIterator()
        {
            this$0 = MapMakerInternalMap.this;
            super();
        }
    }

    static interface ValueReference
    {

        public abstract void clear(ValueReference valuereference);

        public abstract ValueReference copyFor(ReferenceQueue referencequeue, Object obj, ReferenceEntry referenceentry);

        public abstract Object get();

        public abstract ReferenceEntry getEntry();

        public abstract boolean isComputingReference();
    }

    final class Values extends AbstractCollection
    {

        final MapMakerInternalMap this$0;

        public final void clear()
        {
            MapMakerInternalMap.this.clear();
        }

        public final boolean contains(Object obj)
        {
            return containsValue(obj);
        }

        public final boolean isEmpty()
        {
            return MapMakerInternalMap.this.isEmpty();
        }

        public final Iterator iterator()
        {
            return new ValueIterator();
        }

        public final int size()
        {
            return MapMakerInternalMap.this.size();
        }

        Values()
        {
            this$0 = MapMakerInternalMap.this;
            super();
        }
    }

    static class WeakEntry extends WeakReference
        implements ReferenceEntry
    {

        final int hash;
        final ReferenceEntry next;
        volatile ValueReference valueReference;

        public long getExpirationTime()
        {
            throw new UnsupportedOperationException();
        }

        public final int getHash()
        {
            return hash;
        }

        public final Object getKey()
        {
            return get();
        }

        public final ReferenceEntry getNext()
        {
            return next;
        }

        public ReferenceEntry getNextEvictable()
        {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getNextExpirable()
        {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getPreviousEvictable()
        {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry getPreviousExpirable()
        {
            throw new UnsupportedOperationException();
        }

        public final ValueReference getValueReference()
        {
            return valueReference;
        }

        public void setExpirationTime(long l)
        {
            throw new UnsupportedOperationException();
        }

        public void setNextEvictable(ReferenceEntry referenceentry)
        {
            throw new UnsupportedOperationException();
        }

        public void setNextExpirable(ReferenceEntry referenceentry)
        {
            throw new UnsupportedOperationException();
        }

        public void setPreviousEvictable(ReferenceEntry referenceentry)
        {
            throw new UnsupportedOperationException();
        }

        public void setPreviousExpirable(ReferenceEntry referenceentry)
        {
            throw new UnsupportedOperationException();
        }

        public final void setValueReference(ValueReference valuereference)
        {
            ValueReference valuereference1 = valueReference;
            valueReference = valuereference;
            valuereference1.clear(valuereference);
        }

        WeakEntry(ReferenceQueue referencequeue, Object obj, int i, ReferenceEntry referenceentry)
        {
            super(obj, referencequeue);
            valueReference = MapMakerInternalMap.unset();
            hash = i;
            next = referenceentry;
        }
    }

    static final class WeakEvictableEntry extends WeakEntry
        implements ReferenceEntry
    {

        ReferenceEntry nextEvictable;
        ReferenceEntry previousEvictable;

        public final ReferenceEntry getNextEvictable()
        {
            return nextEvictable;
        }

        public final ReferenceEntry getPreviousEvictable()
        {
            return previousEvictable;
        }

        public final void setNextEvictable(ReferenceEntry referenceentry)
        {
            nextEvictable = referenceentry;
        }

        public final void setPreviousEvictable(ReferenceEntry referenceentry)
        {
            previousEvictable = referenceentry;
        }

        WeakEvictableEntry(ReferenceQueue referencequeue, Object obj, int i, ReferenceEntry referenceentry)
        {
            super(referencequeue, obj, i, referenceentry);
            nextEvictable = MapMakerInternalMap.nullEntry();
            previousEvictable = MapMakerInternalMap.nullEntry();
        }
    }

    static final class WeakExpirableEntry extends WeakEntry
        implements ReferenceEntry
    {

        ReferenceEntry nextExpirable;
        ReferenceEntry previousExpirable;
        volatile long time;

        public final long getExpirationTime()
        {
            return time;
        }

        public final ReferenceEntry getNextExpirable()
        {
            return nextExpirable;
        }

        public final ReferenceEntry getPreviousExpirable()
        {
            return previousExpirable;
        }

        public final void setExpirationTime(long l)
        {
            time = l;
        }

        public final void setNextExpirable(ReferenceEntry referenceentry)
        {
            nextExpirable = referenceentry;
        }

        public final void setPreviousExpirable(ReferenceEntry referenceentry)
        {
            previousExpirable = referenceentry;
        }

        WeakExpirableEntry(ReferenceQueue referencequeue, Object obj, int i, ReferenceEntry referenceentry)
        {
            super(referencequeue, obj, i, referenceentry);
            time = 0x7fffffffffffffffL;
            nextExpirable = MapMakerInternalMap.nullEntry();
            previousExpirable = MapMakerInternalMap.nullEntry();
        }
    }

    static final class WeakExpirableEvictableEntry extends WeakEntry
        implements ReferenceEntry
    {

        ReferenceEntry nextEvictable;
        ReferenceEntry nextExpirable;
        ReferenceEntry previousEvictable;
        ReferenceEntry previousExpirable;
        volatile long time;

        public final long getExpirationTime()
        {
            return time;
        }

        public final ReferenceEntry getNextEvictable()
        {
            return nextEvictable;
        }

        public final ReferenceEntry getNextExpirable()
        {
            return nextExpirable;
        }

        public final ReferenceEntry getPreviousEvictable()
        {
            return previousEvictable;
        }

        public final ReferenceEntry getPreviousExpirable()
        {
            return previousExpirable;
        }

        public final void setExpirationTime(long l)
        {
            time = l;
        }

        public final void setNextEvictable(ReferenceEntry referenceentry)
        {
            nextEvictable = referenceentry;
        }

        public final void setNextExpirable(ReferenceEntry referenceentry)
        {
            nextExpirable = referenceentry;
        }

        public final void setPreviousEvictable(ReferenceEntry referenceentry)
        {
            previousEvictable = referenceentry;
        }

        public final void setPreviousExpirable(ReferenceEntry referenceentry)
        {
            previousExpirable = referenceentry;
        }

        WeakExpirableEvictableEntry(ReferenceQueue referencequeue, Object obj, int i, ReferenceEntry referenceentry)
        {
            super(referencequeue, obj, i, referenceentry);
            time = 0x7fffffffffffffffL;
            nextExpirable = MapMakerInternalMap.nullEntry();
            previousExpirable = MapMakerInternalMap.nullEntry();
            nextEvictable = MapMakerInternalMap.nullEntry();
            previousEvictable = MapMakerInternalMap.nullEntry();
        }
    }

    static final class WeakValueReference extends WeakReference
        implements ValueReference
    {

        final ReferenceEntry entry;

        public final void clear(ValueReference valuereference)
        {
            clear();
        }

        public final ValueReference copyFor(ReferenceQueue referencequeue, Object obj, ReferenceEntry referenceentry)
        {
            return new WeakValueReference(referencequeue, obj, referenceentry);
        }

        public final ReferenceEntry getEntry()
        {
            return entry;
        }

        public final boolean isComputingReference()
        {
            return false;
        }

        WeakValueReference(ReferenceQueue referencequeue, Object obj, ReferenceEntry referenceentry)
        {
            super(obj, referencequeue);
            entry = referenceentry;
        }
    }

    final class WriteThroughEntry extends AbstractMapEntry
    {

        final Object key;
        final MapMakerInternalMap this$0;
        Object value;

        public final boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof java.util.Map.Entry)
            {
                obj = (java.util.Map.Entry)obj;
                flag = flag1;
                if (key.equals(((java.util.Map.Entry) (obj)).getKey()))
                {
                    flag = flag1;
                    if (value.equals(((java.util.Map.Entry) (obj)).getValue()))
                    {
                        flag = true;
                    }
                }
            }
            return flag;
        }

        public final Object getKey()
        {
            return key;
        }

        public final Object getValue()
        {
            return value;
        }

        public final int hashCode()
        {
            return key.hashCode() ^ value.hashCode();
        }

        public final Object setValue(Object obj)
        {
            Object obj1 = put(key, obj);
            value = obj;
            return obj1;
        }

        WriteThroughEntry(Object obj, Object obj1)
        {
            this$0 = MapMakerInternalMap.this;
            super();
            key = obj;
            value = obj1;
        }
    }


    static final Queue DISCARDING_QUEUE = new AbstractQueue() {

        public final Iterator iterator()
        {
            return Iterators.emptyIterator();
        }

        public final boolean offer(Object obj)
        {
            return true;
        }

        public final Object peek()
        {
            return null;
        }

        public final Object poll()
        {
            return null;
        }

        public final int size()
        {
            return 0;
        }

    };
    static final ValueReference UNSET = new ValueReference() {

        public final void clear(ValueReference valuereference)
        {
        }

        public final ValueReference copyFor(ReferenceQueue referencequeue, Object obj, ReferenceEntry referenceentry)
        {
            return this;
        }

        public final Object get()
        {
            return null;
        }

        public final ReferenceEntry getEntry()
        {
            return null;
        }

        public final boolean isComputingReference()
        {
            return false;
        }

    };
    private static final Logger logger = Logger.getLogger(com/google/common/collect/MapMakerInternalMap.getName());
    final int concurrencyLevel;
    final transient EntryFactory entryFactory;
    transient Set entrySet;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final Equivalence keyEquivalence;
    transient Set keySet;
    final Strength keyStrength;
    final int maximumSize;
    final MapMaker.RemovalListener removalListener;
    final Queue removalNotificationQueue;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient Segment segments[];
    final Ticker ticker;
    final Equivalence valueEquivalence;
    final Strength valueStrength;
    transient Collection values;

    MapMakerInternalMap(MapMaker mapmaker)
    {
        concurrencyLevel = Math.min(mapmaker.getConcurrencyLevel(), 0x10000);
        keyStrength = mapmaker.getKeyStrength();
        valueStrength = mapmaker.getValueStrength();
        keyEquivalence = mapmaker.getKeyEquivalence();
        valueEquivalence = valueStrength.defaultEquivalence();
        maximumSize = mapmaker.maximumSize;
        expireAfterAccessNanos = mapmaker.getExpireAfterAccessNanos();
        expireAfterWriteNanos = mapmaker.getExpireAfterWriteNanos();
        entryFactory = EntryFactory.getFactory(keyStrength, expires(), evictsBySize());
        ticker = mapmaker.getTicker();
        removalListener = mapmaker.getRemovalListener();
        Object obj;
        int i;
        int k;
        int l;
        if (removalListener == GenericMapMaker.NullListener.INSTANCE)
        {
            obj = discardingQueue();
        } else
        {
            obj = new ConcurrentLinkedQueue();
        }
        removalNotificationQueue = ((Queue) (obj));
        i = Math.min(mapmaker.getInitialCapacity(), 0x40000000);
        k = i;
        if (evictsBySize())
        {
            k = Math.min(i, maximumSize);
        }
        l = 0;
        for (i = 1; i < concurrencyLevel && (!evictsBySize() || i << 1 <= maximumSize); i <<= 1)
        {
            l++;
        }

        segmentShift = 32 - l;
        segmentMask = i - 1;
        segments = newSegmentArray(i);
        int j1 = k / i;
        l = j1;
        if (j1 * i < k)
        {
            l = j1 + 1;
        }
        for (k = 1; k < l; k <<= 1) { }
        if (evictsBySize())
        {
            int k1 = maximumSize / i + 1;
            int i2 = maximumSize;
            for (int i1 = 0; i1 < segments.length;)
            {
                int l1 = k1;
                if (i1 == i2 % i)
                {
                    l1 = k1 - 1;
                }
                segments[i1] = createSegment(k, l1);
                i1++;
                k1 = l1;
            }

        } else
        {
            for (int j = 0; j < segments.length; j++)
            {
                segments[j] = createSegment(k, -1);
            }

        }
    }

    static void connectEvictables(ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
    {
        referenceentry.setNextEvictable(referenceentry1);
        referenceentry1.setPreviousEvictable(referenceentry);
    }

    static void connectExpirables(ReferenceEntry referenceentry, ReferenceEntry referenceentry1)
    {
        referenceentry.setNextExpirable(referenceentry1);
        referenceentry1.setPreviousExpirable(referenceentry);
    }

    private Segment createSegment(int i, int j)
    {
        return new Segment(this, i, j);
    }

    static Queue discardingQueue()
    {
        return DISCARDING_QUEUE;
    }

    private boolean expiresAfterWrite()
    {
        return expireAfterWriteNanos > 0L;
    }

    private int hash(Object obj)
    {
        return rehash(keyEquivalence.hash(obj));
    }

    static boolean isExpired(ReferenceEntry referenceentry, long l)
    {
        return l - referenceentry.getExpirationTime() > 0L;
    }

    private static Segment[] newSegmentArray(int i)
    {
        return new Segment[i];
    }

    static ReferenceEntry nullEntry()
    {
        return NullEntry.INSTANCE;
    }

    static void nullifyEvictable(ReferenceEntry referenceentry)
    {
        ReferenceEntry referenceentry1 = nullEntry();
        referenceentry.setNextEvictable(referenceentry1);
        referenceentry.setPreviousEvictable(referenceentry1);
    }

    static void nullifyExpirable(ReferenceEntry referenceentry)
    {
        ReferenceEntry referenceentry1 = nullEntry();
        referenceentry.setNextExpirable(referenceentry1);
        referenceentry.setPreviousExpirable(referenceentry1);
    }

    private static int rehash(int i)
    {
        i += i << 15 ^ 0xffffcd7d;
        i ^= i >>> 10;
        i += i << 3;
        i ^= i >>> 6;
        i += (i << 2) + (i << 14);
        return i >>> 16 ^ i;
    }

    private Segment segmentFor(int i)
    {
        return segments[i >>> segmentShift & segmentMask];
    }

    static ValueReference unset()
    {
        return UNSET;
    }

    public void clear()
    {
        Segment asegment[] = segments;
        int j = asegment.length;
        for (int i = 0; i < j; i++)
        {
            asegment[i].clear();
        }

    }

    public boolean containsKey(Object obj)
    {
        if (obj == null)
        {
            return false;
        } else
        {
            int i = hash(obj);
            return segmentFor(i).containsKey(obj, i);
        }
    }

    public boolean containsValue(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        Segment asegment[] = segments;
        long l2 = -1L;
        int i = 0;
        do
        {
            if (i >= 3)
            {
                break;
            }
            long l1 = 0L;
            int i1 = asegment.length;
            for (int j = 0; j < i1; j++)
            {
                Segment segment = asegment[j];
                int k = segment.count;
                AtomicReferenceArray atomicreferencearray = segment.table;
                for (int l = 0; l < atomicreferencearray.length(); l++)
                {
                    for (ReferenceEntry referenceentry = (ReferenceEntry)atomicreferencearray.get(l); referenceentry != null; referenceentry = referenceentry.getNext())
                    {
                        Object obj1 = segment.getLiveValue(referenceentry);
                        if (obj1 != null && valueEquivalence.equivalent(obj, obj1))
                        {
                            return true;
                        }
                    }

                }

                l1 += segment.modCount;
            }

            if (l1 == l2)
            {
                break;
            }
            i++;
            l2 = l1;
        } while (true);
        return false;
    }

    public Set entrySet()
    {
        Set set = entrySet;
        if (set != null)
        {
            return set;
        } else
        {
            EntrySet entryset = new EntrySet();
            entrySet = entryset;
            return entryset;
        }
    }

    final boolean evictsBySize()
    {
        return maximumSize != -1;
    }

    final boolean expires()
    {
        return expiresAfterWrite() || expiresAfterAccess();
    }

    final boolean expiresAfterAccess()
    {
        return expireAfterAccessNanos > 0L;
    }

    public Object get(Object obj)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            int i = hash(obj);
            return segmentFor(i).get(obj, i);
        }
    }

    final Object getLiveValue(ReferenceEntry referenceentry)
    {
        Object obj;
        if (referenceentry.getKey() == null)
        {
            obj = null;
        } else
        {
            Object obj1 = referenceentry.getValueReference().get();
            if (obj1 == null)
            {
                return null;
            }
            obj = obj1;
            if (expires())
            {
                obj = obj1;
                if (isExpired(referenceentry))
                {
                    return null;
                }
            }
        }
        return obj;
    }

    public boolean isEmpty()
    {
        Segment asegment[];
        int i;
        long l;
        l = 0L;
        asegment = segments;
        i = 0;
_L9:
        if (i >= asegment.length) goto _L2; else goto _L1
_L1:
        if (asegment[i].count == 0) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        l += asegment[i].modCount;
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (l == 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 0;
_L6:
        if (i >= asegment.length)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (asegment[i].count != 0) goto _L3; else goto _L5
_L5:
        l -= asegment[i].modCount;
        i++;
          goto _L6
        if (l != 0L) goto _L3; else goto _L7
_L7:
        return true;
        if (true) goto _L9; else goto _L8
_L8:
    }

    final boolean isExpired(ReferenceEntry referenceentry)
    {
        return isExpired(referenceentry, ticker.read());
    }

    public Set keySet()
    {
        Set set = keySet;
        if (set != null)
        {
            return set;
        } else
        {
            KeySet keyset = new KeySet();
            keySet = keyset;
            return keyset;
        }
    }

    final void processPendingNotifications()
    {
        MapMaker.RemovalListener removallistener;
        while ((MapMaker.RemovalNotification)removalNotificationQueue.poll() != null) 
        {
            try
            {
                removallistener = removalListener;
            }
            catch (Exception exception)
            {
                logger.log(Level.WARNING, "Exception thrown by removal listener", exception);
            }
        }
    }

    public Object put(Object obj, Object obj1)
    {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj1);
        int i = hash(obj);
        return segmentFor(i).put(obj, i, obj1, false);
    }

    public void putAll(Map map)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public Object putIfAbsent(Object obj, Object obj1)
    {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj1);
        int i = hash(obj);
        return segmentFor(i).put(obj, i, obj1, true);
    }

    final void reclaimKey(ReferenceEntry referenceentry)
    {
        int i = referenceentry.getHash();
        segmentFor(i).reclaimKey(referenceentry, i);
    }

    final void reclaimValue(ValueReference valuereference)
    {
        ReferenceEntry referenceentry = valuereference.getEntry();
        int i = referenceentry.getHash();
        segmentFor(i).reclaimValue(referenceentry.getKey(), i, valuereference);
    }

    public Object remove(Object obj)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            int i = hash(obj);
            return segmentFor(i).remove(obj, i);
        }
    }

    public boolean remove(Object obj, Object obj1)
    {
        if (obj == null || obj1 == null)
        {
            return false;
        } else
        {
            int i = hash(obj);
            return segmentFor(i).remove(obj, i, obj1);
        }
    }

    public Object replace(Object obj, Object obj1)
    {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj1);
        int i = hash(obj);
        return segmentFor(i).replace(obj, i, obj1);
    }

    public boolean replace(Object obj, Object obj1, Object obj2)
    {
        Preconditions.checkNotNull(obj);
        Preconditions.checkNotNull(obj2);
        if (obj1 == null)
        {
            return false;
        } else
        {
            int i = hash(obj);
            return segmentFor(i).replace(obj, i, obj1, obj2);
        }
    }

    public int size()
    {
        Segment asegment[] = segments;
        long l = 0L;
        for (int i = 0; i < asegment.length; i++)
        {
            l += asegment[i].count;
        }

        return Ints.saturatedCast(l);
    }

    final boolean usesKeyReferences()
    {
        return keyStrength != Strength.STRONG;
    }

    final boolean usesValueReferences()
    {
        return valueStrength != Strength.STRONG;
    }

    public Collection values()
    {
        Collection collection = values;
        if (collection != null)
        {
            return collection;
        } else
        {
            Values values1 = new Values();
            values = values1;
            return values1;
        }
    }


    // Unreferenced inner class com/google/common/collect/MapMakerInternalMap$EvictionQueue$1

/* anonymous class */
    final class EvictionQueue._cls1 extends AbstractReferenceEntry
    {

        ReferenceEntry nextEvictable;
        ReferenceEntry previousEvictable;
        final EvictionQueue this$0;

        public final ReferenceEntry getNextEvictable()
        {
            return nextEvictable;
        }

        public final ReferenceEntry getPreviousEvictable()
        {
            return previousEvictable;
        }

        public final void setNextEvictable(ReferenceEntry referenceentry)
        {
            nextEvictable = referenceentry;
        }

        public final void setPreviousEvictable(ReferenceEntry referenceentry)
        {
            previousEvictable = referenceentry;
        }

            
            {
                this$0 = EvictionQueue.this;
                super();
                nextEvictable = this;
                previousEvictable = this;
            }
    }


    // Unreferenced inner class com/google/common/collect/MapMakerInternalMap$ExpirationQueue$1

/* anonymous class */
    final class ExpirationQueue._cls1 extends AbstractReferenceEntry
    {

        ReferenceEntry nextExpirable;
        ReferenceEntry previousExpirable;
        final ExpirationQueue this$0;

        public final long getExpirationTime()
        {
            return 0x7fffffffffffffffL;
        }

        public final ReferenceEntry getNextExpirable()
        {
            return nextExpirable;
        }

        public final ReferenceEntry getPreviousExpirable()
        {
            return previousExpirable;
        }

        public final void setExpirationTime(long l)
        {
        }

        public final void setNextExpirable(ReferenceEntry referenceentry)
        {
            nextExpirable = referenceentry;
        }

        public final void setPreviousExpirable(ReferenceEntry referenceentry)
        {
            previousExpirable = referenceentry;
        }

            
            {
                this$0 = ExpirationQueue.this;
                super();
                nextExpirable = this;
                previousExpirable = this;
            }
    }

}
