package net.slomnicki.aviva.competition.model;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * POJO class that maps client XML tag.
 *
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Data
@Entity
@Table(name="clients")
@XmlRootElement(name = "client")
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
