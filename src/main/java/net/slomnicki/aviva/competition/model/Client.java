package net.slomnicki.aviva.competition.model;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * POJO class that maps client XML tag.
 *
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Data
@Entity
@Table(name = "clients")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlAttribute
    private String date;

    @XmlElement(name = "inputParam")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<InputParam> inputParamList;
}
