package com.binnz.chainOfResponsibility;

/**
 * DATE 2020-08-15.
 *
 * @author binnz
 */
public class PasswordHandler extends Handler {

    public PasswordHandler(Handler handler) {
        super(handler);
    }

    @Override
    public void handlerRequest(Request request) {
        if (request instanceof MyRequest) {
            System.out.println("password handler success");
        }else{
            System.out.println("password handler ignore");
        }
        if (nextHandler != null) {
            System.out.println("pass request to " + nextHandler);
            nextHandler.handlerRequest(request);
        }
    }
}
