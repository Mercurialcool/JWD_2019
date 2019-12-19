package by.vadim.shapesB.comparator;


import by.vadim.shapesB.entity.Tetrahedron;
import by.vadim.shapesB.warehouse.Warehouse;

import java.util.Comparator;

public class ComparatorFactory {
    public Comparator<Tetrahedron> byId=(t1, t2)->Long.compare(t1.getId(),t2.getId());
    public Comparator<Tetrahedron> byVolume=(t1,t2)->Double.compare(Warehouse.getInstance().pickTetrahedronValuesById(t1.getId()).getVolume(),
            Warehouse.getInstance().pickTetrahedronValuesById(t2.getId()).getVolume());

    }