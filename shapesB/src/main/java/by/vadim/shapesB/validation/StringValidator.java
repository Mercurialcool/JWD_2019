package by.vadim.shapesB.validation;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class StringValidator {
    private static final Logger logger = LogManager.getLogger(StringValidator.class);
    private static final int MINIMAL_ARGUMENT_NUMBER=13;
    public boolean validateTetrahedronLine(List<String> values) {
        boolean ret = true;
        ValueValidator validator = new ValueValidator();
        if (values.size() < MINIMAL_ARGUMENT_NUMBER) {
            ret = false;
        }
        if (!validator.isLong(values.get(0))) {
            ret = false;
        }
        for (int i = 1; i < values.size(); i++) {
            if (!validator.isDouble(values.get(i))) {
                ret = false;
            }
        }
        logger.log(Level.INFO, "Tetrahedron:" + values.get(0) + " isCorrect :" + ret);
        return ret;
    }


}
