package com.agenda.agenda.repository;

import com.agenda.agenda.Entity.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ContactRepository extends MongoRepository<Contact, String> {

    /*@Query(value = "SELECT c FROM Contact c WHERE c.id_account = ?1 AND (c.nome LIKE %?2% OR c.cognome LIKE %?2% OR c.numero LIKE %?2% OR c.email LIKE %?2%)")
    List<Contact> findByKeyword(Integer id_account, String keyword);

    @Query(value = "SELECT c FROM Contact c WHERE c.id_account = ?1")
    List<Contact> findPeople(Integer id_account); */

    /*@Query(" { 'id_account': ?0, and or or or } ")
    List<Contact> findByIdAccountAndKeyword(String idAccount, String keyword); */

    @Query(" { 'idAccount': ?0 } ")
    List<Contact> findByIdAccount(String idAccount);


}
