package org.socialman.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.socialman.domain.Post;
import org.socialman.domain.PostType;
import org.socialman.domain.User;
import org.socialman.persistence.config.PersistenceTestConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceTestConfig.class})
public class UserRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private UserRepository userRepository;

    @Test
    public void shouldPersistUser() {
        User user = new User("rbalazsi", "securePass", "Robert", "Balazsi");
        user.addPost(new Post(user, PostType.POST, "This is a sample post", null));
        userRepository.save(user);

        assertNotNull(user.getPosts().get(0).getId());
    }
}
