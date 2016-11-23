package net.slomnicki.aviva.competition.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * POJO class that maps client XML tag.
 *
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Data
@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
public class Client {
    @XmlAttribute
    private String date;

    @XmlElement(name = "inputParam")
    private List<InputParam> inputParamList;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Client:").append(System.lineSeparator());
        sb.append("\tDate: ").append(date).append(System.lineSeparator());
        sb.append("\tInput parameters:").append(System.lineSeparator());
        inputParamList.forEach(sb::append);
        return sb.toString();
    }
}
