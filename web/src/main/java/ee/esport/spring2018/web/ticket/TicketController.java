package ee.esport.spring2018.web.ticket;

import ee.esport.spring2018.web.auth.EsportClaimsHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/api")
public class TicketController {

    @Resource
    private TicketService ticketService;

    @GetMapping("/ticketTypes")
    public ResponseEntity<List<TicketType>> getAllTicketTypes() {
        return new ResponseEntity<>(ticketService.getAllTypes(), HttpStatus.OK);
    }

    @PostMapping("/ticketType")
    public ResponseEntity<Void> addTicketTypes(@RequestBody TicketType type, EsportClaimsHolder claimsHolder) {
        if (!claimsHolder.get().isAdmin()) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        ticketService.addType(type);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return new ResponseEntity<>(ticketService.getAllTickets(), HttpStatus.OK);
    }

    @PostMapping("/ticket")
    public ResponseEntity<Void> buyTicket(@RequestBody Ticket ticket) {
        ticketService.buyTicket(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
