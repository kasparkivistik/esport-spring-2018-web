package ee.esport.spring2018.web.ticket;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class TicketType {

    private int Id;
    private String name;
    private int amountAvailable;
    private BigDecimal cost;
    private OffsetDateTime availableFrom;
    private OffsetDateTime availableUntil;
    private Integer parentTicketTypeId;
    private List<TicketType> promotions;

}
