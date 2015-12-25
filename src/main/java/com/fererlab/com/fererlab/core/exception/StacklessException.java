package com.fererlab.com.fererlab.core.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StacklessException extends Exception{

    private static final long serialVersionUID = -1279610549694153953L;

    public StacklessException() {
    }

    public StacklessException(String message) {
        super(message);
    }

    @JsonIgnore
    public StackTraceElement[] getStackTrace(){
        return super.getStackTrace();
    }

}
