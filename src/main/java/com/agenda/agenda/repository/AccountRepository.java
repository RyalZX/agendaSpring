package com.agenda.agenda.repository;

import com.agenda.agenda.Entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface AccountRepository extends MongoRepository<Account, String> {

    Account findByNicknameAndPassword(String nickname, String password);

    Account findByNickname(String nickname);

    Account findByEmail(String email);

    @Query("{}")
    List<Account> findAll();

}
