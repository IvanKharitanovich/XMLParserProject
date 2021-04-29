package by.trjava.ivankharytanovich.util.validation;

import by.trjava.ivankharytanovich.exception.ValidationException;
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

public class XMLValidation {
    private final static Logger logger = LogManager.getLogger();

    public boolean Validate(String xsd, String xml) {
        boolean status = false;
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        try {
            File schemaLocation = new File(xsd);
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xml);
            validator.validate(source);
            status = true;
        } catch (SAXException | IOException exception) {
            status = false;
            logger.error("ISSUE WITH" + xml + "WHILE COMPARE TO" + xsd);
        }
        return status;
    }
}
