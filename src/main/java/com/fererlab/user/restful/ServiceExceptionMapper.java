package com.fererlab.user.restful;

import com.fererlab.core.exception.ServiceException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

    @Override
    public Response toResponse(ServiceException exception) {
        return Response.status(500)
                .entity(exception)
                .header("ErrorMessage", exception.getMessage())
                .header("ErrorCode", exception.getErrorCode())
                .build();
    }

}