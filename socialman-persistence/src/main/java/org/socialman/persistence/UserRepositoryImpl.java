package org.socialman.persistence;

import org.socialman.domain.User;

@org.springframework.stereotype.Repository
public class UserRepositoryImpl extends AbstractRepository<User, Long> implements UserRepository {

    public UserRepositoryImpl() {
        super(User.class);
    }
}
