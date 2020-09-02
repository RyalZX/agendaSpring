package com.agenda.agenda.Service;

import com.agenda.agenda.Entity.Account;
import com.agenda.agenda.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account account) {
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

}
