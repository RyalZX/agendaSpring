package com.agenda.agenda;
import static org.junit.Assert.assertEquals;

import com.agenda.agenda.Entity.Account;
import com.agenda.agenda.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;


    @Test
    @Transactional
    public void checkAccount() {

        Account account = accountRepository.findByCredentials("gianluca01", "password");
        Integer a = 1;
        assertEquals(a, account.getId());


    }

}
