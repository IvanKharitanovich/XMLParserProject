package by.trjava.ivankharytanovich.util.validation;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class XMLValidationTest {
    XMLValidation xmlValidation;
    String xmlLink;
    String xsdLink;

    @BeforeClass
    public void setUp() {
        xmlValidation = new XMLValidation();
        xmlLink = "test/resources/data/medicins.xml";
        xsdLink = "test/resources/data/medicins.xsd";
    }

    @Test
    public void validationTest() {
        boolean actual = xmlValidation.Validate(xsdLink,xmlLink);
        Assert.assertTrue(actual);
    }
}
