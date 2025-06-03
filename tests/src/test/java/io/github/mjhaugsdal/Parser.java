package io.github.mjhaugsdal;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.ValidationException;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//public static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
//private static final String AIMS_MESSAGE_SCHEMA_LOCATION = "/xsd/AimsMessage.xsd";
//private static final JAXBContext jaxbContext;
//
//private static final Schema schema;
//
public class Parser {
//
//
//    static {
//        try {
//            jaxbContext = JAXBContext.newInstance("no.kith.xmlstds");
//            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); //NOSONAR
//            schema = schemaFactory.newSchema(Parser.class.getResource(AIMS_MESSAGE_SCHEMA_LOCATION));
//        } catch (JAXBException | SAXException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static class ValidationErrorHandler implements ErrorHandler {
//        private final List<String> errors = new ArrayList<>();
//
//        @Override
//        public void warning(SAXParseException exception) throws SAXException {
//            errors.add("Warning: " + exception.getMessage());
//        }
//
//        @Override
//        public void error(SAXParseException exception) throws SAXException {
//            errors.add("Error: " + exception.getMessage());
//        }
//
//        @Override
//        public void fatalError(SAXParseException exception) throws SAXException {
//            errors.add("Fatal Error: " + exception.getMessage());
//        }
//
//        public List<String> getErrors() {
//            return errors;
//        }
//
//        public boolean hasErrors() {
//            return !errors.isEmpty();
//        }
//    }
//
//    public static JAXBElement<AimsDomainMessageType> unmarshall(String xmlText) throws JAXBException {
//        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//        return unmarshaller.unmarshal(new StreamSource(new ByteArrayInputStream(xmlText.getBytes(StandardCharsets.UTF_8))), AimsDomainMessageType.class);
//    }
//
//    public static String marshall(JAXBElement<AimsDomainMessageType> aimsDomainMessage) throws JAXBException {
//        StringWriter sw = new StringWriter();
//        Marshaller marshaller = jaxbContext.createMarshaller();
//        marshaller.marshal(aimsDomainMessage, sw);
//        return sw.toString();
//    }
//
//    /**
//     * @param xml The xml
//     * @return errorList if validator fails
//     * @throws ValidationException if exception occurs
//     */
//    @SuppressWarnings("")
//    public static List<String> validate(String xml) throws ValidationException {
//        try {
//            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//            documentBuilderFactory.setNamespaceAware(true);
//            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//            Document document = documentBuilder.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
//            ValidationErrorHandler errorHandler = new ValidationErrorHandler();
//            Validator validator = schema.newValidator();
//            validator.setErrorHandler(errorHandler);
//            validator.validate(new DOMSource(document));
//            return errorHandler.getErrors();
//        } catch (Exception e) {
//            throw new ValidationException(e.getMessage());
//        }
//    }
//
//    /**
//     * @param xml The xml
//     * @return errorList if validator fails
//     * @throws ValidationException if exception occurs
//     */
//    @SuppressWarnings("")
//    public static List<String> validate(JAXBElement<AimsDomainMessageType> xml) throws no.avinor.aims.validation.ValidationException {
//        try {
//            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
//            documentBuilderFactory.setNamespaceAware(true);
//            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
//            Document document = documentBuilder.parse(new ByteArrayInputStream(marshall(xml).getBytes(StandardCharsets.UTF_8)));
//            ValidationErrorHandler errorHandler = new ValidationErrorHandler();
//            Validator validator = schema.newValidator();
//            validator.setErrorHandler(errorHandler);
//            validator.validate(new DOMSource(document));
//            return errorHandler.getErrors();
//        } catch (Exception e) {
//            throw new no.avinor.aims.validation.ValidationException(e.getMessage());
//        }
//    }
//
//    public static List<String> validate(Object xml) throws ValidationException {
//        return validate(OBJECT_FACTORY.createAimsMessage(xml));
//    }
}