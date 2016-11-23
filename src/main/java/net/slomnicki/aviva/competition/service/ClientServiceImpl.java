package net.slomnicki.aviva.competition.service;

import net.slomnicki.aviva.competition.error.XmlParseException;
import net.slomnicki.aviva.competition.model.Client;
import net.slomnicki.aviva.competition.model.Clients;
import net.slomnicki.aviva.competition.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository repository;
    private XmlParser parser;

    @Autowired
    public ClientServiceImpl(ClientRepository repository,
                             XmlParser parser) {
        this.repository = repository;
        this.parser = parser;
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void save(Client client) {
        repository.save(client);
    }

    @Override
    public void delete(Client client) {
        repository.delete(client);
    }

    @Override
    public void saveXmlFileToDatabase(MultipartFile xmlFile) throws XmlParseException {
        Clients clients = parser.readAndParseXmlFile(xmlFile);
        repository.save(clients.getClientList());
    }

}
