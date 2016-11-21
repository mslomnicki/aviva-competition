package net.slomnicki.aviva.competition.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.List;

/**
 * POJO class that maps client XML tag.
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Data
@XmlRootElement(name = "client")
public class Client {
    @XmlAttribute(name = "date")
    private String date;
    @XmlElements(@XmlElement(name = "inputParam"))
    private List<InputParam> inputParamList;
}
