package com.agenda.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agenda.agenda.Entity.Person;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository("agenda")
public interface UserRepository extends JpaRepository<Person, UUID>, JpaSpecificationExecutor<Person> {

    @Query(value = "SELECT p FROM Person p WHERE p.nome LIKE %?1%"
    + "OR p.cognome LIKE %?1%"
    + "OR p.numero LIKE %?1%"
    + "OR p.email LIKE %?1%")
    List<Person> findByKeyword(String keyword);

}
