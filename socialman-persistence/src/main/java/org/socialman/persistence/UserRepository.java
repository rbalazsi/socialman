package org.socialman.persistence;


import org.socialman.domain.User;

public interface UserRepository {

    User findByUserName(String userName);

    void save(User user);

    void update(User user);

    void delete(User user);
}
