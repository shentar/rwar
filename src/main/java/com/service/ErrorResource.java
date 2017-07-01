package com.service;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

public class ErrorResource
{
    @GET
    public Response get(@Context HttpServletRequest req, @Context HttpServletResponse response,
            InputStream body)
    {
        return Response.status(500).entity("500 internel error!").build();
    }
}
