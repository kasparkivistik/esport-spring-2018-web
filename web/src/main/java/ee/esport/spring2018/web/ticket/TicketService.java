package ee.esport.spring2018.web.ticket;

import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ee.esport.spring2018.jooq.Tables.TICKET_TYPES;

@Service
public class TicketService {

    @Resource
    private DSLContext dsl;

    public void addType(TicketType type) {
        dsl.newRecord(TICKET_TYPES, type).store();
    }

    public List<TicketType> getAllTypes() {
        return withRelationsRelations(getAllTicketTypesFlat()).stream()
                                                              .filter(type -> type.getParentTicketTypeId() == null)
                                                              .collect(Collectors.toList());
    }

    private List<TicketType> withRelationsRelations(List<TicketType> ticketTypes) {
        Map<Integer, TicketType> typesById = ticketTypes.stream()
                                                        .collect(Collectors.toMap(TicketType::getId,
                                                                                  Function.identity()));
        ticketTypes.stream()
                   .filter(type -> type.getParentTicketTypeId() != null)
                   .forEach(type -> {
                       TicketType parentType = typesById.get(type.getParentTicketTypeId());
                       if (parentType.getPromotions() == null) {
                           parentType.setPromotions(new ArrayList<>());
                       }
                       parentType.getPromotions().add(type);
                   });
        return ticketTypes;
    }

    private List<TicketType> getAllTicketTypesFlat() {
        return dsl.select()
                  .from(TICKET_TYPES)
                  .fetchInto(TicketType.class);
    }

}
