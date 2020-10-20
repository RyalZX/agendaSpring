package com.agenda.agenda.api;

import com.agenda.agenda.Entity.Account;
import com.agenda.agenda.Service.AccountService;
import com.agenda.agenda.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@CrossOrigin(origins = "*")
@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @PostMapping("/")
    public Account addAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @PutMapping("/")
    public Account updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable String id) {
        return accountService.deleteAccount(id);
    }

    @GetMapping("/")
    public Account findAccount(@Param("nickname") String nickname, @Param("password") String password) {
        return accountService.getAccount(nickname, password);
    }

    @GetMapping("/nickname/{nickname}")
    public String findAccountByNick(@PathVariable String nickname) {
        return accountService.getAccountByNick(nickname);
    }

    @GetMapping("/email/{email}")
    public String findAccountByEmail(@PathVariable String email) {
        return accountService.getAccountByEmail(email);
    }

    @GetMapping("/active/{id}")
    public Account active(@PathVariable("id") String id, HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "https://agendalauro.netlify.app/#/active");
        httpServletResponse.setStatus(302);
        return accountService.activeAccount(id);
    }

}
