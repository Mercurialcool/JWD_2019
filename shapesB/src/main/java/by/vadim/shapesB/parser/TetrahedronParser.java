package by.vadim.shapesB.parser;

import by.vadim.shapesB.entity.Point;
import by.vadim.shapesB.entity.Tetrahedron;
import by.vadim.shapesB.factory.TetrahedronFactory;
import by.vadim.shapesB.exeption.InvalidIdException;
import by.vadim.shapesB.validation.StringValidator;
import by.vadim.shapesB.validation.ShapesValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TetrahedronParser {
    public static final String REGEX_SEPARATOR = "\\s+";
    public Point parsePoint(List<String> values){
        TetrahedronFactory factory=new TetrahedronFactory();
        return factory.createPoint(Double.parseDouble(values.get(0)),Double.parseDouble(values.get(1)),Double.parseDouble(values.get(2)));
    }

    public List<Point> parsePoints(List<String> values){
        return List.of(
                parsePoint(List.of(values.get(1),values.get(2),values.get(3))),
                parsePoint(List.of(values.get(4),values.get(5),values.get(6))),
                parsePoint(List.of(values.get(7),values.get(8),values.get(9))),
                parsePoint(List.of(values.get(10),values.get(11),values.get(12)))
        );

    }

    public List<String> splitBySpaces(String line) {
        return new ArrayList<>(Arrays.asList(line.split(REGEX_SEPARATOR)));
    }
    public long parseId(List<String> values){
        return Integer.parseInt(values.get(0));
    }
    public List<Tetrahedron> parse(List<String> pointLines) {
        StringValidator stringValidator = new StringValidator();
        ShapesValidator tetrahedronValidator =new ShapesValidator();
        TetrahedronFactory factory= new TetrahedronFactory();
        return pointLines.stream()
                .map(this::splitBySpaces)
                .filter(stringValidator::validateTetrahedronLine)
                .map(t->factory.createTetrahedron(this.parseId(t),this.parsePoints(t).get(0),this.parsePoints(t).get(1),
                        this.parsePoints(t).get(2),this.parsePoints(t).get(3)))
                .filter(t-> {
                    try {
                        return tetrahedronValidator.isCorrectTetrahedron(t);
                    } catch (InvalidIdException e) {
                        e.printStackTrace();
                        return false;
                    }
                })
                .collect(Collectors.toList());


    }
}
