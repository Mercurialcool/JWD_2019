package by.vadim.shapesB.observer;


public interface Publisher {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscriber();
}
