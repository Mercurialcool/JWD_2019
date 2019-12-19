package by.vadim.shapesB.reader;


import by.vadim.shapesB.exeption.WrongFileInputException;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TetrahedronReader {
    private static final Logger logger= LogManager.getLogger(TetrahedronReader.class);

    public List<String> readAllLine(String filePath) throws WrongFileInputException {
        List<String> pointLines;
        try (Stream<String> linesStream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {


            pointLines = linesStream.collect(Collectors.toList());
        } catch (IOException ex) {
            logger.log(Level.ERROR,"File problem "+filePath);
            throw new WrongFileInputException("File not founded", ex);
        }
        return pointLines;

    }
}
