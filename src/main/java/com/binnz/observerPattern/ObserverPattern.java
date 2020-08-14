package com.binnz.observerPattern;

/**
 * DATE 2020-08-15.
 *
 * @author binnz
 *
 * ObserverPattern is a behavioral design pattern
 * It specifies communication between objects: observable and observers. An observable is an object which notifies
 * observers about the changes in its state
 * The pattern’s aim is to define a one-to-many relationship such that when one object changes state, the others are
 * notified and updated automatically
 *
 * import java.beans.PropertyChangeListener;
 * import java.beans.PropertyChangeSupport;
 *
 * From https://www.baeldung.com/java-observer-pattern
 */
public class ObserverPattern {

    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel();

        observable.addObserver(observer);
        System.out.println(observer.getNews());
        observable.setNews("news");
        System.out.println(observer.getNews());

    }
}
