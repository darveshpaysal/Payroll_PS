package com.base.common.util;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author raman
 */
public class XmlUtil {

    public static <T> String marshal(T rootClass) {
        StringWriter writer = new StringWriter();
        try {
            if (rootClass != null) {
                JAXBContext jaxbContext = JAXBContext.newInstance(rootClass.getClass());
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(rootClass, writer);
            }
        } catch (JAXBException e) {
            //do nothing
            e.printStackTrace();
        }
        return writer.toString();
    }
    public static <T> String marshalWithHeader(T rootClass) {
        StringWriter writer = new StringWriter();
        try {
            if (rootClass != null) {
                JAXBContext jaxbContext = JAXBContext.newInstance(rootClass.getClass());
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(rootClass, writer);
            }
        } catch (JAXBException e) {
            //do nothing
            e.printStackTrace();
        }
        return writer.toString();
    }

    public static <T> T unMarshal(T rootClass, String xmlString) {
        T respRootClass = null;
        try {
            if (xmlString != null) {
                JAXBContext jaxbContext = JAXBContext.newInstance(rootClass.getClass());
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                respRootClass = (T) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));
            }
        } catch (JAXBException e) {
            //do nothing
            e.printStackTrace();
        }
        return respRootClass;
    }
}
