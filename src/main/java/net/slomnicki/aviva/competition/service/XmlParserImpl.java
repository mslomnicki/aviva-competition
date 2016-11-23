package net.slomnicki.aviva.competition.service;

import net.slomnicki.aviva.competition.error.XmlParseException;
import net.slomnicki.aviva.competition.model.Clients;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * XML parser that parses clients XML
 *
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Service
public class XmlParserImpl implements XmlParser {

    /**
     * Read and parse XML file
     *
     * @param file input XML file
     * @return clients from XML file
     * @throws XmlParseException
     */
    @Override
    public Clients readAndParseXmlFile(File file) throws XmlParseException {
        // Loading XML file
        try (InputStream is = new FileInputStream(file)) {
            return readAndParseXmlStream(is);
        } catch (FileNotFoundException e) {
            throw new XmlParseException("File " + file + " not found...");
        } catch (IOException e) {
            throw new XmlParseException("Problem with reading file " + file);
        } catch (JAXBException e) {
            throw new XmlParseException("Unable to parse XML data");
        }
    }

    @Override
    public Clients readAndParseXmlFile(MultipartFile file) throws XmlParseException {
        try {
            return readAndParseXmlStream(file.getInputStream());
        } catch (JAXBException e) {
            throw new XmlParseException("Unable to parse XML data");
        } catch (IOException e) {
            throw new XmlParseException("Problem with reading file");
        }
    }

    private Clients readAndParseXmlStream(InputStream is) throws JAXBException {
        // Create XML parser for Clients class and subclasses
        JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        // Parse file
        Clients clients = (Clients) jaxbUnmarshaller.unmarshal(is);
        return clients;
    }
}
