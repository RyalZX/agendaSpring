package com.agenda.agenda.repository;

import com.agenda.agenda.Entity.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ContactRepository extends MongoRepository<Contact, String> {

    @Query(" { 'idAccount': ?0, '$or': [ { 'nome': {'$regex':?1} }, { 'cognome': {'$regex':?1} }, { 'numero': {'$regex':?1} }, { 'email': {'$regex':?1} } ] } ")
    List<Contact> findByIdAccountAndKeyword(String idAccount, String keyword);

    @Query(" { 'idAccount': ?0 } ")
    List<Contact> findByIdAccount(String idAccount);


}
