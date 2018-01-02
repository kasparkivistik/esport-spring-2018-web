package ee.esport.spring2018.web.ticket;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private Integer teamSize;
    private Integer atLocationCost;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TicketType> promotions;

}
