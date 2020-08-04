package com.agenda.agenda.api;

import com.agenda.agenda.Entity.Contact;
import com.agenda.agenda.Service.ContactService;
import com.agenda.agenda.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contacts")
@RestController
public class AgendaController {

    @Autowired
    private ContactRepository userRepository;

    @Autowired
    private ContactService contactService;


    //POST
    @PostMapping("/")
    public Contact addPerson(@RequestBody Contact person) {
        return contactService.savePerson(person);
    }

    //GET
    @GetMapping("/{id_account}")
    public List<Contact> findAllPeople(@PathVariable("id_account") Integer id_account, @Param("keyword") String keyword) {
        return contactService.getAllPeople(id_account, keyword);
    }

    //UPDATE
    @PutMapping("/")
    public Contact updatePerson(@RequestBody Contact person) {
        return contactService.updatePerson(person);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable UUID id) {
        return contactService.deletePerson(id);
    }

    @GetMapping("/test")
    public String test() {
        return "connessione al back-end riuscita";
    }

}
