package net.slomnicki.aviva.competition.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
@Data
@AllArgsConstructor
public class FlashMessage {
    private Status status;
    private String message;

    public enum Status {
        SUCCESS, FAILURE
    }
}
