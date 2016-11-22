package net.slomnicki.aviva.competition;

import net.slomnicki.aviva.competition.error.XmlParseException;
import net.slomnicki.aviva.competition.model.Clients;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * XML parser that parses clients XML
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
public class XmlParser {

    /**
     * Read and parse XML file
     * @param file input XML file
     * @return clients from XML file
     * @throws XmlParseException
     */
    public Clients readAndParseXmlFile(File file) throws XmlParseException {
        // Loading XML file
        try (InputStream is = new FileInputStream(file)) {
            // Create XML parser for Clients class and subclasses
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            // Parse file
            Clients clients = (Clients) jaxbUnmarshaller.unmarshal(is);
            return clients;
        } catch (FileNotFoundException e) {
            throw new XmlParseException("File " + file + " not found...");
        } catch (IOException e) {
            throw new XmlParseException("Problem with reading file " + file);
        } catch (JAXBException e) {
            throw new XmlParseException("Unable to parse XML data");
        }
    }
}
