package org.socialman.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * A post made by a user. Posts can have replies, which are posts themselves.
 */
@Entity
public class Post extends BaseEntity<Long> {

    @Enumerated(EnumType.STRING)
    private PostType type;

    private String text;
}
