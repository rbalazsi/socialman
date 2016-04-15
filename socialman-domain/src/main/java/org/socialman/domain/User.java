package org.socialman.domain;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * A registered user.
 */
@Entity
public class User {

    @Id
    @Getter
    private String userName;

    @Getter
    @Setter
    @NotNull
    // TODO: more complex validation: min 8 chars, special chars, history
    private String password;

    @Getter
    @Setter
    @NotNull
    private String firstName;

    @Getter
    @Setter
    @NotNull
    private String lastName;

    @Getter
    @Setter
    // TODO: validate - matches regex
    private String email;

    @Getter
    @Setter
    @Embedded
    private Address address;

    @Getter
    @Setter
    private AccountStatus accountStatus;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Post> posts = Lists.newArrayList();

    @OneToMany
    private List<User> friends = Lists.newArrayList();

    public User() {
        // for JPA
    }

    public User(String userName, String password, String firstName, String lastName) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<Post> getPosts() {
        return ImmutableList.copyOf(posts);
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void removePost(Post post) {
        posts.remove(post);
    }

    public List<User> getFriends() {
        return ImmutableList.copyOf(friends);
    }

    public void friend(User user) {
        friends.add(user);
    }

    public void unfriend(User user) {
        friends.remove(user);
    }
}
