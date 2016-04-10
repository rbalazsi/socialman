package org.socialman.persistence;


import org.socialman.domain.AbstractEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractRepository<E extends AbstractEntity<I>, I> implements Repository<E, I> {

    @PersistenceContext
    private EntityManager em;

    private Class<E> entityClass;

    public AbstractRepository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public E findById(I id) {
        return em.find(entityClass, id);
    }

    @Override
    public void store(E entity) {
        if (entity.getId() == null) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
    }

    @Override
    public void delete(E entity) {
        em.remove(entity);
    }
}
