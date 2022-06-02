package storage;

import dto.Account;

import java.util.Optional;

public interface AccountRepo {

    Account save(Account account);
    Optional<Account> findById(final Long id);
    Optional<Account> findByUserId(final Long userId);
}
