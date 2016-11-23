package net.slomnicki.aviva.competition.service;

import net.slomnicki.aviva.competition.error.XmlParseException;
import net.slomnicki.aviva.competition.model.Clients;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
public interface XmlParser {
    Clients readAndParseXmlFile(File file) throws XmlParseException;
    Clients readAndParseXmlFile(MultipartFile file) throws XmlParseException;
}
