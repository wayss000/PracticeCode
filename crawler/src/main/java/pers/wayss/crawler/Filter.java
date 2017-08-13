package pers.wayss.crawler;


public interface Filter {

    boolean accept(String url);
}