package com.utils.sys;

import java.util.UUID;

public class UUIDGenerator
{
    public static String getUUID()
    {
        String uuid = UUID.randomUUID().toString();
        String[] splits = uuid.split("-");
        String ret = "";
        for (String s : splits)
        {
            ret += s;
        }

        if (ret.isEmpty())
        {
            return uuid.toUpperCase();
        }
        else
        {
            return ret.toUpperCase();
        }
    }
}
