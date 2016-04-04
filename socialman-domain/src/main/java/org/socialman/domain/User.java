package org.socialman.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * A registered user.
 */
@Entity
public class User extends BaseEntity<Long> {

    @Getter
    @Setter
    private String userName;

    @Getter
    @Setter
    private String password;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @OneToMany
    @Getter
    private List<Post> posts;

    public User(String userName, String password, String firstName, String lastName) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
