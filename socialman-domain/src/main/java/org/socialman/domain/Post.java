package org.socialman.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 * A post made by a user. Posts can have replies, which are posts themselves.
 */
@Entity
public class Post extends AbstractEntity<Long> {

    @ManyToOne
    @Getter
    private User user;

    @Enumerated(EnumType.STRING)
    @Getter
    private PostType type;

    @Getter
    private String text;

    @ManyToOne
    @Getter
    private Post parent;

    public Post() {
        // for JPA
    }

    public Post(User user, PostType type, String text, Post parent) {
        this.user = user;
        this.type = type;
        this.text = text;
        this.parent = parent;
    }
}
