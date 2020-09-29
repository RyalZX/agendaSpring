package com.agenda.agenda.api;

// using SendGrid's Java Library
// https://github.com/sendgrid/sendgrid-java
import com.agenda.agenda.Entity.Account;
import com.agenda.agenda.repository.AccountRepository;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin(origins = "*")
@RequestMapping("/activate")
@RestController
public class SendgridController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping
    public void activeAccount(@Param("email") String email, @Param("id") String id) throws IOException {
        Email from = new Email("giangi.lauro@gmail.com");
        String subject = "Attiva il tuo account su agendalauro";
        Email to = new Email(email);
        Content content = new Content("text/html", "<h1> Clicca <a href='https://agendaspring.herokuapp.com/account/active/" + id + "'>qui</a> per attivare il tuo account e iniziare ad usare il nostro servizio! </h1>");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }

    @GetMapping("/recover")
    public void recoverPassword(@Param("email") String email) throws IOException {
        Email from = new Email("giangi.lauro@gmail.com");
        String subject = "Recupera il tuo account su agendalauro";
        Email to = new Email(email);
        Account account = accountRepository.findByEmail(email);
        Content content = new Content("text/html", "<h1> Clicca <a href='https://agendalauro.herokuapp.com/updateaccount?id=" + account.getId() + "'>qui</a> per ripristinare la tua password " + account.getNickname() +  "</h1>");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("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");
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}
