package com.binnz.observerPattern;

import java.util.Observable;
import java.util.Observer;

/**
 * DATE 2020-08-15.
 *
 * @author binnz
 */
public class NewsChannel implements Observer {

    private String news;

    public void update(Observable o, Object arg) {
        this.news = (String) arg;
    }

    public String getNews() {
        return news;
    }
}
