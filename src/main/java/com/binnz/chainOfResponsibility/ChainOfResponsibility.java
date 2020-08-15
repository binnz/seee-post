package com.binnz.chainOfResponsibility;

/**
 * DATE 2020-08-14.
 *
 * @author binnz
 * Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon
 * receiving a request, each handler decides either to process the request or to pass it to the next handler in the
 * chain.
 *
 * The Chain of Responsibility pattern is handy for:
 *
 * Decoupling a sender and receiver of a command
 * Picking a processing strategy at processing-time
 */
public class ChainOfResponsibility {

    public static void main(String[] args) {
        PasswordHandler passwordHandler = new PasswordHandler(null);
        OAuthHandler oAuthHandler = new OAuthHandler(passwordHandler);
        MyHttpRequest myHttpRequest = new MyHttpRequest();
        MyRequest myRequest = new MyRequest();
        oAuthHandler.handlerRequest(myHttpRequest);
        oAuthHandler.handlerRequest(myRequest);

    }
}
