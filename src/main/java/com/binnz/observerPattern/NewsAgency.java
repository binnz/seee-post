package com.binnz.observerPattern;

import java.util.Observable;

/**
 * DATE 2020-08-15.
 *
 * @author binnz
 *
 *
 */
public class NewsAgency extends Observable {

    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }
}
