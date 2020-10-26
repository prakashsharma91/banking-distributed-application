package org.besidescollege.accountservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.besidescollege.accountservice.repository.AccountRepository;
import org.besidescollege.domain.account.Account;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AccountController {

  @Autowired
  AccountRepository accountRepository;

  @GetMapping("/accounts")
  public ResponseEntity<List<Account>> getAllAccounts(@RequestParam(required = false) String name) {
    try {
      List<Account> accounts = new ArrayList<Account>();

      if (name == null)
        accountRepository.findAll().forEach(accounts::add);

      if (accounts.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(accounts, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/accounts/{id}")
  public ResponseEntity<Account> getAccountById(@PathVariable("id") String id) {
    Optional<Account> accountData = accountRepository.findById(id);

    if (accountData.isPresent()) {
      return new ResponseEntity<>(accountData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/accounts")
  public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    try {
      Account _account = accountRepository
          .save(new Account(account.getName(), account.getAddress(), account.getPhone(), account.getPhoneAlternate()));
      return new ResponseEntity<>(_account, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/accounts/{id}")
  public ResponseEntity<Account> updateAccount(@PathVariable("id") String id, @RequestBody Account account) {
    Optional<Account> accountData = accountRepository.findById(id);

    if (accountData.isPresent()) {
      Account _account = accountData.get();
      _account.setName(account.getName());
      _account.setAddress(account.getAddress());
      _account.setPhone(account.getPhone());
      _account.setPhoneAlternate(account.getPhoneAlternate());
      return new ResponseEntity<>(accountRepository.save(_account), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/accounts/{id}")
  public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") String id) {
    try {
      accountRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/accounts")
  public ResponseEntity<HttpStatus> deleteAllAccounts() {
    try {
      accountRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
