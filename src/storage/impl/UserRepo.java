package storage.impl;

import dto.User;

import java.util.Optional;

public interface UserRepo {
   Optional<User> findByUserName(final String userName);
   void save(User user);
}
