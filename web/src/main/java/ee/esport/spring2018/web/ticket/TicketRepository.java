package ee.esport.spring2018.web.ticket;

import ee.esport.spring2018.jooq.tables.records.TicketTypesRecord;
import ee.esport.spring2018.jooq.tables.records.TicketsRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ee.esport.spring2018.jooq.Tables.TICKETS;
import static ee.esport.spring2018.jooq.Tables.TICKET_LOGIN_LINKS;
import static ee.esport.spring2018.jooq.Tables.TICKET_TYPES;

@Service
public class TicketRepository {

    @Resource
    private DSLContext dsl;

    public int addType(TicketType type) {
        TicketTypesRecord record = dsl.newRecord(TICKET_TYPES, type);
        record.store();
        return record.getId();
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

    public int addTicket(Ticket ticket) {
        TicketsRecord record = dsl.newRecord(TICKETS, ticket)
                                  .with(TICKETS.TYPE_ID, Optional.of(ticket)
                                                                 .map(Ticket::getType)
                                                                 .map(TicketType::getId)
                                                                 .orElse(null));
        record.store();
        return record.getId();
    }

    public String createLoginLink(int ticketId) {
        String name = UUID.randomUUID()
                          .toString();
        dsl.newRecord(TICKET_LOGIN_LINKS)
           .with(TICKET_LOGIN_LINKS.NAME, name)
           .with(TICKET_LOGIN_LINKS.TICKET_ID, ticketId)
           .store();
        return name;
    }

    public Integer getLoginLinkTicketId(String name) {
        return dsl.select(TICKET_LOGIN_LINKS.TICKET_ID)
                  .from(TICKET_LOGIN_LINKS)
                  .where(TICKET_LOGIN_LINKS.NAME.eq(name))
                  .fetchAny(TICKET_LOGIN_LINKS.TICKET_ID);
    }

    public List<Ticket> getAllTickets() {
        return dsl.select()
                .from(TICKETS)
                .leftJoin(TICKET_TYPES)
                .onKey()
                .fetch(record -> {
                    Ticket ticket = record.into(TICKETS).into(Ticket.class);
                    ticket.setType(record.into(TICKET_TYPES).into(TicketType.class));
                    return ticket;
                });
    }

    //TODO: optimize
    public TicketType getTicketType(int typeId) {
        Queue<TicketType> types = new ArrayDeque<>(getAllTypes());
        while (!types.isEmpty()) {
            TicketType type = types.poll();
            if (type.getId() == typeId) {
                return type;
            }
            List<TicketType> promotions = type.getPromotions();
            if (promotions != null) {
                types.addAll(promotions);
            }
        }
        return null;
    }
}
