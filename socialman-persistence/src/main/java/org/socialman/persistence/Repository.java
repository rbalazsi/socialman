package org.socialman.persistence;

import org.socialman.domain.AbstractEntity;


public interface Repository<E extends AbstractEntity<I>, I> {

    E findById(I id);

    void store(E entity);

    void delete(E entity);
}
