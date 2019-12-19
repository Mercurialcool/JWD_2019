package by.vadim.shapesB.factory;

import by.vadim.shapesB.entity.Point;
import by.vadim.shapesB.entity.Tetrahedron;
import by.vadim.shapesB.repository.Repository;
import by.vadim.shapesB.warehouse.Warehouse;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TetrahedronFactory {
    private static final Logger logger = LogManager.getLogger(TetrahedronFactory.class);

    public Tetrahedron createTetrahedron(long id, Point apex, Point base1, Point base2, Point base3) {
        logger.log(Level.DEBUG, "Create tetrahedron id:" + id);
        Tetrahedron tetrahedron=new Tetrahedron(id, apex, base1, base2, base3);
        Repository.INSTANCE.addTetrahedron(tetrahedron);

        //todo: clean Warehouse: it should have only methods: getInstance(), addTetrahedronValues(long tetrahedronId, TetrahedronValues values)
        //todo: create instance of TetrahedronValues here
        //todo: make TetrahedronValuesUpdater implements Subscriber. Constructor takes TetrahedronValues. When handleEvent happens just update the passed TetrahedronValues

        //todo: then here Warehouse.getInstance().addTetrahedronValues(tetrahedron.id, tetrahedronValues)
        //todo: then here tetrahedron.addSubscriber(tetrahedronValues)
        Warehouse.getInstance().putTetrahedron(tetrahedron);




        return tetrahedron;

    }
    public Point createPoint(double x,double y,double z){
        return new Point(x, y, z);
    }
}
