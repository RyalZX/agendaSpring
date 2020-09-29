package com.agenda.agenda.Service;

import com.agenda.agenda.Entity.Account;
import com.agenda.agenda.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @CreatedDate
    public Account saveAccount(Account account) {
        Account existingAccountNick = accountRepository.findByNickname(account.getNickname());
        if (existingAccountNick != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "There is already another account with that name");
        }
        Account existingAccountMail = accountRepository.findByEmail(account.getEmail());
        if (existingAccountMail != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "There is already another account with that email");
        }
        account.setCreationdate(Instant.now());
        return accountRepository.save(account);
    }

    public String deleteAccount(String id) {
        accountRepository.deleteById(id);
        return "account eliminato";
    }

    public Account updateAccount(Account account) {
        Account existingAccount = accountRepository.findById(String.valueOf(account.getId()))
                .orElse(null);
        existingAccount.setPassword(account.getPassword());
        return accountRepository.save(existingAccount);
    }

    public Account activeAccount(String id) {
        Account existingAccount = accountRepository.findById(id)
                .orElse(null);
        existingAccount.setActivated(true);
        return accountRepository.save(existingAccount);
    }

    public Account getAccount(String nickname, String password) {
        return accountRepository.findByNicknameAndPassword(nickname, password);
    }

    public String getAccountByNick(String nickname) {
        Account existingAccount = accountRepository.findByNickname(nickname);
        if (existingAccount != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "There is already another account with that name");
        }
        return null;
    }

    public String getAccountByEmail(String email) {
        Account existingAccount = accountRepository.findByEmail(email);
        if (existingAccount != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "There is already another account with that email");
        }
        return null;
    }

}
