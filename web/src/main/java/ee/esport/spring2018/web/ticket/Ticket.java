package ee.esport.spring2018.web.ticket;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import java.time.OffsetDateTime;

@Data
public class Ticket {

    private int id;
    private TicketType type;

    @Email
    private String ownerEmail;
    private String ownerSteamId;
    private TicketStatus status;
    private OffsetDateTime dateCreated;

}
