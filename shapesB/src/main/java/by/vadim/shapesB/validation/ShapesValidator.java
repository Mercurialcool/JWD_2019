package by.vadim.shapesB.validation;

import by.vadim.shapesB.entity.Point;
import by.vadim.shapesB.entity.Tetrahedron;
import by.vadim.shapesB.exeption.InvalidIdException;

public class ShapesValidator {
    private static final long MAX_ID=100000;
    private static final long MIN_ID=1;
    private static final double MAX_COORDINATE_VALUE=100000.0d;
    private static final double MIN_COORDINATE_VALUE=-100000.0d;
    private boolean isCoordinateValid(Point point){
        if(point.getX()>MAX_COORDINATE_VALUE||point.getX()<MIN_COORDINATE_VALUE)return false;
        if(point.getY()>MAX_COORDINATE_VALUE||point.getY()<MIN_COORDINATE_VALUE)return false;
        if(point.getZ()>MAX_COORDINATE_VALUE||point.getZ()<MIN_COORDINATE_VALUE)return false;

        return true;
    }
    public boolean isCorrectTetrahedron(Tetrahedron tetrahedron) throws InvalidIdException {
        boolean result=true;
        if(tetrahedron.getId()<MIN_ID||tetrahedron.getId()>MAX_ID){
            result=false;
            throw new InvalidIdException("Invalid id");

        }

        if((tetrahedron.getBaseVertex1().getZ()!=tetrahedron.getBaseVertex2().getZ())||
                (tetrahedron.getBaseVertex1().getZ()!=tetrahedron.getBaseVertex3().getZ())){
            result=false;
        }
        if((!isCoordinateValid(tetrahedron.getApex()))||(!isCoordinateValid(tetrahedron.getBaseVertex1()))
                ||(!isCoordinateValid(tetrahedron.getBaseVertex2()))||(!isCoordinateValid(tetrahedron.getBaseVertex3()))){
            result=false;
        }
        return result;
    }
}
