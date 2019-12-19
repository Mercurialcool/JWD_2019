package by.vadim.shapesB.observer;

import by.vadim.shapesB.entity.Tetrahedron;


public  interface Subscriber {
    void handleEvent(Tetrahedron tetrahedron);

}
