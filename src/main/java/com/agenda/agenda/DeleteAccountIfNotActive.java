package com.agenda.agenda;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;

import com.agenda.agenda.Entity.Account;
import com.agenda.agenda.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//this component is used to delete inactive accounts after 24h after the creation
@Component
public class DeleteAccountIfNotActive {

    @Autowired
    private AccountRepository accountRepository;

    private final long dayInMilliseconds = 86400000;

    @Scheduled(cron = "0 0 0 * * ?") //run at 00:00 every day
    public void Delete() {
        Instant currentdate = Instant.now(); //actual date
        List<Account> allAccounts = accountRepository.findAll(); //all accounts

        for (int i = 0; i < allAccounts.size(); i++) {
            Instant creationDate = allAccounts.get(i).getCreationdate(); //the creation date of the account

            if (allAccounts.get(i).isActivated() == false) { //if the account is not activated
                if ( (currentdate.toEpochMilli() - creationDate.toEpochMilli()) >=  dayInMilliseconds) { //remove the account if is not activated in 24h from the creation
                    Account accountToDelete = allAccounts.get(i);
                    accountRepository.deleteById(accountToDelete.getId());
                }
            }
        }
    }
}