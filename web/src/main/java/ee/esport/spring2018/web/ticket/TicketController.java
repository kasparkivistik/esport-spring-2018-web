package ee.esport.spring2018.web.ticket;

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
    public ResponseEntity<Void> addTicketTypes(@RequestBody TicketType type) {
        ticketService.addType(type);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
