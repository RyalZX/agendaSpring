package com.agenda.agenda.repository;

import com.agenda.agenda.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository("account")
public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {

    @Query(value = "SELECT a FROM Account a WHERE a.nickname = ?1 AND a.password = ?2")
    Account findByCredentials(String nickname, String password);

}
