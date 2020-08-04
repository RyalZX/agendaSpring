package com.agenda.agenda;
import static org.junit.Assert.assertEquals;

import com.agenda.agenda.Entity.Account;
import com.agenda.agenda.Entity.Contact;
import com.agenda.agenda.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private ContactRepository userRepository;

    @Test
    @Transactional
    public void checkUser() {

        // check if the account with id 1 doesn't have contacts

        List<Contact> person = userRepository.findPeople(1);
        Boolean a = false; //is false 'cause list person is not empty
        assertEquals(a, person.isEmpty());  //conditions: false, false

    }

}
