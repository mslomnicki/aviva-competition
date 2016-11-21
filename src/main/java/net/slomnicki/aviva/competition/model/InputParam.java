package net.slomnicki.aviva.competition.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO class that maps InputParam XML tag
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Data
@XmlRootElement(name = "inputParam")
public class InputParam {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "value")
    private String value;
}
