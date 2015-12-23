package com.fererlab.core.restful;


import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.ws.rs.InternalServerErrorException;

public class ExceptionInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        try {
            Object result = context.proceed();
            return result;
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }
    }

}
