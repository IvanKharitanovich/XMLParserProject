package by.trjava.ivankharytanovich.util.parser;

import by.trjava.ivankharytanovich.entity.Medicine;
import by.trjava.ivankharytanovich.util.parser.MedicineHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SAXParser {
    private static final Logger logger = LogManager.getLogger();
    private Set<Medicine> medicineSet;
    private MedicineHandler medicineHandler;
    private XMLReader reader;

    public SAXParser() {
        medicineSet = new HashSet<>();
        medicineHandler = new MedicineHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(medicineHandler);
        } catch (SAXException exception) {
            logger.error("PARSING ERROR");
        }
    }

    public Set<Medicine> getMedicineSet() {
        return medicineSet;
    }

    public void parseDocument(String link) {
        try {
            reader.parse(link);
            medicineSet.addAll(medicineHandler.getMedicineSet());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException exception) {
            exception.printStackTrace();
        }
    }
}
