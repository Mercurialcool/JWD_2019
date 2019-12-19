package by.vadim.shapesB.entity;

import by.vadim.shapesB.observer.Publisher;
import by.vadim.shapesB.observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Tetrahedron implements Publisher {
    private long tetrahedronId;
    private Point apex;
    private Point baseVertex1;
    private Point baseVertex2;
    private Point baseVertex3;
    private List<Subscriber> subscribers;
    public long getId() {
        return tetrahedronId;
    }

    public void setId(long id) {
        this.tetrahedronId = id;
    }

    public Point getApex() {
        return apex;
    }

    public void setApex(Point apex) {
        this.apex = apex;
       notifySubscriber();
    }

    public Point getBaseVertex1() {
        return baseVertex1;
    }

    public void setBaseVertex1(Point baseVertex1) {
        this.baseVertex1 = baseVertex1;
        notifySubscriber();
    }

    public Point getBaseVertex2() {
        return baseVertex2;
    }

    public void setBaseVertex2(Point baseVertex2) {
        this.baseVertex2 = baseVertex2;
        notifySubscriber();
    }

    public Point getBaseVertex3() {
        return baseVertex3;
    }

    public void setBaseVertex3(Point baseVertex3) {

        this.baseVertex3 = baseVertex3;
        notifySubscriber();
    }

    public Tetrahedron(long tetrahedronId, Point apex, Point baseVertex1, Point baseVertex2, Point baseVertex3) {
        this.tetrahedronId = tetrahedronId;
        this.apex = apex;
        this.baseVertex1 = baseVertex1;
        this.baseVertex2 = baseVertex2;
        this.baseVertex3 = baseVertex3;
        this.subscribers=new ArrayList<>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + apex.hashCode();
        result = prime * result + baseVertex1.hashCode();
        result = prime * result + baseVertex2.hashCode();
        result = prime * result + baseVertex3.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Tetrahedron otherTetrahedron = (Tetrahedron) obj;
        if (!apex.equals(otherTetrahedron.apex)) {
            return false;
        }
        if (!baseVertex1.equals(otherTetrahedron.baseVertex1)) {
            return false;
        }
        if (!baseVertex2.equals(otherTetrahedron.baseVertex2)) {
            return false;
        }
        return (baseVertex3.equals(otherTetrahedron.baseVertex3));

    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("@Tetrahedron //n");
        toString.append(apex.toString() + "\\n");
        toString.append(baseVertex1.toString() + "\\n");
        toString.append(baseVertex2.toString() + "\\n");
        toString.append(baseVertex3.toString());
        return new String(toString);

    }


    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber() {
    subscribers.forEach(t->t.handleEvent(this));
    }
}
