package com.agenda.agenda.repository;

import com.agenda.agenda.Entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AccountRepository extends MongoRepository<Account, String> {

    Account findByNicknameAndPassword(String nickname, String password);

}
