package by.vadim.shapesB.warehouse;


import by.vadim.shapesB.action.TetrahedronValuesUpdater;
import by.vadim.shapesB.entity.Tetrahedron;
import by.vadim.shapesB.exeption.LessThanZeroException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class Warehouse {
    private TetrahedronValuesUpdater action;
    private HashMap<Long,TetrahedronValues> valuesHashMap;
    private static final Logger logger = LogManager.getLogger(Warehouse.class);
    private Warehouse(){
        valuesHashMap=new HashMap<>();
    }
    private static final  Warehouse instance =new Warehouse();
    public void countValue(Tetrahedron tetrahedron, long id) {
         action=new TetrahedronValuesUpdater();
        TetrahedronValues tetrahedronValues=valuesHashMap.get(id);
        tetrahedronValues.setPerimeter(action.definePerimeter(tetrahedron));
        tetrahedronValues.setSurfaceArea(action.defineSurfaceArea(tetrahedron));
        try {
            tetrahedronValues.setVolume(action.defineVolume(tetrahedron));
        } catch (LessThanZeroException e) {
            logger.log(Level.ERROR,"degenerate figure id:"+tetrahedron.getId(),e);
        }
        tetrahedronValues.setApex(tetrahedron.getApex());
        tetrahedronValues.setBasePoint1(tetrahedron.getBaseVertex1());
        tetrahedronValues.setBasePoint2(tetrahedron.getBaseVertex2());
        tetrahedronValues.setBasePoint3(tetrahedron.getBaseVertex3());
    }
    public static Warehouse getInstance(){
        return Warehouse.instance;
    }
    public TetrahedronValues pickTetrahedronValuesById(long id){
        return valuesHashMap.get(id);
    }
    public void putTetrahedron(Tetrahedron tetrahedron){
        TetrahedronValues tetrahedronValues=new TetrahedronValues();
        valuesHashMap.put(tetrahedron.getId(),tetrahedronValues);
        countValue(tetrahedron,tetrahedron.getId());
    }

}
