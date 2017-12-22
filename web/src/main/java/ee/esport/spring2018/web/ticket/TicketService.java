package ee.esport.spring2018.web.ticket;

import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static ee.esport.spring2018.jooq.Tables.*;

@Service
public class TicketService {

    @Resource
    private DSLContext dsl;

    public void addType(TicketType type) {
        dsl.newRecord(TICKET_TYPES, type).store();
    }

    public List<TicketType> getAllTypes() {
        return dsl.select().from(TICKET_TYPES).fetchInto(TicketType.class);
    }

}
