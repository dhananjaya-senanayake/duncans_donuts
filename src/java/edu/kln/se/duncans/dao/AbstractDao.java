package edu.kln.se.duncans.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public abstract class AbstractDao<PK extends Serializable, T> {

    @Autowired
    protected HibernateTemplate hibernateTemplate;
    
    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) hibernateTemplate.get(persistentClass, key);
    }
    

    public void persist(T entity) {
        hibernateTemplate.persist(entity);
    }
    
    public void save(T entity) {
        hibernateTemplate.save(entity);
    }

    public void merge(T entity) {
        hibernateTemplate.merge(entity);
    }

    public void delete(T entity) {
        hibernateTemplate.delete(entity);
    }
    

}
