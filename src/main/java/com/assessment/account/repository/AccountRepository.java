package com.assessment.account.repository;

import com.assessment.account.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {

}
