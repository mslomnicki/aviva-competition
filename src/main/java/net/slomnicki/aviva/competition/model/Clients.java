package net.slomnicki.aviva.competition.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Package class form Client objects
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Data
@XmlRootElement(name = "clients")
public class Clients {
    @XmlElements(@XmlElement(name = "client"))
    private List<Client> clientList;
}
