package ee.esport.spring2018.web.ticket;

import ee.esport.spring2018.web.email.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

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
    public void buyTicket(Ticket ticket, String referrer) {
        ticket.setStatus(TicketStatus.AWAITING_PAYMENT);
        ticket.setDateCreated(OffsetDateTime.now());
        ticket.setId(ticketRepository.addTicket(ticket));
        ticket.setType(ticketRepository.getTicketType(ticket.getType().getId()));
        String loginLinkKey = ticketRepository.createLoginLink(ticket.getId());
        String loginLink = UriComponentsBuilder.fromUriString(referrer)
                                               .replacePath("/")
                                               .fragment("/ticketLogin/" + loginLinkKey)
                                               .toUriString();
        emailService.sendTicketReservation(ticket,
                                           loginLink).get();
    }

    public Integer getLoginLinkTicketId(String key) {
        return ticketRepository.getLoginLinkTicketId(key);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.getAllTickets();
    }

}
