package com.agenda.agenda.api;

import com.agenda.agenda.Entity.Account;
import com.agenda.agenda.Service.AccountService;
import com.agenda.agenda.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public Account addAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @PutMapping("/update")
    public Account updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Integer id) {
        return accountService.deleteAccount(id);
    }

    @GetMapping("/findaccount")
    public Account findAccount(@Param("nickname") String nickname, @Param("password") String password) {
        return accountService.getAccount(nickname, password);
    }

}
