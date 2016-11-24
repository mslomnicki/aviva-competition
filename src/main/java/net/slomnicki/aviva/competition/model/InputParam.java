package net.slomnicki.aviva.competition.model;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * POJO class that maps InputParam XML tag
 *
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Data
@Entity
@Table(name = "client_params")
@XmlAccessorType(XmlAccessType.FIELD)
public class InputParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "value")
    private String value;
}
