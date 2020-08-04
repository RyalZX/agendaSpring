package com.agenda.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agenda.agenda.Entity.Contact;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository("agenda")
public interface ContactRepository extends JpaRepository<Contact, UUID>, JpaSpecificationExecutor<Contact> {

    @Query(value = "SELECT c FROM Contact c WHERE c.id_account = ?1 AND (c.nome LIKE %?2% OR c.cognome LIKE %?2% OR c.numero LIKE %?2% OR c.email LIKE %?2%)")
    List<Contact> findByKeyword(Integer id_account, String keyword);

    @Query(value = "SELECT c FROM Contact c WHERE c.id_account = ?1")
    List<Contact> findPeople(Integer id_account);
}
