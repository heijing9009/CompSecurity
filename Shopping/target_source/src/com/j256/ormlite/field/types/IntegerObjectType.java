// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseDataType

public class IntegerObjectType extends BaseDataType
{

    private static final IntegerObjectType singleTon = new IntegerObjectType();

    private IntegerObjectType()
    {
        super(SqlType.INTEGER, new Class[] {
            java/lang/Integer
        });
    }

    protected IntegerObjectType(SqlType sqltype, Class aclass[])
    {
        super(sqltype, aclass);
    }

    public static IntegerObjectType getSingleton()
    {
        return singleTon;
    }

    public Object convertIdNumber(Number number)
    {
        return Integer.valueOf(number.intValue());
    }

    public boolean isEscapedValue()
    {
        return false;
    }

    public boolean isValidForVersion()
    {
        return true;
    }

    public boolean isValidGeneratedType()
    {
        return true;
    }

    public Object moveToNextValue(Object obj)
    {
        if (obj == null)
        {
            return Integer.valueOf(1);
        } else
        {
            return Integer.valueOf(((Integer)obj).intValue() + 1);
        }
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
    {
        return Integer.valueOf(Integer.parseInt(s));
    }

    public Object resultToSqlArg(FieldType fieldtype, DatabaseResults databaseresults, int i)
        throws SQLException
    {
        return Integer.valueOf(databaseresults.getInt(i));
    }

}
