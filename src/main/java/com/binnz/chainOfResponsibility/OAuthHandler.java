package com.binnz.chainOfResponsibility;

/**
 * DATE 2020-08-15.
 *
 * @author binnz
 */
public class OAuthHandler extends Handler {

    public OAuthHandler(Handler handler) {
        super(handler);
    }

    @Override
    public void handlerRequest(Request request) {
        if (request instanceof MyHttpRequest) {
            System.out.println("oauth handler success");
        }else {
            System.out.println("oauth handler ignore");
        }
        if (nextHandler != null) {
            System.out.println("pass request to " + nextHandler);
            nextHandler.handlerRequest(request);
        }
    }

}
