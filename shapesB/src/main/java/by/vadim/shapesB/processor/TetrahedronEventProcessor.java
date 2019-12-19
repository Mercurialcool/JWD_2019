package by.vadim.shapesB.processor;



import by.vadim.shapesB.observer.Subscriber;
import by.vadim.shapesB.entity.Tetrahedron;
import by.vadim.shapesB.warehouse.Warehouse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public enum  TetrahedronEventProcessor implements Subscriber {
    INSTANCE;
    private static final Logger logger = LogManager.getLogger(TetrahedronEventProcessor.class);

    @Override
    public void handleEvent(Tetrahedron tetrahedron) {
        Warehouse.getInstance().countValue(tetrahedron,tetrahedron.getId());
    }
    private TetrahedronEventProcessor(){

    }
}
