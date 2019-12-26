package by.webparsing.vadim.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class XmlValidator {

    private final static Logger logger = LogManager.getLogger();

    public boolean validate(InputStream file){
        logger.info("Validating xml");
        File xsd = new File("schema.xsd");
        Source xmlFile = new StreamSource(file);
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
            return true;
        } catch (IOException | SAXException e){
            logger.error(e);
            return false;
        }
    }
}
