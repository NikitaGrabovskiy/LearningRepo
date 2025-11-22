package JavaPractice.DesignPatterns.Behaviour.observer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        NewsAgency newsAgency = new NewsAgency();
        Observer chan1 = new NewsChannel("BBC");
        Observer chan2 = new NewsChannel("CNN");
        newsAgency.addObserver(chan1);
        newsAgency.addObserver(chan2);
        newsAgency.setNews("New java version released");
    }

}

interface Observer {
    void update(String news);
}

class NewsAgency {

    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void setNews(String news){
        this.news = news;
        notifyObservers();
    }

    public void notifyObservers(){
        for(Observer a :observers){
            a.update(this.news);
        }
    }
}

class NewsChannel implements Observer {

    public String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name +" received  " + news);
    }
}