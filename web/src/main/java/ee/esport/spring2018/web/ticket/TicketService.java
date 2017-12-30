package ee.esport.spring2018.web.ticket;

import ee.esport.spring2018.web.email.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    @Resource
    private final TicketRepository ticketRepository;

    @Resource
    private final EmailService emailService;

    public List<TicketType> getAllTypes() {
        return ticketRepository.getAllTypes();
    }

    public TicketType getType(int typeId) {
        return ticketRepository.getTicketType(typeId);
    }

    public void addType(TicketType type) {
        ticketRepository.addType(type);
    }

    @SneakyThrows //temporarily wait for emailService to finish sending email, just in case
    public void buyTicket(Ticket ticket) {
        ticket.setStatus(TicketStatus.AWAITING_PAYMENT);
        ticket.setDateCreated(OffsetDateTime.now());
        int ticketId = ticketRepository.addTicket(ticket);
        String loginLink = ticketRepository.createLoginLink(ticketId);
        emailService.sendTicketReservation(ticket.getOwnerEmail(),
                                           ticketRepository.getTicketType(ticket.getType().getId()),
                                           loginLink).get();
    }

    public Integer getLoginLinkTicketId(String key) {
        return ticketRepository.getLoginLinkTicketId(key);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.getAllTickets();
    }

}
