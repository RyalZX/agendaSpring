package com.agenda.agenda.api;

import com.agenda.agenda.Entity.Contact;
import com.agenda.agenda.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "agendaspring.herokuapp.com")
@RequestMapping("/contacts")
@RestController
public class AgendaController {

    @Autowired
    private ContactService contactService;


    //POST
    @PostMapping("/")
    public Contact addPerson(@RequestBody Contact person) {
        return contactService.savePerson(person);
    }

    //GET
    @GetMapping("/{idAccount}")
    public List<Contact> findAllPeople(@PathVariable("idAccount") String idAccount, @Param("keyword") String keyword) {
        return contactService.getAllPeople(idAccount, keyword);
    }

    //UPDATE
    @PutMapping("/")
    public Contact updatePerson(@RequestBody Contact person) {
        return contactService.updatePerson(person);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable String id) {
        return contactService.deletePerson(id);
    }

    @GetMapping("/test")
    public String test() {
        return "connessione al back-end riuscita";
    }

}
