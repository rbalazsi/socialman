package org.socialman.domain;

import lombok.AccessLevel;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by robi on 4/3/16.
 */
@MappedSuperclass
public abstract class BaseEntity<T> {

    @Id
    @Getter(AccessLevel.PUBLIC)
    @GeneratedValue
    protected T id;

    public BaseEntity() {
        // for JPA
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;

        return new EqualsBuilder().append(id, that.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).hashCode();
    }
}
