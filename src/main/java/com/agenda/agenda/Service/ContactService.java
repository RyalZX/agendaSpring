package com.agenda.agenda.Service;

import com.agenda.agenda.Entity.Contact;
import com.agenda.agenda.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact savePerson(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> getAllPeople(Integer id_account, String keyword) {
        if (keyword != null) {
            return contactRepository.findByKeyword(id_account ,keyword);
        }
        return contactRepository.findPeople(id_account);
    }

    public String deletePerson(UUID id) {
        contactRepository.deleteById(id);
        return "persona eliminata";
    }

    public Contact updatePerson(Contact contact) {
        Contact existingPerson = contactRepository.findById(contact.getId())
                .orElse(null);
        existingPerson.setNome(contact.getNome());
        existingPerson.setCognome(contact.getCognome());
        existingPerson.setNumero(contact.getNumero());
        existingPerson.setEmail(contact.getEmail());
        return contactRepository.save(existingPerson);
    }
}
