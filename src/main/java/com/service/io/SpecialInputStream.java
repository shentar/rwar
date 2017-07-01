package com.service.io;

import java.io.IOException;
import java.io.InputStream;

import com.utils.web.StringTools;

public class SpecialInputStream extends InputStream
{
    private static final int BUFFER_LEN = 1024;

    private int size = 0;

    public SpecialInputStream(int sizein)
    {
        this.size = sizein;
    }

    @Override
    public int read() throws IOException
    {
        return 0;
    }

    @Override
    public int read(byte[] buf, int off, int len) throws IOException
    {
        if (off < 0 || len < 0 || len < off || buf == null)
        {
            throw new IOException();
        }

        if (size == 0)
        {
            return -1;
        }

        int needlen = len - off;
        needlen = needlen > size ? size : needlen;

        int count = needlen / BUFFER_LEN;
        int devide = needlen % BUFFER_LEN;

        int pos = off;
        while (count-- > 0)
        {
            byte[] b = StringTools.getRandomString(BUFFER_LEN).getBytes("UTF-8");
            System.arraycopy(b, 0, buf, pos, BUFFER_LEN);
            pos += BUFFER_LEN;
        }

        if (devide > 0)
        {
            byte[] b = StringTools.getRandomString(devide).getBytes("UTF-8");
            System.arraycopy(b, 0, buf, pos, devide);
        }

        size -= needlen;

        return needlen;
    }

    @Override
    public int read(byte[] buf) throws IOException
    {
        return read(buf, 0, buf.length);
    }
}
