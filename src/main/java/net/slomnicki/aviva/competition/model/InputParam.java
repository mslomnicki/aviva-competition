package net.slomnicki.aviva.competition.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * POJO class that maps InputParam XML tag
 *
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class InputParam {
    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "value")
    private String value;

    @Override
    public String toString() {
        return "\t\t" + name + ": " + value + System.lineSeparator();
    }
}
