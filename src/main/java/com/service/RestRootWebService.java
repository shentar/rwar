package com.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.service.io.SpecialInputStream;

@Produces(value = { "text/xml", "application/json", "application/xml", "text/html" })
public class RestRootWebService extends HttpServlet
{
    private static final Logger logger = LoggerFactory.getLogger(RestRootWebService.class);

    private static final long serialVersionUID = -7748065720779404006L;

    @GET
    @Path("/")
    public Response getMsg(@Context HttpServletRequest req, @Context HttpServletResponse response)
            throws IOException
    {
        logger.info("get mesg in");
        ResponseBuilder builder = Response.status(200);
        int bodysize = 1024 * 1024;
        String bstr = req.getHeader("bodysize");
        if (StringUtils.isNotBlank(bstr))
        {
            bodysize = Integer.parseInt(bstr);
        }

        builder.entity(new SpecialInputStream(bodysize));
        builder.header("Content-length: ", bodysize + "");

        return builder.build();
    }

    @GET
    @Path("/{bucketname}/{obj}")
    public Response getObj(@Context HttpServletRequest req, @Context HttpServletResponse response)
            throws IOException
    {
        logger.info("get mesg in");
        ResponseBuilder builder = Response.status(200);
        int bodysize = 1024 * 1024;
        String bstr = req.getHeader("bodysize");
        if (StringUtils.isNotBlank(bstr))
        {
            bodysize = Integer.parseInt(bstr);
        }

        builder.entity(new SpecialInputStream(bodysize));
        builder.header("Content-length: ", bodysize + "");

        return builder.build();
    }

    @PUT
    @Path("/")
    public Response putMsg(@Context HttpServletRequest req, @Context HttpServletResponse response,
            InputStream in) throws IOException
    {
        logger.info("put mesg in");
        ResponseBuilder builder = Response.status(200);

        BufferedInputStream bin = new BufferedInputStream(in);
        byte buffer[] = new byte[1024 * 64];
        while (bin.read(buffer) != -1)
        {

        }

        try
        {
            Thread.sleep(80);
        }
        catch (InterruptedException e)
        {
            logger.warn("error: ", e);
        }

        return builder.build();
    }

    @PUT
    @Path("/{bucketname}/{obj}")
    public Response putObj(@Context HttpServletRequest req, @Context HttpServletResponse response,
            InputStream in) throws IOException
    {
        logger.info("put mesg in");
        ResponseBuilder builder = Response.status(200);

        BufferedInputStream bin = new BufferedInputStream(in);
        byte buffer[] = new byte[1024 * 64];
        while (bin.read(buffer) != -1)
        {

        }

        try
        {
            Thread.sleep(80);
        }
        catch (InterruptedException e)
        {
            logger.warn("error: ", e);
        }

        return builder.build();
    }
}
