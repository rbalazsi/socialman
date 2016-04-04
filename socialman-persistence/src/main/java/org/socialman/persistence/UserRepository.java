package org.socialman.persistence;

import org.socialman.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by robi on 4/3/16.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
