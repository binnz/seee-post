package com.binnz.chainOfResponsibility;

/**
 * DATE 2020-08-15.
 *
 * @author binnz
 */
public abstract class Handler {

    public Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

    public abstract void handlerRequest(Request request);
}


