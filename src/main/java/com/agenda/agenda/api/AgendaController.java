package com.agenda.agenda.api;

import com.agenda.agenda.Entity.Person;
import com.agenda.agenda.Service.PersonService;
import com.agenda.agenda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/agenda")
@RestController
public class AgendaController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonService personService;


    //da rivedere
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        try {
            return personService.savePerson(person);
        } catch (Exception e){
            //inserire messaggio di errore
            return null;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<Person> findAllProducts(@Param("keyword") String keyword) {
        //keyword = "gianluca";
        return personService.getAllPeople(keyword);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable UUID id) {
        return personService.getPersonById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable UUID id) {
        return personService.deletePerson(id);
    }

}
