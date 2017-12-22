package ee.esport.spring2018.web.ticket;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TicketType {

    private int Id;
    private String name;
    private int amountAvailable;
    private BigDecimal baseCost;

}
