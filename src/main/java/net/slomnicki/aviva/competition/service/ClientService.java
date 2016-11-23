package net.slomnicki.aviva.competition.service;

import net.slomnicki.aviva.competition.error.XmlParseException;
import net.slomnicki.aviva.competition.model.Client;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
public interface ClientService {
    List<Client> findAll();

    Client findOne(Long id);

    void save(Client client);

    void delete(Client client);

    void saveXmlFileToDatabase(MultipartFile xmlFile) throws XmlParseException;
}
