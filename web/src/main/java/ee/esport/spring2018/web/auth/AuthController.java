package ee.esport.spring2018.web.auth;

import ee.esport.spring2018.web.ticket.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api")
public class AuthController {

    @Resource
    private TicketService ticketService;

    @Resource
    private JwtService jwtService;

    @GetMapping("/token/ticket/{loginLinkKey}")
    public ResponseEntity<String> getTicketJwt(@PathVariable String loginLinkKey) {
        Integer ticketId = ticketService.getLoginLinkTicketId(loginLinkKey);
        if (ticketId == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        EsportClaims claims = new EsportClaims().setTicketId(ticketId);
        return new ResponseEntity<>(jwtService.createFromClaims(claims), HttpStatus.OK);
    }


}
