package com.agenda.agenda.Service;

import com.agenda.agenda.Entity.Account;
import com.agenda.agenda.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account account) {
        Account existingAccount = accountRepository.findByNickname(account.getNickname());
        if (existingAccount != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "There is already another account with that name");
        }
        return accountRepository.save(account);
    }

    public String deleteAccount(String id) {
        accountRepository.deleteById(id);
        return "account eliminato";
    }

    public Account updateAccount(Account account) {
        Account existingAccount = accountRepository.findById(String.valueOf(account.getId()))
                .orElse(null);
        existingAccount.setNickname(account.getNickname());
        existingAccount.setPassword(account.getPassword());
        return accountRepository.save(existingAccount);
    }

    public Account getAccount(String nickname, String password) {
        return accountRepository.findByNicknameAndPassword(nickname, password);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public String getAccountByNick(String nickname) {
        Account existingAccount = accountRepository.findByNickname(nickname);
        if (existingAccount != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "There is already another account with that name");
        }
        return null;
    }

}
