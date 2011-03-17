package com.eatrightapp.service.v1.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.googlecode.objectify.NotFoundException;

@Provider
public class NotFoundExceptionMapper 
implements ExceptionMapper<NotFoundException> {
	    public Response toResponse(NotFoundException nfe) {
	        return Response.status(404).
	            entity(nfe.getMessage()).
	            type("text/plain").
	            build();
	    }
}

