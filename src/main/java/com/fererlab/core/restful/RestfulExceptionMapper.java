package com.fererlab.core.restful;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RestfulExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        String errorMessage = collectMessages(exception);
        String exceptionClasses = exceptionClasses(exception);
        String possibleCauses = possibleCauses(exception);
        return Response.status(500)
                .entity(exception)
                .header("ErrorMessage", errorMessage)
                .header("ExceptionClasses", exceptionClasses)
                .header("PossibleCauses", possibleCauses)
                .build();
    }

    private String possibleCauses(Exception exception) {
        String packageName = "";
        String[] packageParts = this.getClass().getPackage().getName().split("\\.");
        if (packageParts.length > 1) {
            packageName = packageParts[0] + "." + packageParts[1];
        }
        Throwable parentException = exception;
        while (parentException.getCause() != null) {
            parentException = parentException.getCause();
        }
        String possibleCauses = "";
        for (StackTraceElement stackTraceElement : parentException.getStackTrace()) {
            if (stackTraceElement.getClassName().startsWith(packageName)) {
                possibleCauses += stackTraceElement.getClassName() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber() + ";";
            }
        }
        return possibleCauses;
    }

    private String exceptionClasses(Throwable exception) {
        return (exception == null) ? "" : (
                (exception != exception.getCause()) ? exception.getClass().getName() + "|" + exceptionClasses(exception.getCause()) : ""
        );
    }

    private String collectMessages(Throwable exception) {
        return (exception.getMessage() == null ? "" : exception.getMessage()) + (exception.getCause() != null ? "|" + collectMessages(exception.getCause()) : "");
    }

}