package io.github.mjhaugsdal;

import jakarta.xml.bind.JAXBException;
import no.kith.xmlstds.msghead._2006_05_24.MsgHead;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class ExampleTests {

    @Test
    void test() throws IOException, JAXBException, ParserConfigurationException, SAXException {
        var is = ExampleTests.class.getClassLoader().getResourceAsStream("M1 Resept.xml");
        Assertions.assertNotNull(is);
        var bytes = is.readAllBytes();
        var test = JaxbUtils.unmarshall(new String(bytes));
        Assertions.assertInstanceOf(MsgHead.class, test.getValue());

        var errors = JaxbUtils.validate(test);
        Assertions.assertEquals(0, errors.size());
        var xmlTest = JaxbUtils.marshall(test);
        System.out.println(xmlTest);

    }

    @Test
    void errorTest() throws IOException, JAXBException, ParserConfigurationException, SAXException {
        var is = ExampleTests.class.getClassLoader().getResourceAsStream("M1 Resept_error.xml");
        Assertions.assertNotNull(is);
        var bytes = is.readAllBytes();
        var test = JaxbUtils.unmarshall(new String(bytes));
        Assertions.assertInstanceOf(MsgHead.class, test.getValue());

        var errors = JaxbUtils.validate(test);
        Assertions.assertEquals(2, errors.size());

        Assertions.assertTrue(errors.get(0).contains("Forskrivningsdato") && errors.get(0).contains("is expected"));
        Assertions.assertTrue(errors.get(1).contains("Varegruppekode") && errors.get(1).contains("is expected"));
    }
}
