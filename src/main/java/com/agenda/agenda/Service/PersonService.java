package com.agenda.agenda.Service;

import com.agenda.agenda.Entity.Person;
import com.agenda.agenda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private UserRepository userRepository;

    public Person savePerson(Person person) {
        return userRepository.save(person);
    }

    public List<Person> getAllPeople(String keyword) {
        if (keyword != null) {
            return userRepository.findByKeyword(keyword);
        }
        return userRepository.findAll();
    }

    public Person getPersonById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public String deletePerson(UUID id) {
        userRepository.deleteById(id);
        return "persona eliminata";
    }

    public Person updatePerson(Person person) {
        Person existingPerson = userRepository.findById(person.getId())
                .orElse(null);
        existingPerson.setNome(person.getNome());
        existingPerson.setCognome(person.getCognome());
        existingPerson.setNumero(person.getNumero());
        existingPerson.setEmail(person.getEmail());
        return userRepository.save(existingPerson);
    }
}
