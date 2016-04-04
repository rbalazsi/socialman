package org.socialman.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.socialman.domain.User;
import org.socialman.persistence.config.PersistenceTestConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

/**
 * Created by robi on 4/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceTestConfig.class})
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void shouldPersistUser() {
        User user = new User("rbalazsi", "securePass", "Robert", "Balazsi");
        userRepository.save(user);

        assertNotNull(user.getId());
    }
}