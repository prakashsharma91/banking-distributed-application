package org.besidescollege.accountservice.repository;


import org.besidescollege.domain.account.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {

}
