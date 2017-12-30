package ee.esport.spring2018.web.email;

import ee.esport.spring2018.web.ticket.TicketType;
import lombok.RequiredArgsConstructor;
import net.sargue.mailgun.Mail;
import net.sargue.mailgun.MailRequestCallback;
import net.sargue.mailgun.Response;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.StringWriter;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Resource
    private final MailgunConfiguration mailgunConfig;

    @Resource
    private final VelocityEngine velocityEngine;

    public CompletableFuture<Response> sendTicketReservation(String to, TicketType ticketType, String loginLinkKey) {
        VelocityContext context = new VelocityContext();
        context.put("ticketType", ticketType);
        context.put("loginLinkKey", loginLinkKey);
        Mail mail = Mail.using(mailgunConfig)
                         .to(to)
                         .subject("Title")
                         .html(renderEmail("ticketReserved", context))
                         .build();
        return sendAsync(mail);
    }

    private CompletableFuture<Response> sendAsync(Mail mail) {
        CompletableFuture<Response> future = new CompletableFuture<>();
        mail.sendAsync(new MailRequestCallback() {
            @Override
            public void completed(Response response) {
                future.complete(response);
            }

            @Override
            public void failed(Throwable throwable) {
                future.completeExceptionally(throwable);
            }
        });
        return future;
    }

    private String renderEmail(String templateName, VelocityContext context) {
        StringWriter writer = new StringWriter();
        try {
            velocityEngine.getTemplate("emailTemplates/" + templateName + ".vm").merge(context, writer);
            return writer.getBuffer().toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
