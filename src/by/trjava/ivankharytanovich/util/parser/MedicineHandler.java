package by.trjava.ivankharytanovich.util.parser;

import by.trjava.ivankharytanovich.entity.*;
import by.trjava.ivankharytanovich.entity.Package;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

public class MedicineHandler extends DefaultHandler {
    private final static Logger logger = LogManager.getLogger();
    private final static String DATE_FORMAT = "yyyy-mm-dd";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
    private Set<Medicine> medicineSet;
    private Medicine.Builder medicineBuilder;
    private StringBuilder stringBuilder;

    public MedicineHandler() {
        medicineSet = new HashSet<>();
    }

    public Set<Medicine> getMedicineSet() {
        return medicineSet;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder = new StringBuilder();

        if (qName.equals("medicine")) {
            medicineBuilder = Medicine.newBuilder();
            medicineBuilder.setId(attributes.getValue("medicineId"));
            medicineBuilder.setRecipeStatusNeeded(Boolean.valueOf(attributes.getValue("recipeStatusNeeded")));
            medicineBuilder.setAPackage(new Package());
            medicineBuilder.setDosage(new Dosage());
            medicineBuilder.setDosageFrequency(new Frequency());

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        MenuTagName menuTagName = MenuTagName.valueOf(qName.toUpperCase());
        if (menuTagName != null) {
            switch (menuTagName) {
                case NAME:
                    medicineBuilder.setName(stringBuilder.toString());
                    break;
                case ORGANISATIONNAME:
                    medicineBuilder.setOrganisation(stringBuilder.toString());
                    break;
                case GROUP:
                    medicineBuilder.setGroup(MedicationGroup.valueOf(stringBuilder.toString()));
                    break;
                case ANALOGS:
                    medicineBuilder.setAnalogs(stringBuilder.toString().split(","));
                    break;
                case VERSION:
                    medicineBuilder.setVersion(Version.valueOf(stringBuilder.toString()));
                    break;
                case ISSUEDATE:
                    try {
                        medicineBuilder.setIssueDate(simpleDateFormat.parse(stringBuilder.toString()));
                    } catch (ParseException exception) {
                        logger.error("DATE PARSING ERROR");
                    }
                    break;
                case EXPIRATIONDATE:
                    try {
                        medicineBuilder.setExpirationDate(simpleDateFormat.parse(stringBuilder.toString()));
                    } catch (ParseException exception) {
                        logger.error("DATE PARSING ERROR");
                    }
                    break;
                case REGISTERORGANISATIONNAME:
                    medicineBuilder.setRegisterOrganisation(stringBuilder.toString());
                    break;
                case PACKAGE:
                    break;
                case PACKAGETYPE:
                    medicineBuilder.setTypeOfPackage(PackageType.valueOf(stringBuilder.toString()));
                    break;
                case AMOUNT:
                    medicineBuilder.setPackageAmount(Double.parseDouble(stringBuilder.toString()));
                    break;
                case PRICE:
                    medicineBuilder.setPackagePrice(new BigDecimal(stringBuilder.toString()));
                    break;
                case DOSAGE:
                    break;
                case DOSAGEAMOUNT:
                    medicineBuilder.setDosageAmount(Double.parseDouble(stringBuilder.toString()));
                    break;
                case FREQUENCY:
                    medicineBuilder.setDosageFrequency(new Frequency());
                    break;
                case DAYS:
                    medicineBuilder.setFrequencyDays(Integer.parseInt(stringBuilder.toString()));
                    break;
                case PERDAY:
                    medicineBuilder.setFrequencyPerDay(Integer.parseInt(stringBuilder.toString()));
                    break;
                case MEDICINE:
                    medicineSet.add(medicineBuilder.build());
                    medicineBuilder = null;
                    break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        stringBuilder.append(ch, start, length);
    }
}
