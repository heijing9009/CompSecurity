// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            TokeniserState, CharacterReader, Tokeniser

static final class it> extends TokeniserState
{

    void read(Tokeniser tokeniser, CharacterReader characterreader)
    {
        char c = characterreader.consume();
        switch (c)
        {
        default:
            characterreader.unconsume();
            tokeniser.transition(AttributeValue_unquoted);
            // fall through

        case 9: // '\t'
        case 10: // '\n'
        case 12: // '\f'
        case 32: // ' '
            return;

        case 34: // '"'
            tokeniser.transition(AttributeValue_doubleQuoted);
            return;

        case 38: // '&'
            characterreader.unconsume();
            tokeniser.transition(AttributeValue_unquoted);
            return;

        case 39: // '\''
            tokeniser.transition(AttributeValue_singleQuoted);
            return;

        case 0: // '\0'
            tokeniser.error(this);
            tokeniser.tagPending.tributeValue('\uFFFD');
            tokeniser.transition(AttributeValue_unquoted);
            return;

        case 65535: 
            tokeniser.eofError(this);
            tokeniser.transition(Data);
            return;

        case 62: // '>'
            tokeniser.error(this);
            tokeniser.emitTagPending();
            tokeniser.transition(Data);
            return;

        case 60: // '<'
        case 61: // '='
        case 96: // '`'
            tokeniser.error(this);
            tokeniser.tagPending.tributeValue(c);
            tokeniser.transition(AttributeValue_unquoted);
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
