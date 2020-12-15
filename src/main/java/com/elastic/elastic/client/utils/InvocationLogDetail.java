package com.elastic.elastic.client.utils;


import java.io.Serializable;

public class InvocationLogDetail {
    private String className;
    private String methodName;
    private Serializable arguments;
    private Serializable returnValue;
    private int elapsedTime;

    public InvocationLogDetail() {
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Serializable getArguments() {
        return this.arguments;
    }

    public void setArguments(Serializable arguments) {
        this.arguments = arguments;
    }

    public Serializable getReturnValue() {
        return this.returnValue;
    }

    public void setReturnValue(Serializable returnValue) {
        this.returnValue = returnValue;
    }

    public int getElapsedTime() {
        return this.elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}
